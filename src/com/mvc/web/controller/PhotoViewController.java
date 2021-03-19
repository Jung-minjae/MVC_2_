package com.mvc.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Comment.commentDTO;
import Contents.PhotoContentDAO;
import Contents.PhotoContentDTO;




@WebServlet("/Photoview")
public class PhotoViewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String pid = req.getParameter("pid");
		
		
		
		
		PhotoContentDTO pd = PhotoContentDAO.getInstance().getPhotoDetail(pid);
		req.setAttribute("p", pd);
		
		int count = PhotoContentDAO.getInstance().getcommentCount(pid);
		req.setAttribute("count", count);
		if(count!=0) {
			List<commentDTO> clist = PhotoContentDAO.getInstance().getcommentList(pid);
			req.setAttribute("c", clist);
		}

		RequestDispatcher dis = req.getRequestDispatcher("WEB-INF/Photoview.jsp");
		dis.forward(req, resp);

}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String userID ="seetion";
		String comment = req.getParameter("comment");
		String score_ =req.getParameter("s");
		String pid =req.getParameter("pid");
		int score =Integer.parseInt(score_);
		
		commentDTO cd =new commentDTO();
		cd.setUserID(userID);
		cd.setPid(pid);
		cd.setScore(score);
		cd.setComment(comment);
		
		int result = PhotoContentDAO.getInstance().insertComment(cd);
		resp.sendRedirect("Photoview?pid="+pid);
	}
}
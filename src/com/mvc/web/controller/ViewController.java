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
import Contents.ContentsDao;
import Contents.Content;




@WebServlet("/view")
public class ViewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id = req.getParameter("contentID");
		
		System.out.println(id);
		
		int ContentID = Integer.parseInt(id);
		List<Content> detail_list = ContentsDao.getInstance().getDetail(ContentID);
		
		req.setAttribute("detail_list", detail_list);
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/view.jsp");
		dis.forward(req, resp);
}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html; charset=UTF-8");
//		String userID ="seetion";
//		String comment = req.getParameter("comment");
//		String score_ =req.getParameter("s");
//		String pid =req.getParameter("pid");
//		int score =Integer.parseInt(score_);
//		
//		commentDTO cd =new commentDTO();
//		cd.setUserID(userID);
//		cd.setPid(pid);
//		cd.setScore(score);
//		cd.setComment(comment);
//		
//		int result = Content.getInstance().insertComment(cd);
//		resp.sendRedirect("Photoview?pid="+pid);
//	}
}
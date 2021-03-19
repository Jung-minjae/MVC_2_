package com.mvc.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Contents.Content;
import Contents.ContentsDao;

@WebServlet("/write")
public class writeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dis = req.getRequestDispatcher("WEB-INF/write.jsp");
		dis.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
	    
	    PrintWriter out = resp.getWriter(); //java에서 스크립트로 알럴트창 띄울수 있게
//	    HttpSession session = req.getSession(true); //세션 생성하기
		ContentsDao cd = new ContentsDao();
		Content ct =new Content();
		String Title = req.getParameter("title");
		String content = req.getParameter("content");
		String id = req.getParameter("userid");
		
		System.out.println(Title);
		System.out.println(content);
		out.println
		("<script>alert('글쓰기 성공');"
		+ "location.href='border'"
		+ "</script>");
		int result = 0;
		
		result = cd.write(Title, id, content);

	
}
}

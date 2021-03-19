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

import user.UserDao;

@WebServlet("/login")
public class loginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dis = req.getRequestDispatcher("WEB-INF/login.jsp");
		dis.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		  PrintWriter out = resp.getWriter(); //java에서 스크립트로 알럴트창 띄울수 있게
		HttpSession session = req.getSession();
		UserDao ud = new UserDao();
		String id = req.getParameter("userID");
		String pass = req.getParameter("userPass");

		System.out.println(id);
		System.out.println(pass);

		int log = ud.login(id, pass);
		
		if(log ==-1) {

			resp.sendRedirect("login");
		}else if(log ==0) {

			resp.sendRedirect("login");
		}else if(log ==1) {
	        
	        session.setAttribute("id", id);
			out.println
			("<script>alert('로그인 성공');"
			+ "location.href='index'"
			+ "</script>");	
			resp.sendRedirect("index");
			
		}
	      String login = Integer.toString(log);

	      System.out.println(log);
	}
}

package com.mvc.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;
import user.UserDao;

@WebServlet("/join")
public class joinController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dis = req.getRequestDispatcher("WEB-INF/join.jsp");
		dis.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String userID = req.getParameter("userID");
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		String userGender = req.getParameter("userGender");
		String userEmail = (req.getParameter("userEmail"))+"@"+(req.getParameter("userEmail2"));
		String userPhone =req.getParameter("userPhone");
	
				
		System.out.println(userID);
		System.out.println(userName);
		System.out.println(userPass);
		System.out.println(userGender);
		System.out.println(userEmail);
		System.out.println(userPhone);
		
		User us = new User();

		us.setUserID(userID);
		us.setUserPass(userPass);
		us.setUserName(userName);
		us.setUserGender(userGender);
		us.setUserEmail(userEmail);
		us.setUserPhone(userPhone);

		UserDao ud = new UserDao();

		ud.join(us);
		resp.sendRedirect("index");
	}
}

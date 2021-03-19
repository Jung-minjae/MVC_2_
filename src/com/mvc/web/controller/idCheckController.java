package com.mvc.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import user.User;
import user.UserDao;

@WebServlet("/idCheck")
public class idCheckController extends HttpServlet {
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = req.getParameter("userID");	
		int check = UserDao.getInstance().idCheck(userID);	
		req.setAttribute("check", check);
		req.setAttribute("id", userID);
		req.getRequestDispatcher("/WEB-INF/idCheck.jsp").forward(req, resp);
	}

}

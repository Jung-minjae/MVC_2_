package com.mvc.web.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Contents.ContentsDao;

@WebServlet("/update")
public class UdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String contentID = req.getParameter("contentID");
		
		req.setAttribute("contentID", contentID);
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/update.jsp");
		dis.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String contentID_ = req.getParameter("contentID");
		System.out.println("contentID_ : " + contentID_);
		String title = req.getParameter("title");
		System.out.println("title : " + title);
		String content = req.getParameter("content");
		
		int contentID = Integer.parseInt(contentID_);
		
		ContentsDao cd = new ContentsDao();
		
		int relust = cd.update(contentID, title, content);
		
		resp.sendRedirect("view?contentID=" + contentID);
	}
}

package com.mvc.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Contents.ContentsDao;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String contentID_ = req.getParameter("contentID");
		int contentID = Integer.parseInt(contentID_);

		ContentsDao cd = new ContentsDao();

		int relust = cd.delete(contentID);

		resp.sendRedirect("border");
	}
}

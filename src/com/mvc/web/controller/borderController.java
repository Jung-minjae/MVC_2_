package com.mvc.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Contents.ContentsDao;
import Contents.Content;

@WebServlet("/border")
public class borderController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContentsDao ct = new ContentsDao();
		int pageNumber = 1;
		int count = 0;
		ArrayList<Content> list = null;

		String pageNumber_ = req.getParameter("pageNumber");
		if (pageNumber_ != null && !pageNumber_.equals("")) {
			pageNumber = Integer.parseInt(pageNumber_);
		}
		
		String f = req.getParameter("f");
		System.out.println("f : " + f);
		String o = req.getParameter("o");
		System.out.println("o : " + o);
		String q = req.getParameter("q");
		System.out.println("q : " + q);
		
		if ((f != null && !f.equals("")) && (q != null && !q.equals(""))) {
			switch (f) {
			case "Title":
				switch (o) {
				case "1":
					q = "%" + q + "%";
					System.out.println("케이스들어와서의 q : " + q);
					list = ct.getSelectList(pageNumber, f, q);
					count = ct.getSelectCount(f, q);
					System.out.println("스위치문 끝나고의 count : " + count);
					break;

				case "2":
					list = ct.getSelectList(pageNumber, f, q);
					count = ct.getSelectCount(f, q);
					break;
				}
				break;
			case "userID":
				System.out.println("111111111111");
				list = ct.getSelectList(pageNumber, f, q);
				count = ct.getSelectCount(f, q);
				break;
			}
		} else {
			System.out.println("123123123");
			count = ct.getCount();
			list = ct.getList(pageNumber);
		}
		
		System.out.println("count" + count);

		req.setAttribute("count", count);
		req.setAttribute("pageNumber", pageNumber);
		req.setAttribute("list", list);
		RequestDispatcher dis = req.getRequestDispatcher("WEB-INF/border.jsp");
		dis.forward(req, resp);
	}
}

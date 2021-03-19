package com.mvc.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Contents.PhotoContentDAO;
import Contents.PhotoContentDTO;




@WebServlet("/PhotoBoard")
public class PhotoBoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<PhotoContentDTO> PhotoList = PhotoContentDAO.getInstance().getPhotoList();
		req.setAttribute("plist",PhotoList);
		resp.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dis = req.getRequestDispatcher("WEB-INF/PhotoBoard.jsp");
		dis.forward(req, resp);

}
	
}
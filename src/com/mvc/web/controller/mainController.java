package com.mvc.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Jusic.JusicDAO;
import Jusic.JusicDTO;
import Jusic.JusicSubDTO;
import Jusic_.Jusic_kp_kd_DTO;
import Jusic_.Jusic_kp_kd_sub_DAO;
import Jusic_KP.JusicDAO_KP;
import Jusic_KP.JusicDTO_KP;
import Jusic_KP.JusicSubDTO_KP;

@WebServlet("/index")
public class mainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JusicDAO JD = new JusicDAO();
		JusicDTO jd = JD.getUP();
		JusicDAO_KP KP = new JusicDAO_KP();
		JusicDTO_KP KP_ = KP.getUP();
		
		
		for(int i =0; i<jd.getList1().size(); i++) {
			System.out.println("순서:"+jd.getList1().get(i));
			System.out.println("이름:"+jd.getList2().get(i));
			System.out.println("가격:"+jd.getList3().get(i));
			System.out.println("오른금액:"+jd.getList4().get(i));
			System.out.println("등락율:"+jd.getList5().get(i));
		System.out.println("=======================================");
		}
		List<JusicSubDTO>list = new ArrayList<JusicSubDTO>();
	
		JusicSubDTO js = null; 
		
		for(int i=0; i<(jd.getList1()).size(); i++) {
			String seq = jd.getList1().get(i);
			String name = jd.getList2().get(i);
			String price = jd.getList3().get(i);
			String upPrice = jd.getList4().get(i);
			String per = jd.getList5().get(i);
			
			 js = new JusicSubDTO(seq, name, price, upPrice, per);
			list.add(js);	
		}
		
		req.setAttribute("list", list);
		
		
		
		for(int j=0; j<KP_.getList1().size(); j++) {
			System.out.println("순서:"+KP_.getList1().get(j));
			System.out.println("이름:"+KP_.getList2().get(j));
			System.out.println("가격:"+KP_.getList3().get(j));
			System.out.println("오른금액:"+KP_.getList4().get(j));
			System.out.println("등락율:"+KP_.getList5().get(j));
		}
		
		List<JusicSubDTO_KP>list_1 = new ArrayList<JusicSubDTO_KP>();
		
		JusicSubDTO_KP jP = null; 
		
		for(int i=0; i<(KP_.getList1()).size(); i++) {
			String seq = KP_.getList1().get(i);
			String name = KP_.getList2().get(i);
			String price = KP_.getList3().get(i);
			String upPrice = KP_.getList4().get(i);
			String per = KP_.getList5().get(i);
			
			jP = new JusicSubDTO_KP(seq, name, price, upPrice, per);
			list_1.add(jP);	
		}
		req.setAttribute("list_1", list_1);
		
//		
//		List<Jusic_kp_kd_DTO>list_0 = new ArrayList<Jusic_kp_kd_DTO>();
//		
//		Jusic_kp_kd_DTO jKP = null; 
//		
//		for(int i=0; i<(jKP.getList1()).size(); i++) {
//			String seq = KP_.getList1().get(i);
//			System.out.println("코스피:"+seq);
//				list_0.add(jKP);	
//		}
//		req.setAttribute("list_0", list_0);

		RequestDispatcher dis = req.getRequestDispatcher("WEB-INF/index.jsp");
		dis.forward(req, resp);
	}
	
}



//주석달기
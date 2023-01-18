package sku.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	/**
	 * 주문하기
	 * */
	public ModelAndView orderInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("주문하기입니다.");
		
		//주문하기 -> service -> dao
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("order/result.jsp");
		return mv;
	}
	
	/**
	 * 상세보기
	 * */
	public ModelAndView orderInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("주문상세보기 입니다.");
		
		//service -> dao
		request.setAttribute("message", "주문정보 확인되었습니다.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("order/info.jsp");
		return mv;
	}
}

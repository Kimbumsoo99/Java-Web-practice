package kosta.mvc.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 상품관련 Controller
 * */
public class GoodsController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	
	/**
	 * 상품목록가져오기
	 * */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GoodsController의 list 호출되었습니다....");
		
	    request.setAttribute("goodsList", Arrays.asList("사과","딸기","포도","바나나"));
		
		return new ModelAndView("goods/list.jsp"); //forward이동
	}
	
	/**
	 * 상품등록 
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    System.out.println("GoodsController의 insert 호출되었습니다...");
	    
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("index.jsp");
	    mv.setRedirect(true);
	    
		return mv;
	}
	
}









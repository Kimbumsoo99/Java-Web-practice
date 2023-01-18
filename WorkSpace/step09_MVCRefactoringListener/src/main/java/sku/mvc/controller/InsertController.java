package sku.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("InsertController 호출되었습니다.....");
		
		//service호출 --> dao호출 -->등록이 완료되면 redirec방식으로 전체검색으로 이동
		
		ModelAndView mv = new ModelAndView("front?key=select", true);
		
		return mv;
	}

}

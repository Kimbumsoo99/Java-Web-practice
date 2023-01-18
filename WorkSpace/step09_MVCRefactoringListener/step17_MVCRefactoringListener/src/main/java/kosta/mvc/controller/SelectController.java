package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SelectController 호출되었습니다...");
		
		//service호출 --> dao호출해서 --> 검색결과를 영속성에 저장하고 결과뷰로 이동한다.
		
		request.setAttribute("message", "전체검색 결과 입니다.");//뷰에서 ${message}
		
		ModelAndView mv = new ModelAndView("selectResult.jsp");
		return mv;
	}

}

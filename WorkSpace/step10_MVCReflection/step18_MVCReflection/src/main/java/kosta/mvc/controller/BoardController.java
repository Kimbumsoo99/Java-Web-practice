package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 게시판에 관련된 Controller
 * */
public class BoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 게시물 검색하기
	 * */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardController의 list 호출되었습니다...");
		
		request.setAttribute("message", "검색결과입니다...");
		
		return new ModelAndView("board/list.jsp");
	}
	
	/**
	 * 상세보기
	 * */
	public ModelAndView read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardController의 read 호출되었습니다...");
		
		return new ModelAndView("board/read.jsp", true);
	}

}




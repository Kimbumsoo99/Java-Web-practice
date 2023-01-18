package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 회원관리에 관한 Controller 
 * */
public class UserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 로그인
	 * */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UserController의 login 호출되었습니다....");
		
		//service -> dao호출....
		
		//로그인성공하면 세션에 정보 저장
		HttpSession session = request.getSession();
		session.setAttribute("sessionMessage", "로그인된 정보입니다...");// 
		
		return new ModelAndView("user/login.jsp", true); //rediect방식으로이동한다.
	}
	
	
	/**
	 * 회원정보수정
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   
		System.out.println("UserController의 update 호출되었습니다. ");
		
		//서비스호출--> dao호출...
		
		request.setAttribute("message", "수정완료되었습니다..");

		return new ModelAndView("user/update.jsp"); //forward방식으로 이동하자.
	}
	
	/**
	 * 가입하기
	 * */
	
	/**
	 * 로그아웃 
	 * */
	

}

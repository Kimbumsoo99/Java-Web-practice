package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.mvc.dto.UserDTO;
import kosta.mvc.service.UserService;
import kosta.mvc.service.UserServiceImpl;

public class UserController implements Controller {
	
	private UserService userService = new UserServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 로그인 기능
	 * */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    
		 //두개의 전송되는 값을 받는다.
		String userId =request.getParameter("userId");
		String pwd =request.getParameter("pwd");
		
		//서비스 호출 
		UserDTO dbDTO = userService.loginCheck( new UserDTO(userId, pwd) );
		
		//로그인성공하면 세션에 정보를 저장 - ${loginUser} / ${loginName}
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", dbDTO);
		session.setAttribute("loginName", dbDTO.getName());

		//index.jsp이동 - redirect방식
		
		return new ModelAndView("index.jsp", true);
	}

	/**
	 * 로그아웃
	 * */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//모든 세션의정보를 삭제한다.
		request.getSession().invalidate();
		
		return new ModelAndView("index.jsp", true);
		
		
	}
	
}







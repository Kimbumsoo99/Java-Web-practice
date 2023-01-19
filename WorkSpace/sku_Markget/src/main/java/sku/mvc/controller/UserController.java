package sku.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import org.apache.tomcat.util.log.UserDataHelper.Mode;

import sku.mvc.dto.UserDTO;
import sku.mvc.service.UserService;
import sku.mvc.service.UserServiceImpl;

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
	
	/**
	 * 회원가입
	 * */
	public ModelAndView join(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		String userId =request.getParameter("userId");
		String pwd =request.getParameter("pwd");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		
		UserDTO userDTO =  new UserDTO(userId, pwd,name,age,phone,addr);
		userService.joinUser(userDTO);
		
		return new ModelAndView("index.jsp", true);
	}
	
	/**
	 * 수정하기
	 * */
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) 
		throws Exception{
		String userId =request.getParameter("userId");
		String pwd =request.getParameter("pwd");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		
		UserDTO userDTO = new UserDTO(userId, pwd, name, age, phone, addr);
		
		userService.updateUser(userDTO);
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", userDTO);
		
		return new ModelAndView("user/login.jsp", true);
	}
}
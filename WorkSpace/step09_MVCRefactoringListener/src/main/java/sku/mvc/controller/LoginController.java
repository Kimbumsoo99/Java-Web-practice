package sku.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginController 호출됨.");
		//전송된 id와 passwd 받기
		
		//전달된 정보를 service에게 전달하면 호출 -> dao를 호출
		
		//결과 받아서 ModelAndView를 return
		request.setAttribute("loginInfo", "로그인 성공!!");
		
		ModelAndView mv = new ModelAndView("loginResult.jsp");
		return mv;
	}
}

 package kosta.mvc.service;

import java.sql.SQLException;

import kosta.mvc.dto.UserDTO;
import kosta.mvc.exception.AuthenticationException;

public interface UserService {
	/**
	 * 로그인 체크
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;
}

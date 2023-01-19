 package sku.mvc.service;

import java.sql.SQLException;

import sku.mvc.dto.UserDTO;
import sku.mvc.exception.AuthenticationException;

public interface UserService {
	/**
	 * 로그인 체크
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;

   void joinUser(UserDTO userDTO)throws SQLException;
   
   void updateUser(UserDTO userDTO)throws SQLException;
}


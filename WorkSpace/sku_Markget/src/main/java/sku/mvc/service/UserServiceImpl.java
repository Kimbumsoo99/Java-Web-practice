package sku.mvc.service;

import java.sql.SQLException;

import sku.mvc.dao.UserDAO;
import sku.mvc.dao.UserDAOImpl;
import sku.mvc.dto.UserDTO;
import sku.mvc.exception.AuthenticationException;

public class UserServiceImpl implements UserService {
     private UserDAO userDAO = new UserDAOImpl();
  	
	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException, AuthenticationException {
		
		//dao호출
		UserDTO dbDTO = userDAO.loginCheck(userDTO);
		if(dbDTO == null) {
			throw new AuthenticationException("정보를 다시 확인해주세요.");
		}
		
		return dbDTO;
	}

	@Override
	public void joinUser(UserDTO userDTO) throws SQLException {
		int result = userDAO.joinUser(userDTO);
		if(result==0) {
			throw new SQLException("회원가입 실패");
		}
	}

	@Override
	public void updateUser(UserDTO userDTO) throws SQLException {
		int result = userDAO.updateUser(userDTO);
		if(result==0) {
			throw new SQLException("유저 정보 수정 실패");
		}
		
	}

	
}






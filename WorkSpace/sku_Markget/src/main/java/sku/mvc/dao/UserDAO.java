package sku.mvc.dao;

import java.sql.SQLException;

import sku.mvc.dto.UserDTO;

public interface UserDAO {
  /**
   * 로그인 기능
   * select user_id , pwd, name from users where user_id=? and pwd=?
   * */
	UserDTO loginCheck(UserDTO userDTO)throws SQLException;
	int joinUser(UserDTO userDTO)throws SQLException;
	UserDTO selectById(String id)throws SQLException;
	int updateUser(UserDTO userDTO)throws SQLException;
}

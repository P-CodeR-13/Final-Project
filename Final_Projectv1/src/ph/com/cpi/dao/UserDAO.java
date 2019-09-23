package ph.com.cpi.dao;

import java.sql.SQLException;
import java.util.List;

import ph.com.cpi.entities.User;

public interface UserDAO {
	List<User> getUsers() throws SQLException;
	void insertUser(User user) throws SQLException;
	User loginUser(String username,String password) throws SQLException;
}

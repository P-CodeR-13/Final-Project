package ph.com.cpi.service;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

import ph.com.cpi.entities.User;

public interface UserService {
	String insertUser(HttpServletRequest request) throws SQLException;
	String loginUser(HttpServletRequest request) throws SQLException;
	void updateUser(HttpServletRequest request) throws SQLException;
	void addToCart(HttpServletRequest req) throws SQLException;
}

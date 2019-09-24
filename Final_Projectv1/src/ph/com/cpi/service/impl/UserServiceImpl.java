package ph.com.cpi.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ph.com.cpi.dao.UserDAO;
import ph.com.cpi.service.UserService;
import ph.com.cpi.entities.Products;
import ph.com.cpi.entities.User;

public class UserServiceImpl implements UserService{
	
	private UserDAO usersDAO;
	
	public UserDAO getUsersDAO(){
		return this.usersDAO;
	}
	
	public void setUserDAO(UserDAO UsersDAO){
		this.usersDAO = UsersDAO;
	}

	@Override
	public void insertUser(HttpServletRequest request) throws SQLException {
		User users = setValuesToUser(request);
		this.usersDAO.insertUser(users);
	}
	
	// login
	@Override
	public String loginUser(HttpServletRequest request) throws SQLException {
		User user = this.usersDAO.loginUser(request.getParameter("username"), request.getParameter("password"));
		String account_type= "";
		HttpSession session = request.getSession();
		if(user != null) {
			if(user.getAccount() == 1) {
				account_type = "admin";
			}else {
				account_type = "user";
				session.setAttribute("id", session.getId());
				session.setAttribute("userId", user.getUserId());
				session.setAttribute("username", user.getUsername());
				session.setAttribute("password", user.getPassword());
				session.setAttribute("firstname", user.getFirstName());
				session.setAttribute("lastname", user.getLastName());
				session.setAttribute("email", user.getEmail());
				session.setAttribute("address", user.getAddress());
				session.setAttribute("contactNumber", user.getContactNumber());
			}
		}
		
		return account_type;
	}
	
	public void updateUser(HttpServletRequest request) throws SQLException {
		User user = new User();
		user.setUserId(Integer.parseInt(request.getParameter("userId")));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setEmail(request.getParameter("email"));
		user.setContactNumber(request.getParameter("contactNum"));
		user.setAddress(request.getParameter("address"));
		this.usersDAO.updateUser(user);
	}

	private User setValuesToUser(HttpServletRequest request) {
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setAddress(request.getParameter("address"));
		user.setContactNumber(request.getParameter("contactNumber"));	
		return user;
	}
	
}

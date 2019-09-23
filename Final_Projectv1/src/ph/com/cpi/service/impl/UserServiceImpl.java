package ph.com.cpi.service.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ph.com.cpi.dao.UserDAO;
import ph.com.cpi.service.UserService;

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
	
	private User setValuesToUser(HttpServletRequest request) {
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setAddress(request.getParameter("address"));
		user.setContactNumber( Integer.parseInt(request.getParameter("contactNumber")) );	
		System.out.println(user.toString());
		return user;
	}
}

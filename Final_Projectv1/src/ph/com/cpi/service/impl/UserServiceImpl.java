package ph.com.cpi.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ph.com.cpi.dao.UserDAO;
import ph.com.cpi.entities.Cart;
import ph.com.cpi.entities.User;
import ph.com.cpi.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDAO usersDAO;
	
	public UserDAO getUsersDAO(){
		return this.usersDAO;
	}
	
	public void setUserDAO(UserDAO UsersDAO){
		this.usersDAO = UsersDAO;
	}

	@Override
	public String insertUser(HttpServletRequest request) throws SQLException {
		String msg = "no";
		User users = setValuesToUser(request);
		boolean userExist = this.usersDAO.insertUser(users);
		if(userExist) {
			msg = "yes";
			request.setAttribute("error", "Failed to Signup. Please Change Username or Email.");
		}
		else {
			request.setAttribute("success", "Registration Complete. Please Sign In..");
		}
		return msg;
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
			}
			else {
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
				request.setAttribute("success", "Login Success");
			}
			request.setAttribute("error", "");
		}
		else {
			request.setAttribute("error", "Invalid Credentials");
			account_type = "invalid";
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
	
	@Override
	public void addToCart(HttpServletRequest req) throws SQLException {
		BigDecimal price = new BigDecimal(req.getParameter("price"));
		String productName = req.getParameter("prodName");
		Integer productId = Integer.parseInt(req.getParameter("prodId"));
		Integer stocks = Integer.parseInt(req.getParameter("stocks"));	
		String image = req.getParameter("image");
		BigDecimal total = new BigDecimal(0);
		BigDecimal grandTotal = new BigDecimal(0);
		Integer quantity = Integer.parseInt(req.getParameter("quantity"));
		
		HttpSession session = req.getSession();
		List<Cart> cartList = (List<Cart>) session.getAttribute("sessionList");
		boolean itemExist = false;
		
		if (cartList == null) {
			cartList = new ArrayList<Cart>();
		}
		
		if (productId != null) {
			if(cartList.size() == 0) {
				total = price.multiply(new BigDecimal(quantity));
				cartList.add(new Cart(productId, productName, price, stocks, image, quantity, total));
			}
			else {
			for (int i = 0; i < cartList.size(); i++) {	
				if(cartList.get(i).getProductId() == Integer.parseInt(req.getParameter("prodId"))) {
					itemExist = true; 
					int quantityTotal = quantity + cartList.get(i).getQuantity(); 
					cartList.get(i).setQuantity(quantityTotal);
					total = price.multiply(new BigDecimal(quantityTotal));
					cartList.get(i).setPrice(total);
				}
			}
				if(itemExist == false){
					total = price.multiply(new BigDecimal(quantity));
					cartList.add(new Cart(productId, productName, price, stocks, image, quantity, total));
				}
			}
			
			for(int i = 0; i < cartList.size(); i++) {
				grandTotal = grandTotal.add(cartList.get(i).getTotal());
			}
			
			session.setAttribute("grandTotal", grandTotal);
			session.setAttribute("sessionList", cartList);
			req.setAttribute("list", session.getAttribute("sessionList"));
		}
		
	}
	
}

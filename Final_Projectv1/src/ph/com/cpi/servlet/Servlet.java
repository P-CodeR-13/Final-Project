package ph.com.cpi.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ph.com.cpi.service.UserService;

public class Servlet extends HttpServlet  {
	
	private static final long serialVersionUID = -3254083445269926470L;
	private String action="",page ="";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action = req.getParameter("action");
		page = "";
		
		if("goToLogin".equals(action)) {
			page = "pages/LoginPage.jsp";
		}
		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 action = req.getParameter("action");
		 page = "";
			
			try{
				ApplicationContext applicationContext = 
						new ClassPathXmlApplicationContext("ph/com/cpi/resource/applicationContext.xml");
				// service for insert, update delete. -- com.cpi.service
				UserService userService = (UserService) applicationContext.getBean("userService");
				// request from EmployeeService
				
				if("insertRecord".equals(action)) {
					userService.insertUser(req);
					page = "pages/LoginPage.jsp";
				}else if("login".equals(action)) {
					if("user".equals(userService.loginUser(req)) ) {
						page = "pages/UserPage.jsp";
					}
					else if("admin".equals(userService.loginUser(req))) {
						page = "pages/AdminPage.jsp";
					}
				} 
			} catch (Exception e){
				System.out.print(e.getMessage());
			} finally {
				RequestDispatcher rd = req.getRequestDispatcher(page);
				rd.forward(req, resp);		
			}//finally

	}//do post method
	
}//class


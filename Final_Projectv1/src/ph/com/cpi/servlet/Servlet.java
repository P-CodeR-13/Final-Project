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
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String post = req.getParameter("action");
		if("insertRecord".equals(post)) {
			String page = "";
			try{
				ApplicationContext applicationContext = 
						new ClassPathXmlApplicationContext("ph/com/cpi/resource/applicationContext.xml");
				// service for insert, update delete. -- com.cpi.service
				UserService userService = 
						(UserService) applicationContext.getBean("userService");
				// request from EmployeeService
				userService.insertUser(req);
				page = "/pages/NewFile.jsp";
			} catch (Exception e){
				System.out.print(e.getMessage());
			} finally {
				RequestDispatcher rd = req.getRequestDispatcher(page);
				rd.forward(req, resp);		
			}
		}
	
	}//do post method
	
}//class


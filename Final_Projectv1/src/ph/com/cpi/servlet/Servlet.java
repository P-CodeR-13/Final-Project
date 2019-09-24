package ph.com.cpi.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ph.com.cpi.service.ProductService;

import ph.com.cpi.service.UserService;

public class Servlet extends HttpServlet  {
	
	private static final long serialVersionUID = -3254083445269926470L;
	private String action="",page ="";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			ApplicationContext applicationContext = 
					new ClassPathXmlApplicationContext("ph/com/cpi/resource/applicationContext.xml");
			UserService userService = (UserService) applicationContext.getBean("userService");
			ProductService productService = (ProductService) applicationContext.getBean("productService");
	
			productService.getProducts(req);
			page = "pages/index.jsp";

		} catch (Exception e){
			System.out.print(e.getMessage());
		} finally {
			RequestDispatcher rd = req.getRequestDispatcher(page);
			rd.forward(req, resp);		
		}//finally
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
				ProductService productService = (ProductService) applicationContext.getBean("productService");
				// request from EmployeeService
				
				if("insertRecord".equals(action)) {
					userService.insertUser(req);
						page = "pages/index.jsp";
				}else if("login".equals(action)) {
					if("user".equals(userService.loginUser(req)) ) {
						productService.getProducts(req);
						page = "pages/home.jsp";
					}
					else if("admin".equals(userService.loginUser(req))) {
						productService.getProducts(req);
						page = "pages/admin.jsp";
					}
				}else if("insertProduct".equals(action)){
					productService.insertProducts(req);
				}
				else if("updateProduct".equals(action)){
					productService.updateProducts(req);
				}
				else if("deleteProduct".equals(action)){
					productService.delProducts(req);
				} else if("updateUser".equals(action)) {
					System.out.println("servlet: "+req.getParameter("username"));
					userService.updateUser(req);
				}
			} catch (Exception e){
				System.out.print(e.getMessage());
			} finally {
				RequestDispatcher rd = req.getRequestDispatcher(page);
				rd.forward(req, resp);		
			}//finally

	}//do post method
	
}//class


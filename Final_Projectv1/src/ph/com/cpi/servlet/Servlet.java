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
		action = req.getParameter("action");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("ph/com/cpi/resource/applicationContext.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		ProductService productService = (ProductService) applicationContext.getBean("productService");
		page="";
		HttpSession session;
		try {
			if("home".equals(action)) {
				productService.getProducts(req);
				page = "pages/home.jsp";
			}
			else if("homeAfterPrint".equals(action)) {
				productService.getProducts(req);
				session = req.getSession();
				session.removeAttribute("sessionList");
				page = "pages/home.jsp";
			}
			else if("profile".equals(action)) {
				page = "pages/profile.jsp";
			}
			else if("shop".equals(action)) {
				productService.getProducts(req);
				page = "pages/shop.jsp";
			}
			else if("cart".equals(action)) {
				page = "pages/cart.jsp";
			}
			else if("logout".equals(action)) {
				session = req.getSession();
				productService.getProducts(req);
				session.invalidate();
				page = "pages/index.jsp";
			}
			else if("signup".equals(action)) {
				page = "pages/signup.jsp";
			}
			else if("initProducts".equals(action)){
				productService.getProducts(req);
				page = "pages/products.jsp";
			}
			else {
				session = req.getSession();
				if(session.getAttribute("id") == null) {
					page = "pages/index.jsp";
				}else {
					productService.getProducts(req);
					page = "pages/home.jsp";
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			RequestDispatcher rd = req.getRequestDispatcher(page);
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 action = req.getParameter("action");
		 page = "";
			
			try{
				ApplicationContext applicationContext = 
						new ClassPathXmlApplicationContext("ph/com/cpi/resource/applicationContext.xml");
				UserService userService = (UserService) applicationContext.getBean("userService");
				ProductService productService = (ProductService) applicationContext.getBean("productService");
				
				if("insertRecord".equals(action)) {
					String str = userService.insertUser(req);
					if("no".equals(str)) {
						page = "pages/index.jsp";
					}
					else {
						page = "pages/signup.jsp";
					}
					
				}
				else if("login".equals(action)) {
					if("user".equals(userService.loginUser(req)) ) {
						productService.getProducts(req);
						page = "pages/home.jsp";
					}
					else if("admin".equals(userService.loginUser(req))) {
						productService.getProductsAdmin(req);
						page = "pages/admin.jsp";
					}
					else if("invalid".equals(userService.loginUser(req))) {
						page = "pages/index.jsp";
					}
				}
				else if("insertProduct".equals(action)){
					productService.insertProducts(req);
					productService.getProductsAdmin(req);
					page ="pages/admin.jsp";
				}
				else if("updateProduct".equals(action)){
					productService.updateProducts(req);
					productService.getProductsAdmin(req);
					page ="pages/admin.jsp";
				}
				else if("deleteProduct".equals(action)){
					productService.delProducts(req);
					productService.getProductsAdmin(req);
					page ="pages/admin.jsp";
				}
				else if("updateUser".equals(action)) {
					userService.updateUser(req);
					page = "pages/profile.jsp";
				}
				else if("addtocart".equals(action)) {
					userService.addToCart(req);
					page ="pages/cart.jsp";
				}
				else if("checkout".equals(action)) {
					productService.checkOut(req);
					page ="pages/receipt.jsp";
				}
			} catch (Exception e){
				System.out.print(e.getMessage());
			} finally {
				RequestDispatcher rd = req.getRequestDispatcher(page);
				rd.forward(req, resp);	
			}//finally

	}//do post method
	
}//class


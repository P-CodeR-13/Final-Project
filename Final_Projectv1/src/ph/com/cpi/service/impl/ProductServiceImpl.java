package ph.com.cpi.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ph.com.cpi.dao.ProductsDAO;
import ph.com.cpi.entities.Products;
import ph.com.cpi.service.ProductService;

public class ProductServiceImpl implements ProductService{
	
	private static final Logger LOGGER = LogManager.getLogger(ProductServiceImpl.class.getName());
	
	private ProductsDAO productDAO;
	
	public ProductsDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductsDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	@Override
	public void getProducts(HttpServletRequest request) throws SQLException {
		request.setAttribute("prodList",productDAO.getProducts());
	}
	@Override
	public void getProductsAdmin(HttpServletRequest request) throws SQLException {
		request.setAttribute("prodListAdmin",productDAO.getProductsAdmin());	
	}
	@Override
	public void insertProducts(HttpServletRequest request) throws SQLException {
		Products prod = setValuesToProd(request);
		this.productDAO.insertProducts(prod);
	}
	@Override
	public void delProducts(HttpServletRequest request) throws SQLException {
		this.productDAO.delProducts(Integer.parseInt(request.getParameter("prodNo")));	
	}
	@Override
	public void updateProducts(HttpServletRequest request) throws SQLException {
		Products prod = updateValuesToProd(request);
		this.productDAO.updateProducts(prod);
	}
	private Products setValuesToProd(HttpServletRequest request) {
		Products prod = new Products();
		prod.setProductName(request.getParameter("productName"));
		prod.setPrice(new BigDecimal(request.getParameter("price")));
		prod.setImage(request.getParameter("image"));
		prod.setStocks(Integer.parseInt(request.getParameter("stocks")));
		return prod;
	}
	private Products updateValuesToProd(HttpServletRequest request) {
		Products prod = new Products();
		prod.setProductId(Integer.parseInt(request.getParameter("productId")));
		prod.setProductName(request.getParameter("productName"));
		prod.setPrice(new BigDecimal(request.getParameter("price")));
		prod.setImage(request.getParameter("image"));
		prod.setStocks(Integer.parseInt(request.getParameter("stocks")));
		return prod;
	}
	@Override
	public void checkOut(HttpServletRequest req) throws SQLException {
		Products prod = updateValuesForCheckOut(req);
		this.productDAO.updateProductsForCart(prod);
	}
	
	private Products updateValuesForCheckOut(HttpServletRequest request) {
		Products prod = new Products();
		prod.setProductId(Integer.parseInt(request.getParameter("productId")));
		prod.setStocks(Integer.parseInt(request.getParameter("quantity")));
		return prod;
	}
}

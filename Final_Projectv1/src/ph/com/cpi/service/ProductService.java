package ph.com.cpi.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ph.com.cpi.entities.Products;

public interface ProductService {
	void getProducts(HttpServletRequest request) throws SQLException;
	void getProductsAdmin(HttpServletRequest request) throws SQLException;
	void insertProducts(HttpServletRequest request) throws SQLException;
	void delProducts(HttpServletRequest request) throws SQLException;
	void updateProducts(HttpServletRequest request) throws SQLException;
	void checkOut(HttpServletRequest req) throws SQLException;
}

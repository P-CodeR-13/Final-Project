package ph.com.cpi.dao;

import java.sql.SQLException;
import java.util.List;
import ph.com.cpi.entities.Products;

public interface ProductsDAO {
	List<Products> getProducts() throws SQLException;
	List<Products> getProductsAdmin() throws SQLException;
	void insertProducts(Products products) throws SQLException;
	void delProducts(Integer prodNo) throws SQLException;
	void updateProducts(Products products) throws SQLException;
	void updateProductsForCart(Products products) throws SQLException;
}

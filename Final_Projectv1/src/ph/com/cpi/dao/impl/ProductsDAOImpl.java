package ph.com.cpi.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ph.com.cpi.dao.ProductsDAO;
import ph.com.cpi.entities.Products;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ProductsDAOImpl implements ProductsDAO{

	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient(){
		return sqlMapClient;
	}
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	@SuppressWarnings("unchecked")
	public List<Products> getProducts() throws SQLException {
		List<Products> listProd = new ArrayList<>();
		try{
			listProd = this.getSqlMapClient().queryForList("getProducts");
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
		return listProd;
	}
	@SuppressWarnings("unchecked")
	public List<Products> getProductsAdmin() throws SQLException {
		List<Products> listProd = new ArrayList<>();
		try{
			listProd = this.getSqlMapClient().queryForList("getProductsAdmin");
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return listProd;
	}

	@Override
	public void insertProducts(Products products) throws SQLException {
		try{
			this.sqlMapClient.startTransaction();
			this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
			this.sqlMapClient.startBatch();
			
			this.getSqlMapClient().insert("insertProducts", products);
			
			this.sqlMapClient.executeBatch();
			this.sqlMapClient.getCurrentConnection().commit();
		
		} catch (SQLException e){
			System.out.println(e.getLocalizedMessage());
			this.sqlMapClient.getCurrentConnection().rollback();
		}finally{
			this.sqlMapClient.endTransaction();
		}	
	}
	@Override
	public void delProducts(Integer prodNo) throws SQLException {
		try {
			this.sqlMapClient.startTransaction();
			this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
			this.sqlMapClient.startBatch();
	
			this.getSqlMapClient().delete("deleteProducts", prodNo);
			
			this.sqlMapClient.executeBatch();
			this.sqlMapClient.getCurrentConnection().commit();
		} catch(SQLException e){
			System.out.println(e.getMessage());
			this.getSqlMapClient().getCurrentConnection().rollback();
		} finally {
			this.sqlMapClient.endTransaction();
		}
		
	}

	@Override
	public void updateProducts(Products products) throws SQLException {
		try{
			this.sqlMapClient.startTransaction();
			this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
			this.sqlMapClient.startBatch();
	
			this.getSqlMapClient().update("updateProducts", products);
			
			this.sqlMapClient.executeBatch();
			this.sqlMapClient.getCurrentConnection().commit();
		} catch(SQLException e){
			System.out.println(e.getMessage());
			this.getSqlMapClient().getCurrentConnection().rollback();
		} finally{
			this.sqlMapClient.endTransaction();
		}
	}

	@Override
	public void updateProductsForCart(Products products) throws SQLException {
		try{
			this.sqlMapClient.startTransaction();
			this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
			this.sqlMapClient.startBatch();
	
			this.getSqlMapClient().update("updateProductsForCart", products);
			
			this.sqlMapClient.executeBatch();
			this.sqlMapClient.getCurrentConnection().commit();
		} catch(SQLException e){
			System.out.println(e.getMessage());
			this.getSqlMapClient().getCurrentConnection().rollback();
		} finally{
			this.sqlMapClient.endTransaction();
		}
		
	}

}

package ph.com.cpi.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ph.com.cpi.dao.UserDAO;
import ph.com.cpi.entities.User;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UserDAOImpl implements UserDAO{

	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient(){
		return sqlMapClient;
	}
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers() throws SQLException {
		List<User> listUsers = new ArrayList<>();
		try{
			listUsers = this.getSqlMapClient().queryForList("getUsers");
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
		return listUsers;
	}

	@Override
	public void insertUser(User user) throws SQLException {
		try{
			this.sqlMapClient.startTransaction();
			this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
			this.sqlMapClient.startBatch();
			
			this.getSqlMapClient().insert("insertUser", user);
			
			this.sqlMapClient.executeBatch();
			this.sqlMapClient.getCurrentConnection().commit();
		
		} catch (SQLException e){
			System.out.println(e.getLocalizedMessage());
			this.sqlMapClient.getCurrentConnection().rollback();
		}finally{
			this.sqlMapClient.endTransaction();	
		}
	}

}

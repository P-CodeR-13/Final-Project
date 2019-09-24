package ph.com.cpi.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	// login
	@Override
	public User loginUser(String username, String password) throws SQLException {
		Map<String, Object> log = new HashMap<String, Object>();
		log.put("username", username);
		log.put("password", password);
		User user = new User();
		try{
			user = (User) this.getSqlMapClient().queryForObject("loginUser", log);
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return user;
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

	@Override
	public void updateUser(User user) throws SQLException {
		try{
			this.sqlMapClient.startTransaction();
			this.sqlMapClient.getCurrentConnection().setAutoCommit(false);
			this.sqlMapClient.startBatch();
			
			System.out.println("dao: "+user.getUsername());
			this.getSqlMapClient().update("updateUser", user);
			
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

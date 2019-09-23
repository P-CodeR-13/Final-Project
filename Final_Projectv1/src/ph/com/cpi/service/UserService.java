package ph.com.cpi.service;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public interface UserService {
	void insertUser(HttpServletRequest request) throws SQLException;
}

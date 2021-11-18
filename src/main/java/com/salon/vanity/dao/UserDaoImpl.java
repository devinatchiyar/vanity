package com.salon.vanity.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.jdbc.core.JdbcTemplate;
import com.salon.vanity.model.Login;
import com.salon.vanity.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
	
  DataSource datasource;
  JdbcTemplate jdbcTemplate;
  
  public int register(User user) {
	PreparedStatement prepareStatement;
	Connection conn = null;
	ResultSet resultset;
	int ans = 0;
	try {
		conn = ConnectionHandler.getConnection();
		if (conn != null) {
			prepareStatement = conn.prepareStatement("select * from members where username=? and password=?");
			prepareStatement.setString(1, (String) user.getUsername() );
			prepareStatement.setString(2, (String) user.getPassword());
			resultset = prepareStatement.executeQuery();
			while (resultset.next())
			{
				ans++;
			}
			if(ans==0) {
			prepareStatement = conn.prepareStatement("insert into members values(?,?,?)");
			prepareStatement.setString(1, (String) user.getUsername() );
			prepareStatement.setString(2, (String) user.getEmail());
			prepareStatement.setString(3, (String) user.getPassword());

			prepareStatement.executeUpdate();
			System.out.println("Record inserted successfully...");
			}
		}
	} catch (SQLException se) {
		se.printStackTrace();
	} finally {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return ans;

}
  
    public int validateUser(Login login) {
    PreparedStatement prepareStatement;
	Connection conn = null;
	ResultSet resultset;
	int ans = 0;
	try {
		conn = ConnectionHandler.getConnection();
		if (conn != null) {
			prepareStatement = conn.prepareStatement("select * from members where username=? and password=?");
			prepareStatement.setString(1, (String) login.getUsername() );
			prepareStatement.setString(2, (String) login.getPassword());
			resultset = prepareStatement.executeQuery();
			while (resultset.next())
			{
				ans++;
			}
			System.out.println("Record found successfully...");
		}
	} catch (SQLException se) {
		se.printStackTrace();
	} finally {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return ans;
    }
    
}


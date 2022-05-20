package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.LoginBean;
import model.User;

public class LoginDao {

	
	public static User checkLogin(LoginBean loginbean) throws ClassNotFoundException {
		
		User user = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_example","root","");
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ? and password = ?");
			preparedStatement.setString(1,loginbean.getUsername());
			preparedStatement.setString(2,loginbean.getPassword());
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(Integer.parseInt(rs.getString("id")));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		return user;
		
	}
}

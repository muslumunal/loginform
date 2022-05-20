package bean;

import java.security.NoSuchAlgorithmException;

import security.Md5Hash;

public class LoginBean {
	private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
    	String hashPassword = null;
		
		try {
			hashPassword = Md5Hash.passwordHash(password);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
        this.password = hashPassword;
    }
}

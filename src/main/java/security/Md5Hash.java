package security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Hash {

	public static String passwordHash(String password) throws NoSuchAlgorithmException
	{

			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte [] digest = md.digest();
			BigInteger no = new BigInteger(1, digest);
			String hashtext = no.toString(16);
	        while (hashtext.length() < 32) {
	            hashtext = "0" + hashtext;
	        }
	        return hashtext;
		
		
		
	}
	
}

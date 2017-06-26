package backend;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configPw {
	String password = "";
	String username = "";
	
	public configPw(){
		Properties prop = new Properties();
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream("./properties.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		username = prop.getProperty("username");
		password = prop.getProperty("pw");
	}
	
	

public String getPw(){
	return password;
}
public String getUsername(){
	return username;
}
}

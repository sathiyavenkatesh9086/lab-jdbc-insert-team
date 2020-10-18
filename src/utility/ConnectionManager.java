package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager{
	
	//created the method to return the connection object
	public static  Connection getConnection() throws IOException, ClassNotFoundException, SQLException{
		Connection connection =null;
		
		Properties properties = null;
		try{
		properties = loadPropertiesFile();
		}catch(Exception e){
			e.printStackTrace();
		}
		//loading the all properties from the file
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		Class.forName(driver);
		
		connection = DriverManager.getConnection(url,username,password);
		return connection;
	}
	
	//created the mo
	public static Properties loadPropertiesFile() throws IOException{
		Properties properties = new Properties();
		InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(input);
		input.close();
		return properties;
		
	}
}
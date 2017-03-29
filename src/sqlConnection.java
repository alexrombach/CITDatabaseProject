import java.sql.Connection;
import java.sql.DriverManager;

public class sqlConnection {
	Connection conn = null;
	public static Connection dbConnector()
	{
		try{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/projecttest?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "integertombob";
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
		
			}catch(Exception e) {System.out.println(e);}
	
	return null;
	}
}

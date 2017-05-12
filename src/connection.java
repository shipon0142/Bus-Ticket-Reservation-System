import java.nio.channels.SelectableChannel;
import java.sql.*;

import org.omg.CORBA.PUBLIC_MEMBER;
public class connection {
	static Connection con=null;

		public static Connection dbConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project_db","password");
			Statement st= con.createStatement();
			return con;
			
		} catch (Exception e) {
			e.printStackTrace();
			return con;
		}
		}
	
	

}

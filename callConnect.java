package basic4;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class callConnect {

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver loaded");
		String s="jdbc:mysql://localhost:3306/mydb";
		FileReader f=new FileReader("password//db.properties");
		Properties pr=new Properties();
		try {
			pr.load(f);
		} catch (IOException e) {
				e.printStackTrace();
		}
		Connection con=DriverManager.getConnection(s,pr);
		System.out.println("Connection established");
		PreparedStatement st=con.prepareCall("{call.mydb.insert(?)}");
		st.setInt(1, 777);
		st.execute();
		System.out.println("done");
	}

}

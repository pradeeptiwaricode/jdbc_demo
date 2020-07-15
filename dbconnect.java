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

public class dbconnect {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
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
		PreparedStatement st=con.prepareStatement("insert into student values(?)");
		st.setInt(1,9898);
		st.execute();
		st.setInt(1, 6900);
		int c=st.executeUpdate();
		System.out.println("number of row affected"+c);
		
	}

}

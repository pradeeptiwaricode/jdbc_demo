package basic4;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class db {

	public static void main(String[] args) throws IOException  {
		
		
		try {
			Driver	d = new Driver();
			System.out.println("Driver loaded succesfully");
			DriverManager.registerDriver(d);
			//System.out.println("reigtrator");
			
			
			
			
			
		
//	String url = "jdbc:mysql://localhost:3306/mydb";
//		String username = "root";
//		String password = "tiger";
			FileReader fr=new FileReader("password\\db.properties");
			Properties pr=new Properties();
        	pr.load(fr);
			Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3306",pr);
			
	//	Connection con = DriverManager.getConnection(url, pr);
			
			
			
			
			
		
		System.out.println("Connection established");
	           Statement s=con.createStatement();
	           System.out.println("statement excuted");
	          int a=s.executeUpdate("insert into mydb.student values(11)");
	          System.out.println("row accefted"+a);
	          System.out.println("exeuted");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

}

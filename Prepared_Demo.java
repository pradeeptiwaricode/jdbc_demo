	package basic4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Prepared_Demo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		
			System.out.println("Loarded successfully");
			String url="jdbc:mysql://localhost:3306/mydb";
			
			FileReader fr=new FileReader("password\\db.properties");
			Properties p=new Properties();
			p.load(fr);
			Connection con=DriverManager.getConnection(url,p);
			System.out.println("CONNECTion created");
//			PreparedStatement ps=con.prepareCall("insert into emp values(?,?,?)");
//		    ps.setInt(1, 1245);
//		
//		       ps.setString(2,"rama");
//			
//		       ps.setDouble(3, 123000);
//			ps.execute();
//			System.out.println("inserted the value");
		     PreparedStatement pi=con.prepareStatement(" select * from emp where NAME =?");
		    pi.setString(1, "rama");
		
			  ResultSet r=pi.executeQuery();
			 while(r.next())
			
				System.out.println(r.getInt(1)+"\n"+r.getString(2)+"\n"+r.getDouble(3));
			
			
			
			System.out.println("done");
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("very Good");
		}
	}

}

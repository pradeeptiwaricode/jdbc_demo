package basic4;

import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

public class Conregistry {

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
           CallableStatement cs=con.prepareCall("{call mydb.show(?,?,?)}");
           cs.registerOutParameter(1, Types.INTEGER);
           cs.registerOutParameter(2, Types.VARCHAR);
           cs.registerOutParameter(3, Types.DOUBLE);
           cs.execute();
           ResultSet rs=cs.getResultSet();
           while(rs.next())
           {
        	  System.out.println(rs.getString(2)); 
           }
		
			
			
			
			System.out.println("done");
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("very Good");
		}

	}

}

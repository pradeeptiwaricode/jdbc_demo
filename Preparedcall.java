package basic4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Preparedcall {

	public static void main(String[] args) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loarded succesfully");
			String url="jdbc:mysql://localhost:3306/mydb";
			String name="root";
			String pass="tiger";
			Connection con=DriverManager.getConnection(url,name,pass);
			System.out.println("Connected to db");
//		CallableStatement s=con.prepareCall("{call insertnew(?,?,?)}");
//		s.setInt(1, 123);
//			s.setString(2, "pradeep");
//			s.setDouble(3, 19000.00);
//			s.execute();
		System.out.println("insert done");
			CallableStatement cs=con.prepareCall("{call mydb.update(?,?)}");
			cs.setDouble(1,3000.00);
			cs.setInt(2,123);
		int afftected=	cs.executeUpdate();
		System.out.println("number of row affted"+afftected);	
		CallableStatement ss=con.prepareCall("{call mydb.show(?,?,?)}");
		ResultSet r=ss.executeQuery();
		while(r.next())
		{
			System.out.println(r.getInt("id")+" "+r.getString("name")+" "+r.getDouble("sal"));
		}
		
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}

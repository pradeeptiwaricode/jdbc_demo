package basic4;
import java.util.*;
import java.io.*;
import java.sql.*;
//jdbc:mysql://localhost:3306/mydb

public class Assingment {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class load ho gyi");
			String path="jdbc:mysql://localhost:3306/mydb";
			String user="root";
			String password="tiger";
			Connection con=DriverManager.getConnection(path,user,password);
			System.out.println("Server se connect ho gaya");
			//inserting the values
//			PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?)");
//			ps.setInt(1, 1);
//			ps.setString(2, "salman");
//			ps.setInt(3,1200);
//			ps.execute();
//			System.out.println("Data insert ho gaya");
	       //updating Values
//			PreparedStatement ps1=con.prepareStatement(" update emp set name=? where name=?");
//		   
//			ps1.setString(1,"Ranbir");
//			 ps1.setString(2, "salman");
//			
			//ps1.executeUpdate();
			System.out.println("update ho gaya ");
			
			PreparedStatement ps3=con.prepareStatement("select *from emp");
			ResultSet rs =ps3.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getInt("id")+"\n"+rs.getString("name"));
				
			}
			else
			{
				System.out.println("no record found");
			}
			
			

			
			
		} catch (ClassNotFoundException |SQLException e) {
			
			e.printStackTrace();
		}

	}

}

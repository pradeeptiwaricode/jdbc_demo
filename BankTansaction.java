package basic4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class BankTansaction {

	public static void main(String[] args) {
		Connection con=null;
		Savepoint sp=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loarded");
			 con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=tiger");
			Statement s=con.createStatement();
			System.out.println("Connection established");
			
			con.setAutoCommit(false);
			
			System.out.println("auto commit is false");
			System.out.println("Start excuting Query");
			s.execute("insert into bank values('hitesh',3000)");
			sp=con.setSavepoint();
			s.execute("update Bank set amount=amount-1000 where name='Rahul'" );
			System.out.println("debited From Rahul");
			s.execute("update Bank set amount=amount+1000 where name=1234");
			con.commit();
			System.out.println("transaction succesfull");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			try {
				con.rollback(sp);
				System.out.println("data roll back till save point ");
				con.commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

}

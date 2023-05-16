package EmployeeDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployeeTable {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root", "root");
		System.out.println("Establish Connecction with database");
		
		Statement st =con.createStatement();
		System.out.println("Statement created");
		
		st.execute("create table emp(id int, name varchar(20), surname varchar(20),job varchar(20),sal int, dept int)");
		System.out.println("Emp Table created Successfully...");

	}

}

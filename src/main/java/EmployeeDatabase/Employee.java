package EmployeeDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
		Scanner sc = new Scanner(System.in);
		for(;;) {
			System.out.println("1.Add Emp       2.Remove Emp       3.Search       4.All Emp       5.Update Emp");
			switch (sc.nextInt()) {
			case 1:{
				//Adding Employee.
				PreparedStatement ps= con.prepareStatement("insert into emp (id,name,surname,job,sal,dept) values (?,?,?,?,?,?)");
				System.out.println("Enter the ID of the employee");
				int id =sc.nextInt();
				System.out.println("Enter the NAME of the employee");
				String name = sc.next();
				System.out.println("Enter the SURNAME of the employee");
				String surname = sc.next();
				System.out.println("Enter the JOB of the employee");
				String job = sc.next();
				System.out.println("Enter the SALARY of the employee");
				int sal = sc.nextInt();
				System.out.println("Enter the DEPARTMENT NO. of the employee");
				int dept = sc.nextInt();
				ps.setInt(1,id);
				ps.setString(2, name);
				ps.setString(3, surname);
				ps.setString(4, job);
				ps.setInt(5, sal);
				ps.setInt(6, dept);
				ps.execute();
				System.out.println("Employee Added To the Database Successfully...");
				System.out.println("-----------------------------------------------------------------");
				System.out.println();
				break;
				
			}//------End of Case 1.
			
			
			case 2:{
				// Removing Employeee.
				PreparedStatement ps = con.prepareStatement("delete from emp where id=?");
				System.out.println("Enter the ID of Employee");
				int id = sc.nextInt();
				ps.setInt(1, id);
				ps.execute();
				System.out.println("Employee Terminated Successfully...");
				System.out.println("-----------------------------------------------------------------");
				System.out.println();
				break;
				
			}//------End of Case 2.
			
			case 3:{
				// Searching Employee.
				PreparedStatement ps =con.prepareStatement("select * from emp where id=?");
				System.out.println("Enter the ID of Employee");
				int id =sc.nextInt();
				ps.setInt(1, id);
				System.out.println("Searched Results :- ");
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println("Employee ID Is      :- "+rs.getInt(1));
					System.out.println("Employee Name Is    :- "+rs.getString(2));
					System.out.println("Employee SurName Is :- "+rs.getString(3));
					System.out.println("Employee Job Is     :- "+rs.getString(4));
					System.out.println("Employee Salary Is  :- "+rs.getInt(5));
					System.out.println("Employee Dept Is    :- "+rs.getInt(6));
					System.out.println();
					
				}else {
					System.err.println("Id is Not present into database");
					
				}
				break;
				
				
			}//-------End of Case 3.
			
			case 4:{
				// All Employee.
				
				
				
				
			}//-------End of Case 4.
			
			
			
			}
			
			
			
		}//-----------End of Infinite For Loop.

	}

}

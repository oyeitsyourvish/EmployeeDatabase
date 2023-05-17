package EmployeeDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
				//3.View All Book 
				Statement st =  con.createStatement();
				ResultSet rs = st.executeQuery("select * from emp");
				
				while(rs.next()) {
					System.out.println("Employee ID Is      :- "+rs.getInt(1));
					System.out.println("Employee Name Is    :- "+rs.getString(2));
					System.out.println("Employee SurName Is :- "+rs.getString(3));
					System.out.println("Employee Job Is     :- "+rs.getString(4));
					System.out.println("Employee Salary Is  :- "+rs.getInt(5));
					System.out.println("Employee Dept Is    :- "+rs.getInt(6));
					System.out.println("-----------------------------------------------");
					System.out.println();
				   
				}
				break;
				
				
				
			}//-------End of Case 4.
			
			
			// CASE 5 START FROM HERE -----------------------------------------------------------------------------------------------------------------
			case 5:{
				// Update Employee
				System.out.println("1.Emp Name     2.Emp SurName     3.Emp Job     4.Emp Salary     5.Emp Department");
				
				// SUB SWITCH OF CASE 5
				switch(sc.nextInt()) {
				case 1 :{
					// Update Employee Name.
					PreparedStatement ps =con.prepareStatement("update emp set name=? where id =?");
					
					System.out.println("Enter the New Name");
					String name =sc.next();
					
					System.out.println("Enter the id to update");
					int id = sc.nextInt();
					
					ps.setString(1,name);
					ps.setInt(2, id);
					
					ps.execute();
					System.out.println("Employee Name Updated Successfully....");
					System.out.println();
					break;
				}
				// End of subswitch case 1 of case 5.
				
				case 2:{
					// Update Employee Surname.
					PreparedStatement ps =con.prepareStatement("update emp set surname=? where id =?");
					
					System.out.println("Enter the New SurName");
					String surname =sc.next();
					
					System.out.println("Enter the id to update");
					int id = sc.nextInt();
					
					ps.setString(1,surname);
					ps.setInt(2, id);
					
					ps.execute();
					System.out.println("Employee SurName Updated Successfully....");
					System.out.println();
					break;
				}
				// End of subswitch case 2 of case 5.
				
				case 3:{
					// Update Employee Job.
					PreparedStatement ps =con.prepareStatement("update emp set job=? where id =?");
					
					System.out.println("Enter the New Job title");
					String job =sc.next();
					
					System.out.println("Enter the id to update");
					int id = sc.nextInt();
					
					ps.setString(1,job);
					ps.setInt(2, id);
					
					ps.execute();
					System.out.println("Employee Job Title Updated Successfully....");
					System.out.println();
					break;
				}
				// End of subswitch case 3 of case 5.
				
				case 4:{
					// Update Employee Job.
					PreparedStatement ps =con.prepareStatement("update emp set sal=? where id =?");
					
					System.out.println("Enter the New Salary of the Employee");
					int sal =sc.nextInt();
					
					System.out.println("Enter the id to update");
					int id = sc.nextInt();
					
					ps.setInt(1,sal);
					ps.setInt(2, id);
					
					ps.execute();
					System.out.println("Employee Salary  Updated Successfully....");
					System.out.println();
					break;
				}
				// End of subswitch case 4 of case 5.
				
				case 5:{
					// Update Employee Job.
					PreparedStatement ps =con.prepareStatement("update emp set dept=? where id =?");
					
					System.out.println("Enter the New Department Number of the Employee");
					int dept =sc.nextInt();
					
					System.out.println("Enter the id to update");
					int id = sc.nextInt();
					
					ps.setInt(1,dept);
					ps.setInt(2, id);
					
					ps.execute();
					System.out.println("Employee Department  Updated Successfully....");
					System.out.println();
					break;
				}
				// End of subswitch case 4 of case 5.
				
				
				
				}
				// END OF SUB SWITCH CASE 5
				
				
				
				
				
				
			}//------End of Case 5.
			// CASE 5 END HERE -----------------------------------------------------------------------------------------------------------------
			
			
			
			}
			
			
			
		}//-----------End of Infinite For Loop.

	}

}

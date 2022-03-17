package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.models.EmployeeModel;

public class LoginDAO {
	
	String query = "select * from paarthbirla_111915081_details where employee_id=? and password=?";
	String getDetailsString = "select d.employee_id, d.first_name, d.last_name, d.contact, j.salary, j.job_role, j.yearly_bonus from paarthbirla_111915081_details d join paarthbirla_111915081_salary j on d.employee_id = j.employee_id where d.employee_id = ?";
	String getNameString = "select d.first_name, d.last_name from paarthbirla_111915081_details d where d.employee_id = ? and d.password = ?";
	String insertDetails = "insert into paarthbirla_111915081_details values (?,?,?,?,?,?)";
	String insertSalary = "insert into paarthbirla_111915081_salary values (?,?,?,?)";
	
	public String checkCredential(int empid, String password)
	{
		String name;
		try 
		{
			Connection connection = DatabaseConnection.getDBConnection();
			System.out.println("Connected");
			
			PreparedStatement statement = connection.prepareStatement(getNameString);
			statement.setInt(1, empid);
			statement.setString(2, password);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next())
			{
				name = resultSet.getString("first_name") + " " + resultSet.getString("last_name");
				return name;
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<EmployeeModel> getDetails(int empid) 
	{
		List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
		
		try {
			Connection connection = DatabaseConnection.getDBConnection();
			
			PreparedStatement statement = connection.prepareStatement(getDetailsString);
			statement.setInt(1, empid);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Integer emp_id = resultSet.getInt("employee_id");
				String fname = resultSet.getString("first_name");
				String lname = resultSet.getString("last_name");
				String job = resultSet.getString("job_role");
				Float salary = resultSet.getFloat("salary");
				Float year_bonus = resultSet.getFloat("yearly_bonus");
				Integer contact = resultSet.getInt("contact");
				employees.add(new EmployeeModel(emp_id, fname, lname, job, salary, year_bonus, contact));
			}
			return (ArrayList<EmployeeModel>) employees;
		} catch (Exception e) {
		}
		return null;
	}
	
	public boolean insertEmployeeDetails(int empid, String fname, String lname, String dob, int contact, String job, float salary, float yearbonus, String password)
	{
		try 
		{
			Connection connection = DatabaseConnection.getDBConnection();
			System.out.println("Connected");
			
			PreparedStatement statement1 = connection.prepareStatement(insertDetails);
			statement1.setInt(1, empid);
			statement1.setString(2, fname);
			statement1.setString(3, lname);
			statement1.setString(4, dob);
			statement1.setInt(5, contact);
			statement1.setString(6, password);
			
			PreparedStatement statement2 = connection.prepareStatement(insertSalary);
			statement2.setString(1, job);
			statement2.setFloat(2, salary);
			statement2.setFloat(3, yearbonus);
			statement2.setInt(4, empid);
			
			statement1.execute();
			statement2.execute();
			
			return true;
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
}

package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.util.CloseStreams;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

	@Override
	public boolean insert(Employee e) {
		PreparedStatement stmt = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO projectfun.employee (first_name, last_name, username, password) " +
					"VALUES (?, ?, ?, ?, ?);";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getFirstName());
			stmt.setString(2, e.getLastName());
			stmt.setString(3, e.getUsername());
			stmt.setString(4, e.getPassword());
			
			if(!stmt.execute()) {
				return false;
			}
		} catch(SQLException ex) {
			logger.warn("Unable to retrieve all users", ex);
			return false;
		} finally {
			CloseStreams.close(stmt);
		}
		
		return true;
	}

	@Override
	public boolean update(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM projectfun.employee;";
			
			// This Statement object is a wrapper around our SQL string
			// And is obtained through our connection to the database
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			// ResultSets start 1 position behind the starting point
			// So, in order to access the first value, we invoke next to start
			// This is a small difference, the only thing is that it simplifies
			// our syntax. Since we can use a while loop instead of a do-while loop
			while(rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String username = rs.getString("username");
				String password = rs.getString("password");
				LocalDateTime hireDate = rs.getTimestamp("hire_date").toLocalDateTime();
				
				Employee e = new Employee(id, first_name, last_name, username, password, hireDate);
				list.add(e);
			}
			
			rs.close();
		} catch(SQLException e) {
			logger.warn("Unable to retrieve all users", e);
		}
		
		return list;
	}
}

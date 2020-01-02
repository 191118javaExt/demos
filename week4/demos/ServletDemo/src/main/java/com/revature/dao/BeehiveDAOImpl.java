package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Beehive;
import com.revature.util.ConnectionUtil;

public class BeehiveDAOImpl implements BeehiveDAO {
	
	private static String filename = "connection.properties";

	@Override
	public List<Beehive> getBeehives() {
		List<Beehive> cl = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			// using a Statement - beware SQL injection
			String sql = "SELECT * FROM demo.BEEHIVE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// move through ResultSet
			while (rs.next()) {
				int id = rs.getInt("BEEHIVE_ID");
				String name = rs.getString("BEEHIVE_NAME");
				double weight = rs.getDouble("WEIGHT");
				cl.add(new Beehive(id, name, weight));
			}
			con.close(); //not strictly necessary, because try with resources
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cl;
	}

	@Override
	public Beehive getBeehiveById(int id) {
		Beehive c = null;
		PreparedStatement pstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			
			//use a prepared statement
			String sql = "SELECT * FROM demo.BEEHIVE WHERE BEEHIVE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			//do something with result 
			if (rs.next()) {
				String name = rs.getString("BEEHIVE_NAME");
				double weight = rs.getDouble("WEIGHT");
				c = new Beehive(id, name, weight);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	
}

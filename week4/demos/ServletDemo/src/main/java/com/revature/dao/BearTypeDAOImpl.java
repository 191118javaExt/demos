package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BearType;
import com.revature.util.ConnectionUtil;

public class BearTypeDAOImpl implements BearTypeDAO {

	private static String filename = "connection.properties";

	@Override
	public List<BearType> getBearTypes() {
		List<BearType> btl = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			// use a Statement - remember the danger of SQL injection
			String sql = "SELECT * FROM demo.BEAR_TYPE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("BEAR_TYPE_ID");
				String name = rs.getString("BEAR_TYPE_NAME");
				String sp = rs.getString("SURVIVAL");
				BearType newBT = new BearType(id, name, sp);
				btl.add(newBT);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return btl;
	}

	@Override
	public BearType getBearTypeById(int id) {
		PreparedStatement pstmt = null;
		BearType bt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM demo.BEAR_TYPE WHERE BEAR_TYPE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("BEAR_TYPE_NAME");
				String sp = rs.getString("SURVIVAL");
				bt = new BearType(id, name, sp);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bt;
	}

}

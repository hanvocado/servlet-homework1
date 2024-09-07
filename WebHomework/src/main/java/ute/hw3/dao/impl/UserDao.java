package ute.hw3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ute.hw3.configs.DbConnect;
import ute.hw3.dao.IUserDao;
import ute.hw3.models.User;

public class UserDao extends DbConnect implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<User> findAll() {
		String query = "SELECT * from users";
		List<User> users = new ArrayList<>();

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("email"), rs.getString("fullname"),
						rs.getString("password")));
			}

			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByEmail(String email) {
		String query = "SELECT * FROM users WHERE email=?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("email"), rs.getString("fullname"),
						rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(User user) {
		String query = "INSERT INTO users(email, fullname, password) VALUES (?, ?, ?)";

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

	}

}

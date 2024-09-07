package ute.hw3.dao;

import java.util.List;

import ute.hw3.models.User;

public interface IUserDao {

	List<User> findAll();

	User findByEmail(String email);

	void insert(User user);

}

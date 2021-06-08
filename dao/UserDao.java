package dao;

import java.sql.SQLException;
import java.util.Map;

import entities.User;

public class UserDao extends BasicDao {

	public UserDao(String dbAddress) throws SQLException  {
		super(dbAddress);
	}

	public User login(String username, String password) {
		User ris = null;

		Map<String, String> queryResult = findOne(
				"SELECT * FROM users WHERE username = ? AND password = ?;", 
				username,
				password
		);
		if (queryResult != null) {
			ris = new User();
			ris.fromMap(queryResult);
		}

		return ris;
	}
}

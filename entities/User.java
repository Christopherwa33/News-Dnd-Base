package entities;

import java.util.HashMap;
import java.util.Map;

import utils.IMappable;

public class User implements IMappable {
	private int id;
	private String username;
	private String password;
	private String role;

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.role = "User";
	}

	public User(int id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public Map<String, String> toMap() {
		Map<String, String> ris = new HashMap<>();

		ris.put("id", id + "");
		ris.put("username", username);
		ris.put("password", password);
		ris.put("role", role);

		return ris;
	}

	@Override
	public void fromMap(Map<String, String> map) {
		id = Integer.parseInt(map.get("id"));
		username = map.get("username");
		password = map.get("username");
		role = map.get("role");
	}

}

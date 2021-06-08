package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import entities.Commento;
import entities.Inventory;

public class commentoDao extends BasicDao {

	public commentoDao(String dbAddress) throws SQLException {
		super(dbAddress);
		// TODO Auto-generated constructor stub
	}


	


	public List<Commento> commentoOfNews(int newsId) {
		return findAll("SELECT * FROM commento where newsid = ?;", newsId)
				.stream()
				.map((m) -> {
					Commento i = new Commento();
					i.fromMap(m);
					return i;
				}).collect(Collectors.toList());
	}
}

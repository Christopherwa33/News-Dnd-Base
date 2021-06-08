package dao;
import java.util.Map;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.Commento;
import entities.News;
import entities.PG;
import entities.Stats;

public class NewsDao extends BasicDao {

	public NewsDao(String dbAddress) throws SQLException {
		super(dbAddress);
	}
	
//	public Stats statsOfPg(int pgId) {
//		Stats ris = null;
//		Map<String, String> queryResult = findOne("SELECT * FROM characters_stats WHERE id = ?", pgId);
//		
//		if (queryResult != null) {
//			ris = new Stats();
//			ris.fromMap(queryResult);
//		}
//		
//		return ris;
//	}

	public List<News> newsOfUser(int userId) {
		List<Map<String, String>> queryResult = findAll("SELECT * FROM news WHERE userid = ?;", userId);
		List<News> res = new ArrayList<>();
		
		// A non interessano le stat o l'inventario dei PG
		// se vengono restituiti come lista
		for (Map<String, String> map: queryResult) {
			// Metodo helper che crea il PG con le stats
			res.add(newsFromMap(map));
		}
		
		return res;
//		return findAll("SELECT * FROM characters WHERE userid = ?;", userId)
//				.stream()
//				.map((m) -> pgFromMap(m))
//				.collect(Collectors.toList());
	}
	
	private News newsFromMap(Map<String, String> map) {
	// TODO Auto-generated method stub
		News news = new News();
		news.fromMap(map);
		news.setCommento(commnetoOfNews(news.getId()));
		return news;
//	return null;
}

	private Commento commnetoOfNews(int id) {
	
		return null;
	}

	public News newsByIdOfUser(int newsId, int userId) {
		Map<String, String> queryResult = findOne("SELECT * FROM news WHERE id = ? AND userid = ?;", newsId, userId);
		News ris = null;
		
		if (queryResult != null) {
			ris = newsFromMap(queryResult);
		}
		
		return ris;
	}
	
//	private PG pgFromMap(Map<String,String> map) {
//		PG pg = new PG();
//		pg.fromMap(map);
//		pg.setStats(statsOfPg(pg.getId()));
//		return pg;
//	}
	
	public void createNews(int userId, News news) {
		int newsId = createAndGetId(
				"INSERT INTO news(titolo, news, datapubblicazione, autore, userid) VALUES(?,?,?,?,?);", 
				news.getTitolo(), 
				news.getNews(), 
				news.getDatapubblicazione(), 
				
				
				userId
		);}
//		Commento commento = commento.getCommento();
		
//		executeUpdate(
//				"INSERT INTO characters_stats VALUES(?, ?, ?, ?, ?);", 
//				pgId, 
//				commento.getStrength(), 
//				commento.getConstitution(), 
//				commento.getCurrentHealth(), 
//				commento.getMaxHealth()
//		);
//	}

	private int createAndGetId(String string, String titolo, String news, int datapubblicazione, int userId) {
	// TODO Auto-generated method stub
	return 0;
}

	public void deleteCharacter(int id) {
		executeUpdate("DELETE from news_stats WHERE id = ?;", id);
		executeUpdate("DELETE from news WHERE id = ?;", id);
	}

	public void updateName(int id, String newName) {
		executeUpdate("UPDATE news set name = ? WHERE id = ?;", newName, id);
	}



}

package entities;

import java.util.HashMap;
import java.util.Map;

import utils.IMappable;

public class News implements IMappable {

	private int id;
	private String titolo;
	private String news;
	private int datapubblicazione;
	private String autore;
	private  Commento commento;

	public News() {
		super();
	}

	public News(Map<String, String> map) {
		fromMap(map);
	}

	public News(String titolo, String news, int datapubblicazione,String autore ) {
		super();
		this.titolo = titolo;
		this.news = news;
		this.datapubblicazione = datapubblicazione;
	}

	public News(int id, String titolo, String news,int datapubblicazione,String autore , Commento commento ) {
		super();
		this.id = id;
		this.titolo = titolo ;
		this.news = news;
		this.datapubblicazione = datapubblicazione;
		this.autore = autore;
		this.commento = commento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getNews() {
		return news;
	}

	public void setRace(String race) {
		this.news = news;
	}

	public int getDatapubblicazione() {
		return datapubblicazione;
	}

	public void setdatapubblicazione(int datapubblicazione) {
		this.datapubblicazione = datapubblicazione;
	}

	public Commento getCommento() {
		return commento;
	}

	public void setCommento(Commento commento) {
		this.commento = commento;
	}

	@Override
	public String toString() {
		return "id: " + id + ", titolo: " + titolo + ", news: " + news + ", datapubblicazione : " + datapubblicazione + ", Commento " + commento;
	}
	
//	public void randomizeStats() {
//		commento = new Commento (randomStat(), randomStat(), randomStat());
//	}
	
//	private int randomStat() {
//		return randomStat(MIN_STAT, MAX_STAT);
//	}
//	
//	private int randomStat(int min, int max) {
//		return (int) (Math.random() * (max - min)) + min;
//	}

	@Override
	public Map<String, String> toMap() {
		Map<String, String> ris = new HashMap<>();

		ris.put("id", id + "");
		ris.put("titolo", titolo);
		ris.put("news", news);
		ris.put("datapubblicazione", datapubblicazione);
		ris.put("autore", autore);

		return ris;
	}

	@Override
	public void fromMap(Map<String, String> map) {
		id = Integer.parseInt(map.get("id"));
		titolo = map.get("titolo");
		news = map.get("news");
		datapubblicazione = Integer.parseInt(map.get("datapubblicazione");
		autore = map.get("autore"));
		
	}

}

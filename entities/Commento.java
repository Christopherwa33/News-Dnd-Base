package entities;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;

import utils.IMappable;
import dao.*
;public class Commento implements IMappable {
	private int id;
	private int commento;
	private int userid;
	private int newsid;
	

	public Commento() {
		super();
	}

//	public Commento(int strength, int constitution, int maxHealth) {
//		super();
//		this.strength = strength;
//		this.constitution = constitution;
//		this.currentHealth = maxHealth;
//		this.maxHealth = maxHealth;
//	}




	@Override
	public String toString() {
		return "id: " + id +    "commento:"+ commento +  " userid " + userid + "newsid: "
				+ newsid  ;
	}

	public Commento(int id, int commento, int userid, int newsid) {
	super();
	this.id = id;
	this.commento = commento;
	this.userid = userid;
	this.newsid = newsid;
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getNewsid() {
		return newsid;
	}

	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public void setCommento(int commento) {
		this.commento = commento;
	}

	@Override
	public Map<String, String> toMap() {
		Map<String, String> ris = new HashMap<>();

		ris.put("id", id + "");
		ris.put("commento", commento + "");
		ris.put("userid", userid + "");
		ris.put("newsid", newsid + "");
	
		return ris;
	}

	@Override
	public void fromMap(Map<String, String> map) {
		id = Integer.parseInt(map.get("id"));
		commento = Integer.parseInt(map.get("commento"));
		userid = Integer.parseInt(map.get("useridn"));
		newsid = Integer.parseInt(map.get("newsid"));

	}

	public Commento getCommento() {
		// TODO Auto-generated method stub
		return null;
	}

}

package entities;

import java.util.Map;

import utils.IMappable;

public class Inventory implements IMappable {
	private int id;
	private String name;
	private int heal;
	private int quantity;

	public Inventory() {
		super();
	}

	public Inventory(int id, String name, int heal, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.heal = heal;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeal() {
		return heal;
	}

	public void setHeal(int heal) {
		this.heal = heal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "id: " + id + ", name: " + name + ", heal: " + heal + ", quantity: " + quantity;
	}

	@Override
	public Map<String, String> toMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fromMap(Map<String, String> map) {
		id = Integer.parseInt(map.get("id"));
		name = map.get("name");
		heal = Integer.parseInt(map.get("heal"));
		quantity = Integer.parseInt(map.get("quantity"));
	}

}

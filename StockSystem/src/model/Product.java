package model;

public class Product {
	private int id;
	private String name;
	private String amount;
	
	public Product() {
		// do nothingh
	}

	public Product(String name, String amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public Product(int id, String name, String amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
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
	
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
}

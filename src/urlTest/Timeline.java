package urlTest;

import java.util.List;

public class Timeline {
	private String timestamp;
	private double revenue;
	private int transaction_id;
	private String store_name;
	private List<Product> products;
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public double getRevenue() {
		return revenue;
	}
	
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	
	public int getTransaction_id() {
		return transaction_id;
	}
	
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	
	public String getStore_name() {
		return store_name;
	}
	
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}

package app.model;

public class CoffeeProduct {

	private String name;

	private int productId;

	private int qty;

	public CoffeeProduct(String name, int productId) {
		this.setName(name);
		this.setProductId(productId);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
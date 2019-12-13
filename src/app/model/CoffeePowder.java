package app.model;

public class CoffeePowder extends CoffeeProduct {

	private double weight;

	public CoffeePowder(String name, int productId, double weight) {
		super(name, productId);
		this.setWeight(weight);
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
package app.model;

public class CoffeeCandy extends CoffeeProduct {
	
	private int noOfCandy;

	private int caloriesPerCandy;

	public CoffeeCandy(String name, int productId, int noOfCandy, int caloriesPerCandy) {
		super(name, productId);
		this.setNoOfCandy(noOfCandy);
		this.setCaloriesPerCandy(caloriesPerCandy);
	}

	public int getNoOfCandy() {
		return this.noOfCandy;
	}

	public void setNoOfCandy(int noOfCandy) {
		this.noOfCandy = noOfCandy;
	}

	public int getCaloriesPerCandy() {
		return this.caloriesPerCandy;
	}

	public void setCaloriesPerCandy(int caloriesPerCandy) {
		this.caloriesPerCandy = caloriesPerCandy;
	}

}
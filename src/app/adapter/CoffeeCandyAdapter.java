package app.adapter;

import app.model.CoffeeCandy;
import app.singleton.ScannerSingleton;

/**
 * CoffeeCandyAdapter
 */
public class CoffeeCandyAdapter extends CoffeeCandy implements ICoffeeProduct {

	public CoffeeCandyAdapter() {
		// super
		super("", 0, 0, 0);
		// prompt
		System.out.println("Enter product Id, name, number of candy and calories per candy: ");
		// get product id
		String[] args = ScannerSingleton.getInstance().nextLine().split("\\s*,\\s*");
		// properties init
		this.setName(args[1]);
		this.setProductId(Integer.parseInt(args[0]));
		this.setNoOfCandy(Integer.parseInt(args[2]));
		this.setCaloriesPerCandy(Integer.parseInt(args[3]));
	}

	@Override
	public String getInfo() {
		return String.format(
			"%-4d\t%-12s\t%-8d\t%d candy per package ( %d calories each)",
			this.getProductId(),
			this.getName(),
			this.getQty(),
			this.getNoOfCandy(),
			this.getCaloriesPerCandy()
		);
	}

	@Override
	public String getDetailInfo() {
		return 
			"ID: " + this.getProductId() + "\r\n" +
			"Name: " + this.getName() + "\r\n" +
			"Quantity: " + this.getQty() + "\r\n" +
			"Number of candies per package: " + this.getNoOfCandy() + "\r\n" +
			"Calories per candy: " + this.getCaloriesPerCandy();
	}
	
}
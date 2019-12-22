package app.adapter;

import app.model.CoffeePowder;
import app.singleton.ScannerSingleton;

/**
 * CoffeeProwderAdapter
 */
public class CoffeePowderAdapter extends CoffeePowder implements ICoffeeProduct {

	public CoffeePowderAdapter() {
		// super
		super("", 0, 0);
		// prompt 
		System.out.println("Enter product Id , name and weight(g): ");
		// get product id
		String[] args = ScannerSingleton.getInstance().nextLine().split("\\s*,\\s*");
		// properties init
		this.setName(args[1]);
		this.setProductId(Integer.parseInt(args[0]));
		this.setWeight(Double.parseDouble(args[2]));
	}

	@Override
	public String getInfo() {
		return String.format(
			"%-4d\t%-12s\t%-8d\t%f g",
			this.getProductId(),
			this.getName(),
			this.getQty(),
			this.getWeight()
		);
	}

	@Override
	public String getDetailInfo() {
		return 
			"ID: " + this.getProductId() + "\r\n" +
			"Name: " + this.getName() + "\r\n" +
			"Quantity: " + this.getQty() + "\r\n" +
			"Weight: " + this.getWeight();
	}
}
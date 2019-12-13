package app.command;

import java.util.Collection;

import app.adapter.ICoffeeProduct;
import app.singleton.ProductListSingleton;
import app.singleton.ScannerSingleton;

/**
 * ShowProductCommand
 */
public class ShowProductCommand implements ICommand {

	@Override
	public ICommand execute() {
		// get the list of products
		Collection<ICoffeeProduct> arr = ProductListSingleton.getInstance().values();
		// prompt
		System.out.println("Enter product Id. (* to show all): ");
		// select the style of displaying the information
		String input = ScannerSingleton.getInstance().next();
		// display all product
		if (input.charAt(0) == '*') {
			// header
			System.out.println("Coffee Product information");
			System.out.println("ID  \tName        \tQuantity\tOther Info");
			// foreach
			arr.forEach(p -> System.out.println(p.getInfo()));
		} else {
			// get product by id
			ICoffeeProduct product = ProductListSingleton.getInstance().get(Integer.parseInt(input));
			// header
			System.out.println("Product information");
			// get detail information of the product
			System.out.println(product.getDetailInfo());
		}

		return this;
	}
}
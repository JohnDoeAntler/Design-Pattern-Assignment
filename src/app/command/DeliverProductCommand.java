package app.command;

import java.util.Scanner;

import app.adapter.ICoffeeProduct;
import app.exception.NegativeQuantityException;
import app.exception.ProductIdNotFoundException;
import app.singleton.ProductListSingleton;
import app.singleton.ScannerSingleton;

/**
 * DeliverProductCommand
 */
public class DeliverProductCommand implements ICommand, RecordableCommand {

	private ICoffeeProduct product;

	private int quantity;

	@Override
	public ICommand execute() {
		// get the scanner singleton
		Scanner scanner = ScannerSingleton.getInstance();
		// alert user to enter the code of the product
		System.out.println("Enter code: ");
		// retrieve the product id via scanner, and find the product by product id from the product list singleton
		product = ProductListSingleton.getInstance().get(scanner.nextInt());
		// throw exception when no product was found.
		if (product == null) {
			throw new ProductIdNotFoundException();
		}
		// alert user to enter the quantity
		System.out.println("Quantity to ship: ");
		// retrieve the quantity integer via scanner
		quantity = scanner.nextInt();
		// if the quantity after shipping would be a negative number
		if (product.getQty() - quantity < 0) {
			// throw an exception
			throw new NegativeQuantityException();
		}
		// decline the quantity
		product.setQty(product.getQty() - quantity);
		// show the declined result
		System.out.printf("Shipped %d packs of %s. Current quantity is %d.", quantity, product.getName(), product.getQty());
		// method chaining
		return this;
	}

	@Override
	public void undo() {
		product.setQty(product.getQty() + quantity);
	}

	@Override
	public void redo() {
		product.setQty(product.getQty() - quantity);
	}

	@Override
	public String toString() {
		return String.format("Shipped %d %s (%d)", quantity, product.getName(), product.getProductId());
	}
}
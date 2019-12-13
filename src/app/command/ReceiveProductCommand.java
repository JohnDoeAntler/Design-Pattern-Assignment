package app.command;

import java.util.Scanner;

import app.adapter.ICoffeeProduct;
import app.singleton.ProductListSingleton;
import app.singleton.ScannerSingleton;

/**
 * ReceiveProductCommand
 */
public class ReceiveProductCommand implements ICommand, RecordableCommand {

	private ICoffeeProduct product;

	private int quantity;

	@Override
	public ICommand execute() {
		// get scanner singleton
		Scanner scanner = ScannerSingleton.getInstance();
		// alert user to enter the code
		System.out.println("Enter code: ");
		// get product by user inputted keycode
		product = ProductListSingleton.getInstance().get(scanner.nextInt());
		// alert user to enter the quantity they want to collect
		System.out.println("Quantity to receive: ");
		// retrieve the quantity via the scanner
		quantity = scanner.nextInt();
		// add the quantity
		product.setQty(product.getQty() + quantity);
		// show the result
		System.out.printf("Received %d packs of %s. Current quantity is %d.", quantity, product.getName(), product.getQty());
		// return its self
		return this;
	}

	@Override
	public void undo() {
		product.setQty(product.getQty() - quantity);
	}

	@Override
	public void redo() {
		product.setQty(product.getQty() + quantity);
	}

	@Override
	public String toString() {
		return String.format("Received %d %s (%d)", quantity, product.getName(), product.getProductId());
	}
}
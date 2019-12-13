package app.command;

import java.util.Scanner;

import app.adapter.ICoffeeProduct;
import app.exception.DuplicatedProductIdException;
import app.exception.InvalidCoffeeProductArgumentException;
import app.factory.CoffeeProductFactory;
import app.singleton.ProductListSingleton;
import app.singleton.ScannerSingleton;

/**
 * AddProductCommand
 */
public class CreateProductCommand implements ICommand, RecordableCommand{

	private ICoffeeProduct product;

	@Override
	public ICommand execute() {
		// get the scanner singleton
		Scanner scanner = ScannerSingleton.getInstance();
		// hint
		System.out.print("Enter Coffee type (c=Coffee Candy/p=Coffee Powder): ");
		// get keycode
		char type = scanner.next().charAt(0);
		// flush the scanner
		scanner.nextLine();

		try {
			// generate a coffe product adapter from coffee product factory 
			product = new CoffeeProductFactory().create(type);
			// check whether the key is duplicated 
			if (ProductListSingleton.getInstance().containsKey(product.getProductId())) {
				throw new DuplicatedProductIdException();
			} else {
				// add created coffee product to the product list
				ProductListSingleton.getInstance().put(product.getProductId(), product);
			}
		} catch (DuplicatedProductIdException e) {
			throw e;
		} catch (Exception e) {
			throw new InvalidCoffeeProductArgumentException();
		}

		return this;
	}

	@Override
	public void undo() {
		ProductListSingleton.getInstance().remove(product.getProductId());
	}

	@Override
	public void redo() {
		ProductListSingleton.getInstance().put(product.getProductId(), product);
	}

	@Override
	public String toString() {
		return String.format("Added %d %s", product.getProductId(), product.getName());
	}

}
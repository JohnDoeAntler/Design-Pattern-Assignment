package app.factory;

import app.adapter.CoffeeCandyAdapter;
import app.adapter.CoffeePowderAdapter;
import app.adapter.ICoffeeProduct;
import app.exception.CoffeeProductNotFoundException;

public class CoffeeProductFactory {

	public ICoffeeProduct create(char keycode) {
		switch (keycode) {
			case 'c': return new CoffeeCandyAdapter();
			case 'p': return new CoffeePowderAdapter();
			default: throw new CoffeeProductNotFoundException();
		}
	}

}
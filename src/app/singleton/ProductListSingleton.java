package app.singleton;

import java.util.HashMap;

import app.adapter.ICoffeeProduct;

/**
 * ProductListSingleton
 */
public class ProductListSingleton {

	// singleton field
    private volatile static HashMap<Integer, ICoffeeProduct> singleton;
	
	// block instantiation
    private ProductListSingleton (){}
	
    public static HashMap<Integer, ICoffeeProduct> getInstance() {
		// double-checked locking singleton pattern
        if (singleton == null) {
            synchronized (HashMap.class) {
                if (singleton == null) {
                    singleton = new HashMap<Integer, ICoffeeProduct>();
                }
            }
        }
        return singleton;
    }

}
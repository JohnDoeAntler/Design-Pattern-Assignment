package app.exception;

public class CoffeeProductNotFoundException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CoffeeProductNotFoundException() {
		super("Coffee product not found. Please make sure the keycode is valid.");
	}

}
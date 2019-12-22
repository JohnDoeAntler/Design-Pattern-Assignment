package app.exception;

/**
 * ProductNotFoundException
 */
public class ProductIdNotFoundException extends RuntimeException{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ProductIdNotFoundException() {
		super("No product id was found. Please ensure the product id is invalid.");
	}
}
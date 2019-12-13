package app.exception;

/**
 * NegativeQuantityException
 */
public class NegativeQuantityException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public NegativeQuantityException() {
		super("The quantity is not permitted to be negative.");
	}
	
}
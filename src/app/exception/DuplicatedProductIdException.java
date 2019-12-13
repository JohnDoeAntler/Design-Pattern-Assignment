package app.exception;

/**
 * DuplicatedProductIdException
 */
public class DuplicatedProductIdException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public DuplicatedProductIdException() {
		super("The entered product id already exists, please adopt another one.");
	}

}
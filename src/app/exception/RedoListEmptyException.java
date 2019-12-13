package app.exception;

/**
 * RedoListEmptyException
 */
public class RedoListEmptyException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	public RedoListEmptyException() {
		super("It is not permitted to redo no action.");
	}
}
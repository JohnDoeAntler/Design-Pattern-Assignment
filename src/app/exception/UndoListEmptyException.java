package app.exception;

/**
 * UndoListEmptyException
 */
public class UndoListEmptyException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public UndoListEmptyException() {
		super("It is not permitted to undo no action.");
	}
}
package app.exception;

/**
 * CommandNotFoundException
 */
public class CommandNotFoundException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CommandNotFoundException() {
		super("Command not found.");
	}

}
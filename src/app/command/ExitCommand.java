package app.command;

/**
 * ExitCommand
 */
public class ExitCommand implements ICommand {

	@Override
	public ICommand execute() {
		// exit the system with state 0
		System.exit(0);
		// method chaining
		return this;
	}

}
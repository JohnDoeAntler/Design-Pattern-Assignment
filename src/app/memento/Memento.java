package app.memento;

import app.command.ICommand;

/**
 * Memento
 */
public class Memento {
	
	private final ICommand state;

	public Memento(ICommand state) {
		this.state = state;
	}

	public ICommand getState() {
		return this.state;
	}
}
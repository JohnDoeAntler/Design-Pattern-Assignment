package app.memento;

import app.command.ICommand;

/**
 * Originator
 */
public class Originator {

	private ICommand state;

	public ICommand getState() {
		return this.state; 
	}

	public void setState(ICommand command) {
		this.state = command;
	}

	public Memento createMemento() {
		return new Memento(this.state);
	}

	public void restore(Memento memento) {
		this.state = memento.getState();
	}
}
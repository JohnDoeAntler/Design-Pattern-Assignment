package app.command;

import java.util.Stack;

import app.exception.RedoListEmptyException;
import app.memento.Memento;
import app.memento.Originator;
import app.singleton.RedoListSingleton;
import app.singleton.UndoListSingleton;

/**
 * RedoCommand
 */
public class RedoCommand implements ICommand {

	@Override
	public ICommand execute() {
		// get undo list and redo list
		Stack<Memento> undos = UndoListSingleton.getInstance();
		Stack<Memento> redos = RedoListSingleton.getInstance();

		if (redos.size() > 0) {
			// instantiate a originator
			Originator originator = new Originator();

			// restore originator
			originator.restore(redos.peek());

			// cast the ICommand to UndoableCommand
			((RecordableCommand) originator.getState()).redo();

			// move the undo list's last element to redo list
			undos.push(redos.pop());

			System.out.println("redo completed.");
		} else {
			throw new RedoListEmptyException();
		}

		return this;
	}
}
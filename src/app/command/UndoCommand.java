package app.command;

import java.util.Stack;

import app.exception.UndoListEmptyException;
import app.memento.Memento;
import app.memento.Originator;
import app.singleton.RedoListSingleton;
import app.singleton.UndoListSingleton;

/**
 * UndoCommand
 */
public class UndoCommand implements ICommand {

	@Override
	public ICommand execute() {
		// get undo list and redo list
		Stack<Memento> undos = UndoListSingleton.getInstance();
		Stack<Memento> redos = RedoListSingleton.getInstance();

		if (undos.size() > 0) {
			// instantiate a originator
			Originator originator = new Originator();

			// restore originator
			originator.restore(undos.peek());

			// cast the ICommand to UndoableCommand
			((RecordableCommand) originator.getState()).undo();

			// move the undo list's last element to redo list
			redos.add(undos.pop());

			System.out.println("undo completed.");
		} else {
			throw new UndoListEmptyException();
		}

		return this;
	}
}
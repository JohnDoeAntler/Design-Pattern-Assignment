package app.command;

import java.util.Stack;

import app.memento.Memento;
import app.singleton.RedoListSingleton;
import app.singleton.UndoListSingleton;

/**
 * ShowHistoryCommand
 */
public class ListHistoryCommand implements ICommand {

	@Override
	public ICommand execute() {
		// get undo list and redo list
		Stack<Memento> undos = UndoListSingleton.getInstance();
		Stack<Memento> redos = RedoListSingleton.getInstance();

		System.out.println("Undo List:");
		
		if (undos.size() == 0) {
			System.out.println("Empty");
		} else {
			undos.forEach(undo -> System.out.println(undo.getState().toString()));
		}

		System.out.println("Redo List:");
		if (redos.size() == 0) {
			System.out.println("Empty");
		} else {
			redos.forEach(redo -> System.out.println(redo.getState().toString()));
		}

		return this;
	}
}
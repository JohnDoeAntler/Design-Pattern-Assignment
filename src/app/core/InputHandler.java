package app.core;

import java.util.Scanner;

import app.command.RecordableCommand;
import app.factory.CommandFactory;
import app.memento.Originator;
import app.singleton.RedoListSingleton;
import app.singleton.ScannerSingleton;
import app.singleton.UndoListSingleton;

/**
 * InputHandler
 */
public class InputHandler {

	public void run() {
		// get the instance of scanner singleton
		Scanner scanner = ScannerSingleton.getInstance();
		// instantiate a command factory
		CommandFactory factory = new CommandFactory();
		// instantiate a originator
		Originator originator = new Originator();

		while (true) {
			try {
				// hint
				System.out.println(
					"Coffee Inventory Management System\r\n" +
					"Please enter command: [ a | v | c | s | u | r | l | x ]\r\n" +
					"a = add product, v = view products, c = collect product, s = ship product,\r\n" +
					"u = undo, r = redo, l = show list undo/redo, x = exit system"
				);

				// execute the command and set the state to the command
				originator.setState(factory.create(scanner.next().charAt(0)).execute());

				// if command supports undo and redo function
				if (originator.getState() instanceof RecordableCommand) {
					// append command in undo list
					UndoListSingleton.getInstance().push(originator.createMemento());
					// clear the redo list
					RedoListSingleton.getInstance().clear();
				}

				// adding margin between current command result and next prompt
				System.out.println();
			} catch (Exception e) {
				System.out.println("[ERROR] " + e.getClass().getSimpleName() + " : " + e.getMessage());
			}
		}
	}
}
package app.factory;

import app.command.CreateProductCommand;
import app.command.DeliverProductCommand;
import app.command.ExitCommand;
import app.command.ICommand;
import app.command.ReceiveProductCommand;
import app.command.RedoCommand;
import app.command.ListHistoryCommand;
import app.command.ShowProductCommand;
import app.command.UndoCommand;
import app.exception.CommandNotFoundException;

/**
 * IFactory
 */
public class CommandFactory {
	
	public ICommand create(char key) {
		switch (key) {
			case 'a': return new CreateProductCommand();
			case 'v': return new ShowProductCommand();
			case 'c': return new ReceiveProductCommand();
			case 's': return new DeliverProductCommand();
			case 'u': return new UndoCommand();
			case 'r': return new RedoCommand();
			case 'l': return new ListHistoryCommand();
			case 'x': return new ExitCommand();
			default: throw new CommandNotFoundException();
		}
	}

}
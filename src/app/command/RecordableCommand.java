package app.command;

/**
 * UndoableCommand
 */
public interface RecordableCommand extends ICommand {

	public void undo();

	public void redo();
	
}
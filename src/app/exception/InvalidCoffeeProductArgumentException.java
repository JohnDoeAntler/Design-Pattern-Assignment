package app.exception;

public class InvalidCoffeeProductArgumentException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCoffeeProductArgumentException (){
		super("The inputted arguments does not fullfil the requirement thus the operation has been cancelled.");
	}
}
package application;

public class IllegalPizza extends Exception {
	
	/**
	 * The exception class that takes unacceptable input for pizza and lineitem objects 
	 * and outputs a string with the error message
	 * @author Amaar Jivanji
	 * student id 17amj6
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * constructs a message for an exception
	 * @param message that reads the error
	 */
	public IllegalPizza(String message){
		super(message);
	}
}

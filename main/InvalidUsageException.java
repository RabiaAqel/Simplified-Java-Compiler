package oop.ex2.main;

/**
 * The Class InvalidUsageException.
 *
 * @author  rabeaaqel.
 * This class handles the exceptions concerning the program
 * arguments (should be only 1 program arguments)
 */
public class InvalidUsageException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new invalid usage exception.
	 */
	public InvalidUsageException() {
	    super();
	}
	
	/**
	 * Instantiates a new invalid usage exception.
	 *
	 * @param s the exception message
	 */
	public InvalidUsageException(String s){
	    super(s);
	}	
}

package oop.ex2.main;

/**
 * The Class InvalidFileException.
 *
 * @author  rabeaaqel
 * This class handles the exceptions concerning invalid file errors
 */
public class InvalidFileException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new invalid file exception.
	 */
	public InvalidFileException() {
	    super();
	}
	
	/**
	 * Instantiates a new invalid file exception.
	 *
	 * @param s the exception message
	 */
	public InvalidFileException(String s){
	    super(s);
	}	
}

package oop.ex2.main;

// TODO: Auto-generated Javadoc
/**
 * The Class IllegalSyntax.
 *
 * @author  rabeaaqel.
 * This class handles Illegal syntax errors
 */
public class IllegalSyntaxException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new illegal syntax.
	 */
	public IllegalSyntaxException() {
	    super();
	}
	
	/**
	 * Instantiates a new illegal syntax.
	 *
	 * @param str the exception message
	 */
	public IllegalSyntaxException(String str){
	    super(str);
	}	
}

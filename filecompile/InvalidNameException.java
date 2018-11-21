/*
 * 
 */
package oop.ex2.filecompile;

// TODO: Auto-generated Javadoc
/**
 * The Class InvalidNameException.
 *
 * @author  rabeaaqel.
 * This class handles invalid naming errors
 */
public class InvalidNameException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new invalid name exception.
	 */
	public InvalidNameException() {
	    super();
	}
	
	/**
	 * Instantiates a new invalid name exception.
	 *
	 * @param str the exception message
	 */
	public InvalidNameException(String str){
	    super(str);
	}	
}

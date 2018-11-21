/*
 * 
 */
package oop.ex2.filecompile;

// TODO: Auto-generated Javadoc
/**
 * The Class InvalidParametersException.
 * This class handles invalid parameters errors.
 */
public class InvalidParametersException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new invalid parameters exception.
	 */
	public InvalidParametersException() {
	    super();
	}
	
	/**
	 * Instantiates a new invalid parameters exception.
	 *
	 * @param str the exception message
	 */
	public InvalidParametersException(String str){
	    super(str);
	}	
}

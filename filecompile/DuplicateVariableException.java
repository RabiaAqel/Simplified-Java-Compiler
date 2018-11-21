/*
 * 
 */
package oop.ex2.filecompile;

// TODO: Auto-generated Javadoc
/**
 * The Class DuplicateVariableException.
 *
 * @author  rabeaaqel.
 * This class handles the exceptions concerning the program
 * arguments (should be only 2 program arguments)
 */
public class DuplicateVariableException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new duplicate variable exception.
	 */
	public DuplicateVariableException() {
	    super();
	}
	
	/**
	 * Instantiates a new duplicate variable exception.
	 *
	 * @param str the str
	 */
	public DuplicateVariableException(String str){
	    super(str);
	}	
}

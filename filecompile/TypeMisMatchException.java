package oop.ex2.filecompile;

/**
 * The Class TypeMisMatchException.
 *
 * @author  rabeaaqel
 * This class handles type mismatch exceptions
 */
public class TypeMisMatchException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new type mismatch exception.
	 */
	public TypeMisMatchException() {
	    super();
	}
	
	/**
	 * Instantiates a new type mismatch exception.
	 *
	 * @param str the str
	 */
	public TypeMisMatchException(String str){
	    super(str);
	}	
}

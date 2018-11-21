package oop.ex2.filecompile;

/**
 * The Class NotInitializedException.
 *
 * @author  rabeaaqel
 * This class handles not intialized variables exceptions
 */
public class NotInitializedException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new not initialized exception.
	 */
	public NotInitializedException() {
		super();
	}

	/**
	 * Instantiates a new not initialized exception.
	 *
	 * @param str the exception message
	 */
	public NotInitializedException(String str){
		super(str);
	}	
}

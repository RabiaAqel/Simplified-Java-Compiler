
package oop.ex2.filecompile;


/**
 * The Interface Define, implementing this interface provides an object the defining ability.
 * @author rabeaaqel
 *
 */
public interface Define {

	/**
	 * Checks if its a legal declaration.
	 *
	 * @return true, if legal
	 * @throws InvalidNameException the invalid name exception
	 * @throws DuplicateVariableException the duplicate variable exception
	 * @throws TypeMisMatchException the type mismatch exception
	 * @throws NotInitializedException the not initialized exception
	 * @throws InvalidParametersException the invalid parameters exception
	 * @throws Exception the exception
	 */
	boolean isLegal() throws InvalidNameException,
	DuplicateVariableException, TypeMisMatchException, NotInitializedException, InvalidParametersException, Exception;
	
	/**
	 * Adds the.
	 *
	 * @throws InvalidNameException the invalid name exception
	 * @throws DuplicateVariableException the duplicate variable exception
	 * @throws TypeMisMatchException the type mis match exception
	 * @throws NotInitializedException the not initialized exception
	 * @throws InvalidParametersException the invalid parameters exception
	 * @throws Exception the exception
	 */
	void Add() throws InvalidNameException,
	DuplicateVariableException, TypeMisMatchException, NotInitializedException, InvalidParametersException, Exception;
	
}

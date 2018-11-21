package oop.ex2.main;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Method.
 */
public class Method {

	/** The type. */
	private String type;
	
	/** The local variables of this method. */
	private HashMap<String,Variable> localVariables;
	
	/** The method body. */
	private String body;


	/**
	 * Instantiates a new method.
	 *
	 * @param type the type
	 * @param localVariables the local variables
	 */
	public Method(String type, HashMap<String,Variable> localVariables) {

		this.type = type;
		this.localVariables = localVariables;
		this.body = null;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Gets the local variables.
	 *
	 * @return the local variables
	 */
	HashMap<String, Variable> getLocalVariables() {
		return this.localVariables;
	}
	
	/**
	 * Sets the local variables.
	 *
	 * @param localVariables the local variables
	 */
	void setLocalVariables(HashMap<String,Variable> localVariables) {
		this.localVariables = localVariables;
	}
	
	/**
	 * Gets the body.
	 *
	 * @return the body
	 */
	String getBody() {
		return body;
	}

	/**
	 * Sets the body.
	 *
	 * @param body the new body
	 */
	void setBody(String body) {
		this.body = body;
	}
}

/*
 * 
 */
package oop.ex2.filecompile;

import java.util.HashMap;
import oop.ex2.main.IllegalSyntaxException;
import oop.ex2.main.Variable;

// TODO: Auto-generated Javadoc
/**
 * The Class Condition.
 */
public class Condition {

	/** The condition. */
	private String condition;

	/** The local variables. */
	private HashMap<String, Variable> localVariables;

	/** The members. */
	private HashMap<String, Variable> members;

	/** The INT. */
	private final String INT = "int";

	/** The DOUBLE. */
	private final String DOUBLE = "double";

	/** The BOOLEAN. */
	private final String BOOLEAN = "boolean";

	/** The TRUE. */
	private final String TRUE = "true";

	/** The FALSE. */
	private final String FALSE = "false";

	/** The REGEX. */
	private final String REGEX = "-?\\d+(.\\d+)?";


	/**
	 * Instantiates a new condition.
	 *
	 * @param condition the condition
	 * @param localVariables the local variables
	 * @param members the members
	 */
	public Condition(String condition,
			HashMap<String, Variable> localVariables, HashMap<String, Variable> members){
		this.condition = condition;
		this.localVariables = localVariables;
		this.members = members;

	}

	/**
	 * Checks if is legal.
	 *
	 * @throws IllegalSyntaxException the illegal syntax
	 */
	public void isLegal() throws IllegalSyntaxException {
		if(localVariables.containsKey(condition)) {
			if(typeMatch(localVariables.get(condition).getType())) {
				if(localVariables.get(condition).getValue() != null)
					return;
				else 
					if(!members.containsKey(condition))
						throw new IllegalSyntaxException("Error: using uninitialized local variable '" + condition +"'");

			}
		}
		if(members.containsKey(condition)) {
			if(typeMatch(members.get(condition).getType())){
				if(members.get(condition).getValue() != null)
					return;
				else 
					throw new IllegalSyntaxException("Error: using uninitialized member '" + condition +"'");
			}
		}
		else if(condition.equals(TRUE) || condition.equals(FALSE) 
				|| condition.matches(REGEX))
			return;
		else
			if(!ValueAssign.isMethodCall(condition))
				throw new IllegalSyntaxException("Error: illegal condition statment '" + condition +"'");
		if(!isMethodCall())
			throw new IllegalSyntaxException("Error: illegal condition statment '" + condition +"'");
		else
			addMethodCall();

	}

	private void addMethodCall() throws IllegalSyntaxException {
		String string = condition.substring(0,condition.indexOf("(")).replace(" ", "");
		if(!string.equals("if") && !string.equals("while"))
			Call.addCall(string, "if\\while");
		else
			throw new IllegalSyntaxException("Error: illegal condition statment '" + condition +"'");

	}

	private boolean isMethodCall() {
		return ValueAssign.isMethodCall(condition);
	}

	/**
	 * Type match.
	 *
	 * @param type the type
	 * @return true, if successful
	 */
	private boolean typeMatch(String type){
		return (type.equals(INT) || type.equals(DOUBLE) || type.equals(BOOLEAN));
	}
}



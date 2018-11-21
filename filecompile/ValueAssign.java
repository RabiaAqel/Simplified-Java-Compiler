/*
 * 
 */
package oop.ex2.filecompile;

import java.util.HashMap;

import oop.ex2.main.IllegalSyntaxException;
import oop.ex2.main.Variable;



// TODO: Auto-generated Javadoc
/**
 * The Class ValueAssign.
 */
public class ValueAssign {
	
	/** The Constant INT_REGEX. */
	protected final static String INT_REGEX = "-?\\d*";
	
	/** The Constant DOUBLE_REGEX. */
	protected final static String DOUBLE_REGEX = "-?\\d*.\\d*";
	
	/** The Constant STRING_REGEX. */
	protected final static String STRING_REGEX = "(\"(.*)\")";
	
	/** The Constant BOOLEAN_REGEX. */
	protected final static String BOOLEAN_REGEX = "(true)|(false)|(\\d*)|(\\d*.\\d*)";
	
	/** The Constant ASSIGNMENT_REGEX. */
	protected final static  String ASSIGNMENT_REGEX = "\\s*([^ ]*)\\s*=\\s*([^ ]*)\\s*;\\s*";
	
	/** The Constant CHAR_REGEX. */
	protected final static String CHAR_REGEX = "'*.'";


	/**
	 * Assign.
	 *
	 * @param variable the variable
	 * @param value the value
	 * @param localVariables the local variables
	 * @param members the members
	 * @param methodsCalls 
	 * @throws IllegalSyntaxException the illegal syntax
	 * @throws TypeMisMatchException the type mis match exception
	 * @throws NotInitializedException the not initialized exception
	 */
	public static void assign(String variable, String value,
			HashMap<String, Variable> localVariables,
			HashMap<String, Variable> members) throws IllegalSyntaxException,
			TypeMisMatchException, NotInitializedException {

		if(!isVariable(variable, localVariables, members))
			throw new IllegalSyntaxException("Error: "+variable+" cannot be resolved as a variable");

		if(isFinalVariable(variable, localVariables, members))
			throw new IllegalSyntaxException("Error: cannot assign value to final");	

		if(!isVariable(value, localVariables, members)) {
			String type = (localVariables.containsKey(variable))?(localVariables.get(variable).getType()):
				(members.get(variable).getType());
			if(!typeMatch(value, type))
				if(!(isMethodCall(value)))
				throw new TypeMisMatchException("Error: cannot assign "+value+" to "+type);	
				else
					Call.addCall(value.substring(0,value.indexOf("(")).replace(" ", ""),
							variable);
		}
		else {
			if(!isInitializedVariable(value, localVariables, members))
				throw new NotInitializedException("Error: cannot assign uninitialized value");
			if(!variableTypesMatch(variable, value, localVariables, members))
				throw new TypeMisMatchException("Error: type mismatch of "+value+" to "+variable);
		}

		return;


	}

	 static boolean isMethodCall(String value) {
		 return value.matches("\\s*([^ \\(\\)]+)\\s*\\(\\s*(.*)\\s*\\)\\s*");
	}

	/**
	 * Variable types match.
	 *
	 * @param variable the variable
	 * @param value the value
	 * @param localVariables the local variables
	 * @param members the members
	 * @return true, if successful
	 */
	private static boolean variableTypesMatch(String variable, String value,
			HashMap<String, Variable> localVariables,
			HashMap<String, Variable> members) {


		if(members.containsKey(variable)) {

			if(members.containsKey(value))
				if(members.get(variable).getType().equals(members.get(value).getType()))
					return true;
			if(localVariables.containsKey(value))
				if(members.get(variable).getType().equals(localVariables.get(value).getType()))
					return true;
			
		}



		if(localVariables.containsKey(variable)){

			if(members.containsKey(value))
				if(localVariables.get(variable).getType().equals(members.get(value).getType()))
					return true;
			if(localVariables.containsKey(value))
				if(localVariables.get(variable).getType().equals(localVariables.get(value).getType()))
					return true;

		}
		return false;
	}

	/**
	 * Checks if is initialized variable.
	 *
	 * @param value the value
	 * @param localVariables the local variables
	 * @param members the members
	 * @return true, if is initialized variable
	 */
	static boolean isInitializedVariable(String value,
			HashMap<String, Variable> localVariables,
			HashMap<String, Variable> members) {

		if(members.containsKey(value) && !localVariables.containsKey(value))
			return members.get(value).isInitialized();

		if(!members.containsKey(value) && localVariables.containsKey(value))
			return localVariables.get(value).isInitialized();

		if(members.containsKey(value) && localVariables.containsKey(value))
			return (localVariables.get(value).isInitialized() ||
					members.get(value).isInitialized());	
		
		return false;

	}

	/**
	 * Checks if is final variable.
	 *
	 * @param variable the variable
	 * @param localVariables the local variables
	 * @param members the members
	 * @return true, if is final variable
	 */
	private static boolean isFinalVariable(String variable,
			HashMap<String, Variable> localVariables,
			HashMap<String, Variable> members) {

		if(members.containsKey(variable) && !localVariables.containsKey(variable))
			return members.get(variable).isFinal();

		if(!members.containsKey(variable) && localVariables.containsKey(variable))
			return localVariables.get(variable).isFinal();

		if(members.containsKey(variable) && localVariables.containsKey(variable))
			return (localVariables.get(variable).isFinal() && members.get(variable).isFinal());	

		return false;
	}

	/**
	 * Checks if is variable.
	 *
	 * @param variable the variable
	 * @param localVariables the local variables
	 * @param members the members
	 * @return true, if is variable
	 */
	static boolean isVariable(String variable,
			HashMap<String,Variable> localVariables, HashMap<String,Variable> members) {
		return (members.containsKey(variable) || localVariables.containsKey(variable));
	}

	/**
	 * Type match.
	 *
	 * @param value the value
	 * @param type the type
	 * @return true, if successful
	 */
	public static boolean typeMatch(String value, String type) {
		if (type.matches("int")) {
			return value.matches(INT_REGEX);
		}

		else if (type.equals("double")) {
			return value.matches(DOUBLE_REGEX);
		}

		else if (type.equals("String")) {
			return value.matches(STRING_REGEX);
		}

		else if (type.equals("boolean")) {
			return value.matches(BOOLEAN_REGEX);
		}

		else if (type.equals("char")) {
			return value.matches(CHAR_REGEX);
		}
		return false;
	}
}

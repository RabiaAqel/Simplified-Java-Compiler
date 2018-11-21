/**
 * 
 */
package oop.ex2.filecompile;

import java.util.HashMap;
import oop.ex2.main.Variable;

// TODO: Auto-generated Javadoc
/**
 * The Class VariableDefine.
 *
 * @author rabeaaqel
 */
public class VariableDefine implements Define {

	/** The type. */
	private String type;

	/** The value. */
	protected String value;

	/** The is final. */
	private boolean isFinal;

	/** The is initialized. */
	private boolean isInitialized;

	/** The name. */
	protected Name name;

	/** The variables. */
	protected HashMap<String, Variable> variables;





	/**
	 * Instantiates a new variable define.
	 *
	 * @param type the type
	 * @param value the value
	 * @param isFinal the is final
	 * @param isInitialized the is initialized
	 * @param name the name
	 * @param variables the variables
	 * @param callLog 
	 */
	public VariableDefine(String type, String value,
			String isFinal, boolean isInitialized, Name name ,HashMap<String,
			Variable> variables){
		this.type = type;
		this.value = value;
		this.isFinal = (isFinal == (null))?false:true;
		this.isInitialized = isInitialized;
		this.name = name;
		this.variables = variables;

	}

	/* (non-Javadoc)
	 * @see oop.ex2.filecompile.Define#isLegal()
	 */
	@Override
	public boolean isLegal() throws InvalidNameException,
	DuplicateVariableException, TypeMisMatchException, NotInitializedException {
		if( isFinal && !(name instanceof ParameterName))
			if ( value == null)
				throw new NotInitializedException("Error: Declaring an uninitialized final variable");
		if(!name.isLegal()) {

			throw new InvalidNameException("Error: invalid varialbe name " + "'" +name.getName()+ "'");

		}
		else {  
			if(!variables.isEmpty()) {
				if(variables.containsKey(name.getName())){
					//handle error
					throw new DuplicateVariableException("Error: duplicate variable " +"'" +name.getName()+ "'");
				}
			}
			if( value != null) {
				if (!typeMatch())
					if(!(isVariable())){
						if(!(isMethodCall()))
							throw new TypeMisMatchException("Error: Illegal value "+ value +" for type " +type);
						else 
							callLogAdd();
					}
					else if(!isInitialized())
						throw new NotInitializedException("Error: attempt to assign uninitialized variable");
				isInitialized = true;
			}
		}
		return true;

	}

	private void callLogAdd() {
		Call.addCall(value.substring(0,value.indexOf("(")).replace(" ", ""), name.getName());

	}

	private boolean isMethodCall() {
		return ValueAssign.isMethodCall(value);
	}

	boolean isInitialized() {
		return variables.get(value).isInitialized();
	}

	/**
	 * Checks if is variable.
	 *
	 * @return true, if is variable
	 */
	boolean isVariable() {
		return (variables.containsKey(value))?
				(variables.get(value).getType().equals(type)):false;
	}

	/**
	 * Type match.
	 *
	 * @return true, if successful
	 */
	private boolean typeMatch() {
		return ValueAssign.typeMatch(value, type);
	}

	/* (non-Javadoc)
	 * @see oop.ex2.filecompile.Define#Add()
	 */
	@Override
	public void Add() throws InvalidNameException,
	DuplicateVariableException, TypeMisMatchException, NotInitializedException{

		if (this.isLegal()){
			variables.put(name.getName(), new Variable(isFinal, isInitialized, type, value));
		}
	}

}

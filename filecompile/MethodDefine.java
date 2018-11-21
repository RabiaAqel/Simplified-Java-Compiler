/**
 * 
 */
package oop.ex2.filecompile;

import java.util.HashMap;
import java.util.regex.*;


import oop.ex2.main.Method;
import oop.ex2.main.Variable;

// TODO: Auto-generated Javadoc
/**
 * The Class MethodDefine.
 *
 * @author rabeaaqel
 */
public class MethodDefine implements Define {

	/** The type. */
	private String type;

	/** The name. */
	private Name name;

	/** The parameters. */
	private String parameters;

	/** The parameters regex. */
	protected Pattern parametersRegex = Pattern.compile
			("(\\s*((final)\\s)?\\s*(int|double|String|boolean|char)" +
					"\\s+([^ ,]*)\\s*)(,\\s*((final)\\s)?\\s*" +
					"(int|double|String|boolean|char)\\s+([^ ,]*)\\s*)*");

	/** The REGEX. */
	protected Pattern REGEX = Pattern.compile("\\s*((final)\\s)?\\s*(int|double|String|boolean|char)" +
			"\\s+([^ ,]*)\\s*");

	/** The local variables. */
	private HashMap<String, Variable> localVariables;

	/** The methods. */
	private HashMap<String, Method> methods;

	/** The methods. */
	private HashMap<String, Variable> members;




	/**
	 * Instantiates a new method define.
	 *
	 * @param type the type
	 * @param name the name
	 * @param parameters the parameters
	 * @param methods the methods
	 * @param members the members
	 */
	public MethodDefine(String type, Name name,
			String parameters, HashMap<String, Method> methods, HashMap<String, Variable> members){
		this.type = type;
		this.name = name;
		this.parameters = parameters;
		localVariables = new HashMap<String, Variable>();
		this.methods = methods;
		this.members = members;

	}

	/* (non-Javadoc)
	 * @see oop.ex2.filecompile.Define#isLegal()
	 */
	@Override
	public boolean isLegal() throws DuplicateVariableException, TypeMisMatchException,
	NotInitializedException, Exception{
		if(Call.isContains("boo"))
			System.out.println("IDO");
		if(!name.isLegal()) {

			throw new InvalidNameException("Error: invalid method name "
					+ "'" +name.getName()+ "'");

		}
		else if(methods.containsKey(name.getName())) {
			throw new DuplicateVariableException("Error: duplicate method " +
					"" +"'" +name.getName()+ "'");
		}

		else if(!validParameters()){

			throw new InvalidParametersException("Error: illegal parameters '" +parameters+ "'" +
					" for " + name.getName());
		}
		if(!parameters.equals("")){
			String[] parametersArray = parameters.split(",");
			for(String parameter:parametersArray) {
				Matcher matcher = REGEX.matcher(parameter);
				matcher.matches();
				Define define = new LocalVariableDefine(matcher.group(3), null, matcher.group(2),
						true, new ParameterName(matcher.group(4)), localVariables, members);
				define.Add();
			}
		}
		return true;

	}

	/**
	 * Valid parameters.
	 *
	 * @return true, if successful
	 */
	private boolean validParameters() {
		if(!parameters.equals("")){
			Matcher matcher;
			matcher = parametersRegex.matcher(parameters);
			return matcher.matches();
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see oop.ex2.filecompile.Define#Add()
	 */
	@Override
	public void Add() throws Exception{
		if (this.isLegal()) {
			methods.put(name.getName(), new Method(type, localVariables));
			if(Call.isContains(name.getName())) {
				if(Call.getCallLog().get(name.getName()).equals("if\\while"))
					if(!methods.get(name.getName()).getType().equals("boolean") ||
							!methods.get(name.getName()).getType().equals("int")
							|| !methods.get(name.getName()).getType().equals("double"))
						throw new TypeMisMatchException("Error: "+name.getName()+"" +
								" type is not a conditional type");

				//if(methods.get(name.getName()).getType().equals(Call.getCallLog().get(name.getName()));
				Call.RemoveMethod(name.getName());
			}

		}
	}

}

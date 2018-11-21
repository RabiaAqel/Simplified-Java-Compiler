package oop.ex2.filecompile;

import java.util.HashMap;

import oop.ex2.main.Variable;

public class LocalVariableDefine extends VariableDefine implements Define {

	private HashMap<String, Variable> members;

	public LocalVariableDefine(String type, String value, String isFinal,
			boolean isInitialized, Name name,
			HashMap<String, Variable> variables,
			HashMap<String, Variable> members) {
		super(type, value, isFinal, isInitialized, name, variables);
		this.members = members;

	}

	/**
	 * Checks if is variable.
	 *
	 * @return true, if is variable
	 */
	@Override
	protected boolean isVariable() {
		return ValueAssign.isVariable(value, variables, members);

	}

	boolean isInitialized() {
		return ValueAssign.isInitializedVariable(value, variables, members);
	}

}

/*
 * 
 */
package oop.ex2.filecompile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class MethodName.
 */
public class MethodName extends Naming {

	/** The REGEX. */
	private final String REGEX ="([A-Za-z][A-Za-z_0-9]*)";
	
	/**
	 * Instantiates a new method name.
	 *
	 * @param name the name
	 */
	public MethodName(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see oop.ex2.filecompile.Naming#isLegal()
	 */
	@Override
	public boolean isLegal() {
		pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	/* (non-Javadoc)
	 * @see oop.ex2.filecompile.Naming#isExist()
	 */
	@Override
	public boolean isExist() {
		return false;
	}

}

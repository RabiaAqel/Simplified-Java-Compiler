package oop.ex2.main;

import java.util.regex.Pattern;

/**
 * The Class RegexPattern.
 * This class carries the regular expressions attributes for the compiler class ( super-class)
 */
public class RegexPattern {

	/** The variable regex. */
	protected final String VARIABLE_REGEX =
			("\\s*((final)\\s)?\\s*(int|double|String|boolean|char)" +
					"\\s+([^= ]*)\\s*(=\\s*(([^;]+)))?\\s*;\\s*");
	
	/** The method regex. */
	protected final String METHOD_REGEX = 
			"\\s*(void|int|double|String|boolean|char)" +
					"\\s*([^ ]*)\\s*\\(\\s*([^\\{]*)\\s*\\)\\s*\\{\\s*";
	
	/** The if regex. */
	protected final String IF_REGEX = 
			"\\s*if\\s*\\(\\s*([^ ]*)\\s*\\)\\s*\\{\\s*";
	
	/** The while regex. */
	protected final String WHILE_REGEX = 
			"\\s*while\\s*\\(\\s*([^ ]*)\\s*\\)\\s*\\{\\s*";
	
	/** The return statment. */
	protected final String RETURN_STATMENT = 
			"\\s*return\\s*([^ ;]+)*\\s*;\\s*";
	
	/** The int regex. */
	protected final String INT_REGEX = "-?\\d*";
	
	/** The double regex. */
	protected final String DOUBLE_REGEX = "-?\\d*.\\d*";
	
	/** The string regex. */
	protected final String STRING_REGEX = "(\"(.*)\")";
	
	/** The boolean regex. */
	protected final String BOOLEAN_REGEX = "(true)|(false)|(\\d*)|(\\d*.\\d*)";
	
	/** The assignment regex. */
	protected final String ASSIGNMENT_REGEX = "\\s*([^ ]*)\\s*=\\s*([^ ]*)\\s*;\\s*";
	
	/** The char regex. */
	protected final String CHAR_REGEX = "'*.'";
	
	/** The call method regex. */
	protected final String CALL_REGEX = "\\s*([^ \\(\\)]+)\\s*\\(\\s*(.*)\\s*\\)\\s*;\\s*";
	
	/** The variable pattern. */
	protected Pattern variablePattern;
	
	/** The method define pattern. */
	protected Pattern methodDefinePattern;
	
	/** The if pattern. */
	protected Pattern ifPattern;
	
	/** The while pattern. */
	protected Pattern whilePattern;
	
	/** The return pattern. */
	protected Pattern returnPattern;
	
	/** The assignment pattern. */
	protected Pattern assignmentPattern;
	
	/** The method call pattern. */
	protected Pattern callPattern;
	
	

	/**
	 * Pattern compile.
	 * compiles the regular expressions to patterns in order to use them lately
	 */
	void patternCompile() {
		variablePattern = Pattern.compile(VARIABLE_REGEX);
		methodDefinePattern = Pattern.compile(METHOD_REGEX);
		ifPattern = Pattern.compile(IF_REGEX);
		whilePattern = Pattern.compile(WHILE_REGEX);
		returnPattern = Pattern.compile(RETURN_STATMENT);
		assignmentPattern = Pattern.compile(ASSIGNMENT_REGEX);
		callPattern = Pattern.compile(CALL_REGEX);

	}
}

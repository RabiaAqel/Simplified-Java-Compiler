package oop.ex2.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Class ClearComments.
 */
public class ClearComments {

	/** The Constant SINGLE_LINE_REGEX. */
	private static final String SINGLE_LINE_REGEX = "[^/]*(//)(.*)?";

	/** The Constant MULTI_LINE_IN_ONE_LINE_REGEX. */
	private static final String MULTI_LINE_IN_ONE_LINE_REGEX = 
			"([^/\\*+]*?(/\\**[^\\*/]*\\*+/)[^\\*/]*?)+";

	/** The Constant MULTI_LINE_START_REGEX. */
	private static final String MULTI_LINE_START_REGEX = "\\s*(/\\**)[^\\*/]*?";

	/** The Constant MULTI_LINE_END_REGEX. */
	private static final String MULTI_LINE_END_REGEX = "(.*)(\\*/)\\s*";

	/** The Constant REPLACE_COMMENT_REGEX. */
	private static final String REPLACE_COMMENT_REGEX = "/\\*+[^/]*\\*+/";

	/** The Constant REPLACE_COMMENT2_REGEX. */
	private static final String REPLACE_COMMENT2_REGEX = "(//)(.*)?";

	/** The iterator. */
	private static Iterator<String> iterator;

	/** The list of lines. */
	private static ArrayList<String> list;

	/** The current line number. */
	private static int lineNumber;

	/** The exception. */
	private static Exception exception;

	/**
	 * Clears file comments.
	 *
	 * @param bufferedReader the buffered reader
	 * @return the array list of code line cleared of comments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	static ArrayList<String> clear(BufferedReader bufferedReader) throws IOException {
		// initializing the lines array list
		list = new ArrayList<String>();
		String line = null;
		// reading using the bufferedReader stream and adding each line into the array list
		while ((line = bufferedReader.readLine()) != null){
			list.add(line);
		}
		// intializing the iterator to the lines list
		iterator = list.iterator();
		lineNumber = 0;
		// clearing comments
		while (iterator.hasNext()) {
			// next line
			line = iterator.next();

			if (line.equals(""))
				iterator.remove();
			else if (line.matches(SINGLE_LINE_REGEX)) 
				deleteInLineComment(line);
			else if (line.matches(MULTI_LINE_IN_ONE_LINE_REGEX)) 
				deleteInLineComment(line);
			else if (line.matches(MULTI_LINE_START_REGEX) )
				deleteMultiLineComment(lineNumber);
			// updating current line number
			lineNumber++;
		}
		// returns the cleared file lines as a array list
		return list;
	}

	/**
	 * Delete multi line comment.
	 *
	 * @param line the line
	 */
	private static void deleteMultiLineComment(int line) {
		boolean isEnded = false;
		iterator.remove();
		// removes each lines til the mather finds the comment
		while (iterator.hasNext()) { 
			lineNumber++;
			if (!iterator.next().matches(MULTI_LINE_END_REGEX))
				iterator.remove();
			else {
				// case multi line comment end found sets the isEnded true
				isEnded = true;
				iterator.remove();
				break;
			}
		}
		// case no comment end found creates a new exception
		if(!isEnded) {
			exception = new IllegalSyntaxException("Error: end of comment expected in line "+line);
		}
	}

	/**
	 * Delete in line comment.
	 *
	 * @param string the string
	 */
	private static void deleteInLineComment(String string) {
		// replaces current line with a new line excluding the comment part
		list.set(list.indexOf(string), string.replaceAll(REPLACE_COMMENT_REGEX, ""));
		list.set(list.indexOf(string), string.replaceAll(REPLACE_COMMENT2_REGEX, ""));
	}

	/**
	 * Gets the exception.
	 *
	 * @return the exception
	 */
	public static Exception getException() {
		// returns the exception
		return exception;
	}
}

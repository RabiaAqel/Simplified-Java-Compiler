/*
 * 
 */
package oop.ex2.filecompile;

import java.util.*;
// TODO: Auto-generated Javadoc

/**
 * The Class BalancedParentheses.
 */
public class BalancedParentheses {

	/** The line. */
	private String line;

	/**
	 * Instantiates a new balanced parentheses.
	 *
	 * @param line the line
	 */
	public BalancedParentheses(String line) {
		this.line = line;
		if(line.length() != 0 && check(line)) {
			checkBalance();
		} else
			System.out.println("Invalid Input!");
	}

	/**
	 * Check.
	 *
	 * @param a the a
	 * @return true, if successful
	 */
	public static boolean check(String a) {
		boolean isReturn = true;
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != '(' && a.charAt(i) != ')') {
				isReturn = false;
				break;
			}
		}
		return isReturn;
	}

	/**
	 * Check balance.
	 */
	public void checkBalance() {
		Stack<Character> st = new Stack<Character>();
		int index = 0;
		int[] arr = new int[line.length()];
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '('){
				st.push(line.charAt(i));
				arr[index] = i;
				index++;
			}
			else {
				if(line.charAt(i) == ')' && !st.empty() && st.peek().equals('(')) {
					st.pop();
					index--;
					line = line.substring(0, arr[index]) +
							"[" + line.substring((arr[index] + 1), i) + "]" + line.substring(i+1, line.length());
				} else
					st.push(line.charAt(i));
			}
		}
		System.out.println("Result: " + line);
		if(st.empty())
			System.out.println("They are balanced!");
		else
			System.out.println("They're not balanced!");
	}
}
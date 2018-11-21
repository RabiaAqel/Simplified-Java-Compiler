package oop.ex2.filecompile;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Call.
 */
public class Call {


	/** The call log. */
	private static HashMap<String,String> callLog;

	/**
	 * Instantiates a new call.
	 */
	public Call() {
		callLog = new HashMap<String, String>();
	}

	/**
	 * Gets the call log.
	 *
	 * @return the call log
	 */
	public static HashMap<String, String> getCallLog() {
		return callLog;
	}

	/**
	 * Sets the call log.
	 *
	 * @param callLog the call log
	 */
	static void setCallLog(HashMap<String, String> callLog) {
		Call.callLog = callLog;
	}

	/**
	 * Adds the call.
	 *
	 * @param method the method
	 * @param name the name
	 */
	public static void addCall(String method, String name) {
			callLog.put(method, name);
	}

	/**
	 * Checks if is contains.
	 *
	 * @param method the method
	 * @return true, if is contains
	 */
	public static boolean isContains(String method) {
		return callLog.containsKey(method);
	}

	/**
	 * Gets the name.
	 *
	 * @param method the method
	 * @return the name
	 */
	public String getName(String method) {
		return (isContains(method))?callLog.get(method):null;
	}

	/**
	 * Removes the method.
	 *
	 * @param methodName the method name
	 */
	public static void RemoveMethod(String methodName) {
		callLog.remove(methodName);
	}

}

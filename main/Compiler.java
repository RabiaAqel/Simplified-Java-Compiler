package oop.ex2.main;

import java.io.*;
import oop.ex2.filecompile.*;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;

// TODO: Auto-generated Javadoc
/**
 * The Class Compiler.
 *
 * @author rbybwql
 */
public class Compiler extends RegexPattern {

	/** The read from file. */
	private static ReadFromFile readFromFile;

	/** The buffered reader. */
	private BufferedReader bufferedReader;

	/** The members. */
	protected static HashMap<String, Variable> members;

	/** The methods. */
	protected static HashMap<String, Method> methods;

	/** The methods calls. */
	protected static Call methodCalls;

	/** The exception. */
	protected static Exception exception;

	/** The lines. */
	protected ArrayList<String> lines;

	/** The matcher. */
	protected Matcher matcher;

	/** The line number. */
	protected static int lineNumber;

	/** The iterator. */
	Iterator<String> iterator;

	/**
	 * Instantiates a new compiler.
	 *
	 * @param fileName the file name
	 */
	public Compiler(String fileName) {
		Compiler.readFromFile = new ReadFromFile(fileName);
		members = new HashMap<String, Variable>();
		methods = new HashMap<String, Method>();
		methodCalls = new Call();
		lineNumber = -1;

	}

	/**
	 * Compile.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws NotInitializedException 
	 * @throws TypeMisMatchException 
	 * @throws IllegalSyntaxException 
	 */
	public void compile() throws IOException {
		bufferedReader = readFromFile.readFile();
		lines = ClearComments.clear(bufferedReader);
		bufferedReader.close();
		exception = ClearComments.getException();
		iterator = lines.iterator();
		String line = null;
		patternCompile();
		while ((iterator.hasNext())) {
			lineNumber++;
			line = iterator.next();
			matcher = variablePattern.matcher(line);

			// Case the syntax matches variable declaration pattern
			if (matcher.matches()) {
				newVariable(matcher.group(3), matcher.group(6),
						matcher.group(2), new VariableName(matcher.group(4)
								.trim()));

				continue;
			}

			matcher.reset();
			matcher = methodDefinePattern.matcher(line);
			if (matcher.matches()) {
				newMethod(matcher.group(1), new MethodName(matcher.group(2)),
						matcher.group(3));
				continue;
			}

			matcher.reset();
			matcher = callPattern.matcher(line);
			if (matcher.matches()) {
				isMethod(matcher.group(1));
				continue;

			}
			if (line.equals(""))
				continue;
			handleError("Error: Illegal syntax '" + line + "'");
		}
		try {
			compileMethods();
			checkMethodsCall();
		}
		catch (Exception e){
			handleError(e.getMessage());
		}
			if (exception != null)
				handleError(exception.getMessage());
		}

		private void checkMethodsCall() throws TypeMisMatchException {
			if(!Call.getCallLog().isEmpty()) {
				for(String key : methods.keySet()) {
					if(Call.getCallLog().containsKey(key)){
						if(Call.getCallLog().get(key).equals("if\\while")){
							String type = methods.get(key).getType();
							if(!(type.equals("boolean") ||
									type.equals("int")
									|| type.equals("double"))){
								throw new TypeMisMatchException("Error: cannot return" +
										" "+type+" for "+Call.getCallLog().get(key));
							}
						}
					}
					Call.RemoveMethod(key);
				}

				if(Call.getCallLog().isEmpty())
					return;
				String undefinedMethods ="";
				for(String key: Call.getCallLog().keySet()) {
					undefinedMethods += key +", ";
				}
				handleError("Error: "+undefinedMethods+ " undefined method\\s");
			}
			else
				return;
		}


		private void compileMethods() throws Exception {
			if(methods !=null)
				try {

					for (Entry<String, Method> method : methods.entrySet()) {
						compile(method.getKey(), method.getValue().getBody());
					}
				}
			catch (Exception e){
				throw e;
			}

		}

		private void isMethod(String group) {
			if(methods.containsKey(group))
				return;
			else
				handleError("Error: the method '"+group+"' is undefined");

		}

		/**
		 * New method.
		 *
		 * @param type the type
		 * @param name the name
		 * @param parameters the parameters
		 */
		private void newMethod(String type, Name name, String parameters) {
			Define define = new MethodDefine(type, name, parameters, methods, members);
			try {
				define.Add();
				methods.get(name.getName()).setBody(readMethod(name.getName()));
			} catch (Exception e) {
				handleError(e.getMessage());

			}

		}

		/**
		 * Method compile.
		 *
		 * @param methodName the method name
		 * @param methodBody the method body
		 * @throws Exception 
		 * @throws InvalidParametersException 
		 * @throws DuplicateVariableException 
		 * @throws InvalidNameException 
		 */
		private void compile(String methodName, String methodBody)
				throws InvalidNameException, DuplicateVariableException,
				InvalidParametersException, Exception {
			String lines[] = methodBody.split("\n");
			for (String line : lines) {
				matcher = variablePattern.matcher(line);
				if (matcher.matches()) {
					Define define = new LocalVariableDefine(matcher.group(3),
							matcher.group(6), matcher.group(2), false,
							new VariableName(matcher.group(4).trim()), methods.get(
									methodName).getLocalVariables(), members);
					define.Add();
					continue;


				}
				matcher.reset();
				matcher = ifPattern.matcher(line);
				if (matcher.matches()) {
					isCondition(matcher.group(1), methods.get(methodName)
							.getLocalVariables());
					continue;
				}

				matcher.reset();
				matcher = whilePattern.matcher(line);
				if (matcher.matches()) {
					isCondition(matcher.group(1), methods.get(methodName)
							.getLocalVariables());
					continue;
				}

				matcher.reset();
				matcher = returnPattern.matcher(line);
				if (matcher.matches()) {
					returnTypeMacth(methods.get(methodName).getType(),
							matcher.group(1), methods.get(methodName)
							.getLocalVariables());
					continue;
				}

				matcher.reset();
				matcher = assignmentPattern.matcher(line);
				if (matcher.matches()) {
					valueAssign(matcher.group(1), matcher.group(2),
							methods.get(methodName).getLocalVariables());
					continue;
				}


				if(line.matches("\\s*\\{\\s*"))
					continue;
				if (line.matches("\\s*\\}\\s*"))
					continue;


				throw new IllegalSyntaxException("Error: Illegal syntax '" + line + "'");

			}
		}

		/**
		 * Value assign.
		 *
		 * @param variable the variable
		 * @param value the value
		 * @param localVariables the local variables
		 * @param methodsCalls 
		 * @throws IllegalSyntaxException the illegal syntax
		 * @throws TypeMisMatchException the type mis match exception
		 * @throws NotInitializedException the not initialized exception
		 */
		private void valueAssign(String variable, String value,
				HashMap<String, Variable> localVariables) throws IllegalSyntaxException,
				TypeMisMatchException, NotInitializedException {
			ValueAssign.assign(variable, value, localVariables, members);
		}

		/**
		 * Return type macth.
		 *
		 * @param methodType the method type
		 * @param returnValue the return value
		 * @param localVariables the local variables
		 * @throws IllegalSyntaxException the illegal syntax
		 */
		private void returnTypeMacth(String methodType, String returnValue,
				HashMap<String, Variable> localVariables) throws IllegalSyntaxException {
			if (methodType.equals("void"))
				if (returnValue != null)
					throw new IllegalSyntaxException(
							"Error: void methods cannot return a value");
				else
					return;
			if (localVariables.containsKey(returnValue)) {
				String type = localVariables.get(returnValue).getType();
				if (type.equals(methodType))
					return;
				else
					throw new IllegalSyntaxException("Error: cannot return " + type
							+ " to type " + methodType);
			}

			if (members.containsKey(returnValue)) {
				String type = members.get(returnValue).getType();
				if (type.equals(methodType))
					return;
				else
					throw new IllegalSyntaxException("Error: cannot return " + type
							+ " to type " + methodType);
			}

			if (ValueAssign.typeMatch(returnValue, methodType))
				return;
			throw new IllegalSyntaxException("Error: illegal return statement");

		}



		/**
		 * Checks if is condition.
		 *
		 * @param condition the condition
		 * @param localVariables the local variables
		 */
		private void isCondition(String condition,
				HashMap<String, Variable> localVariables) {
			Condition newCondition = new Condition(condition, localVariables,
					members);
			try {
				newCondition.isLegal();
			} catch (Exception e) {
				handleError(e.getMessage());
			}
		}

		/**
		 * Read method.
		 *
		 * @param name the name
		 * @return the string
		 */
		private String readMethod(String name) {
			String body = "";
			String line = null;
			int nesting = 1;
			while ((iterator.hasNext()) && nesting != 0) {
				lineNumber++;
				line = iterator.next();
				body += line + "\n";
				if (line.contains("}"))
					nesting--;
				else if (line.contains("{"))
					nesting++;
			}
			if (nesting != 0)
				handleError("Error: unclosed method " + name);
			else
				return body;
			return body;
		}

		/**
		 * New variable.
		 *
		 * @param type the type
		 * @param value the value
		 * @param isFinal the is final
		 * @param name the name
		 */
		public static void newVariable(String type, String value, String isFinal,
				Name name) {

			Define define = new VariableDefine(type, value, isFinal, false, name,
					members);
			try {
				define.Add();
			} catch (Exception e) {
				handleError(e.getMessage());
			}
		}

		/**
		 * Handle error.
		 *
		 * @param error the error
		 */
		private static void handleError(String error) {
			System.out.println(error);
			System.exit(1);
		}

	}

package oop.ex2.main;

import java.io.File;
import java.io.IOException;



// TODO: Auto-generated Javadoc
/**
 * The Class Sjavac.
 * @author rabeaaqel
 */
public class Sjavac {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args)  {

		// checks args and creates new Compiler object
		try {
			checkArgs(args);
			Compiler compiler = new Compiler(args[0]);
			compiler.compile();

		}
		/**
		 *  handles errors through system exit in case checkArgs throws IO exceptions and valid using.
		 */
		catch (IOException e) {
			// catches IO exceptions
			handleError(e.getMessage());
		}
		catch (InvalidFileException e) {
			// catches Invalid file exceptions
			handleError(e.getMessage());
		} 
		catch (InvalidUsageException e) {
			// catches invalid usage exceptions
			handleError(e.getMessage());
		}
		/*
		 * the finally block - in case the compiler reaches this block it indicates
		 *  that it is a legal sjava code
		 */
		finally {
			// system exit using 0 value
			System.exit(0);
		}
	}

	/**
	 * Check args.
	 *
	 * @param args the args
	 * @throws InvalidFileException the invalid file exception
	 * @throws InvalidUsageException the invalid usage exception
	 */
	private static void checkArgs(String args[]) throws InvalidFileException, InvalidUsageException {
		// checks if the user supplied no source file or more than one source file 
		if (args.length != 1)
			// throw invalid usage exception
			throw new InvalidUsageException();
		// creates a new file object
		File file = new File(args[0]);
		// checks if the supplied path is a file
		if (!file.isFile())
			// throw invalid file exception
			throw new InvalidFileException();
	}
	
	/**
	 * Handles error in case of IOException
	 *
	 * @param message the error message
	 */
	private static void handleError(String message) {
		System.out.println(message);
		System.exit(2);
	}

}

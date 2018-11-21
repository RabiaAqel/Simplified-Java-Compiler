package oop.ex2.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 * The Class ReadFromFile.
 */
public class ReadFromFile {

	/** The file name. */
	private static String fileName;

	/**
	 * Instantiates a new read from file.
	 *
	 * @param fileName the file name
	 */
	public ReadFromFile(String fileName) {
		ReadFromFile.fileName = fileName;
	}

	/**
	 * Read file.
	 *
	 * @return the buffered reader
	 */
	public BufferedReader readFile() {

		BufferedReader bufferedReader = null;

		try {

			//Construct and returns the BufferedReader object
			return new BufferedReader(new FileReader(fileName));

			// catches file not found exception
		} catch (FileNotFoundException ex) {
			System.out.println("#ERROR FILE NOT FOUND#");
			System.exit(2);
		}

		return bufferedReader;
	}
}

package oop.ex2.filecompile;

// importes java.util.regex classes
import java.util.regex.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Naming.
 * @author rabeaaqel
 */
public class Naming implements Name {

	/** The name pattern. */
	protected Pattern pattern = Pattern.compile
			("((_[A-Za-z_0-9]*[A-Za-z]+[A-Za-z_0-9]*)" +
					"|([A-Za-z][A-Za-z_0-9]*))");
	
	/** The matcher. */
	protected Matcher matcher;
	
	/** The name. */
	protected String name;
	
	/**
	 * Instantiates a new naming object.
	 *
	 * @param name the name
	 */
	protected Naming(String name){
		this.name = name;
		matcher = pattern.matcher(name);
	}
	
	/*
	 * @see oop.ex2.filecompile.Name#isLegal()
	 */
	public boolean isLegal() {
		
		return matcher.matches();
	}

	/* 
	 * @see oop.ex2.filecompile.Name#isExist()
	 */
	public boolean isExist() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/* 
	 * @see oop.ex2.filecompile.Name#getName()
	 */
	public String getName(){
		return this.name;
	}

}

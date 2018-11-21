package oop.ex2.main;

// TODO: Auto-generated Javadoc
/**
 * The Class Variable.
 */
public class Variable {

	/** The is final. */
	private boolean isFinal;
	
	/** The is initialized. */
	private boolean isInitialized;
	
	/** The type. */
	private String type;
	
	/** The value. */
	private String value;

	/**
	 * Instantiates a new variable.
	 *
	 * @param isFinal the is final
	 * @param isInitialized the is initialized
	 * @param type the type
	 * @param value the value
	 */
	public Variable(boolean isFinal, boolean isInitialized, String type, String value) {
		this.isFinal = isFinal;
		this.isInitialized = isInitialized;
		this.type = type;
		this.value = value;
	}

	/**
	 * Checks if the variable final.
	 *
	 * @return true, if the variable final
	 */
	public boolean isFinal(){
		return this.isFinal;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Checks if the variable initialized.
	 *
	 * @return true case the variable initialized
	 */
	public boolean isInitialized() {
		return isInitialized;
	}

	/**
	 * Sets the isInitialized.
	 *
	 * @param isInitialized the new initialized
	 */
	public void setInitialized(boolean isInitialized) {
		this.isInitialized = isInitialized;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}
}

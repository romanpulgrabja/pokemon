package pokemon.data;

/**
 * @author paul
 *
 */
public class Pokemon {

	/**	 */
	private String name;
	/**	 */
	private Type type;
	/**	 */
	private Trainer trainer;
	/**	 */
	private int number;
	/**	 */
	private static int nextNumber;

	private boolean swapAllow = true;
	
	/**
	 * @param name
	 * @param type
	 */
	public Pokemon(String name, Type type) {
		this.name = name;
		this.type = type;
		this.number = nextNumber;
		nextNumber++;
	}

	/**	 */
	public String getName() {
		return name;
	}
	
	/**	 */
	public void setName(String name) {
		// this references the actual object instance
		this.name = name;
	}

	/**	 */
	public Type getType() {
		return type;
	}

	/**	 */
	public void setType(Type type) {
		this.type = type;
	}
	
	/**	 */
	public Trainer getTrainer() {
		return trainer;
	}

	/**	 */
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	/**	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * @return
	 */
	public boolean isSwapAllow() {
		return swapAllow;
	}

	/**
	 * @param swapAllow
	 */
	public void setSwapAllow(boolean swapAllow) {
		this.swapAllow = swapAllow;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Pokemon(" + getNumber() + ") '" + getName() + "' of type '" + getType() + "' has trainer '"
				+ getTrainer() + "'";
	}

	/**
	 * @param args
	 * 
	 */
	public static void main(final String[] args) {
		// geschenkt

	}

}
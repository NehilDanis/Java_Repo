public class ErrorHandling extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return String
				.format("The number of files have to be 3.There is an error of number of files.");
	}

}

class syntaxErrors extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return String
				.format("There is a syntax problem.Check your input files.");
	}

}

class syntaxArmy extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return String
				.format("There is no word that matched to the Leukocyte or Pathogen. ");
	}
}

class type extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return String
				.format("Be carefull.You tried to add a warrior to different type from its type. ");
	}
	
}

class noWord extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return String
				.format("The word that you want to use is not found.It isn't matched any word.");
	}
	
}

class numberOrNot extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return String
				.format("This element is for the number of warriors.So you cannot use letters for this element.");
	}
}

class wordOrNot extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return String
				.format("This element have to be word.You cannot use number for it.");
	}
}

class blankSpace extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return String
				.format("You cannot use blank space more than once after or before leukocyte or pathogen.");
	}
}

class emptyOrNot extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return String
				.format("ArmyinfoFile is empty.You cannot play the game in this situation.");
	}

}



public abstract class Pathogens extends MonoCelledLifeForm {
	private int turn=0;//This is for bacteria.

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	public static int counterP = 0;// This value holds the number of elements in
									// the pathogen arraylist.

}

public abstract class MonoCelledLifeForm {// This class is superclass of
	// leokocytes and pathoges.

	private double damage_for_one_turn=0;// This is for eosinophil.

	private boolean ok_not = true;// This is for special powers.

	public double getDamage_for_one_turn() {
		return damage_for_one_turn;
	}

	public void setDamage_for_one_turn(double damage_for_one_turn) {
		this.damage_for_one_turn = damage_for_one_turn;
	}

	public boolean getOk_not() {
		return ok_not;
	}

	public void setOk_not(boolean ok_not) {
		this.ok_not = ok_not;
	}

	private double hit_point;// This value holds the hit point of mono-celled
								// life
								// forms.
	private double cons_value;// This value holds the cons value of mono-celled
								// life forms.
	private double attack_point;// This value holds the attack point of
								// mono-celled
								// life forms.
	private int hit_number = 0;

	private String type;// This is for the type of arraylist element.

	// These are getters and setters for that private values.

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getHit_point() {
		return hit_point;
	}

	public int getHit_number() {
		return hit_number;
	}

	public void setHit_number(int hit_number) {
		this.hit_number = hit_number;
	}

	public void setHit_point(double hit_point) {
		this.hit_point = hit_point;
	}

	public double getCons_value() {
		return cons_value;
	}

	public void setCons_value(double cons_value) {
		this.cons_value = cons_value;
	}

	public double getAttack_point() {
		return attack_point;
	}

	public void setAttack_point(double attack_point) {
		this.attack_point = attack_point;
	}

	public abstract void specialPower(MonoCelledLifeForm element,
			MonoCelledLifeForm element1,Method method);

	public abstract void weaknesses(MonoCelledLifeForm element, double damage);
}

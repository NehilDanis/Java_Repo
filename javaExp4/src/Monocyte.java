public class Monocyte extends Leukocytes {
	private double hit_point;

	public Monocyte(int AP, int HP, int cons, String type) {
		this.setAttack_point(AP);
		this.setHit_point(HP);
		this.setCons_value(cons);
		this.setType(type);
	}

	public void specialPower(MonoCelledLifeForm element,
			MonoCelledLifeForm element1,Method method) {// element=monocyte
		double damage;
		double hit;
		double increased;
		if (element.getAttack_point() >= element1.getCons_value()) {
			damage = element.getAttack_point() - element1.getCons_value();
			hit=element1.getHit_point();
			hit =hit-damage;
			element1.setHit_point(hit);
			increased=element1.getDamage_for_one_turn();
			increased=increased+damage;
			element1.setDamage_for_one_turn(increased);
			element1.weaknesses(element1, damage);
		}
		
		
		if (element1.getType().equalsIgnoreCase("bacteria")) {
			this.hit_point = Constants.BACTERIA_HIT_POINTS / 5;
		} else if (element1.getType().equalsIgnoreCase("virus")) {
			this.hit_point = Constants.VIRUS_HIT_POINTS / 5;
		} else if (element1.getType().equalsIgnoreCase("microbe")) {
			this.hit_point = Constants.MICROBE_HIT_POINTS / 5;
		}
		if (element.getOk_not() == true) {
			if(element1.getHit_point()<this.hit_point){
				element1.setHit_point(0);
			}

		} else if (element.getOk_not() == false) {
			element.setOk_not(true);
		}

	}

	public void weaknesses(MonoCelledLifeForm element, double damage) {
		// There is no weaknesses.
	}
}

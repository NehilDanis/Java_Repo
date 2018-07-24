public class Neutrophil extends Leukocytes {
	private double hit_point;

	public Neutrophil(int AP, int HP, int cons, String type) {
		this.setAttack_point(AP);
		this.setHit_point(HP);
		this.setCons_value(cons);
		this.setType(type);
	}

	public void specialPower(MonoCelledLifeForm element,
			MonoCelledLifeForm element1,Method method) {// element=Neutrophil
		double damage;
		int hit_number;
		double hit;
		double increased;
		if (element.getAttack_point() >= element1.getCons_value()) {
			hit_number = element1.getHit_number();
			hit_number++;
			element1.setHit_number(hit_number);
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
			this.hit_point = Constants.BACTERIA_HIT_POINTS / 2;
		} else if (element1.getType().equalsIgnoreCase("virus")) {
			this.hit_point = Constants.VIRUS_HIT_POINTS / 2;
		} else if (element1.getType().equalsIgnoreCase("microbe")) {
			this.hit_point = Constants.MICROBE_HIT_POINTS / 2;
		}
		if (element1.getHit_point() < this.hit_point) {
				element1.setOk_not(false);//special power will be closed.
		}

	}

	public void weaknesses(MonoCelledLifeForm element, double damage) {
		double hit_point;
		double increased;
		hit_point = element.getHit_point();
		if (hit_point < (hit_point / 5)) {
			damage = (damage / 10);
			increased=element.getDamage_for_one_turn();
			increased=increased+damage;
			element.setDamage_for_one_turn(increased);
			hit_point = hit_point - damage;
			element.setHit_point(hit_point);
		} 

	}

}

public class Bacteria extends Pathogens {

	public Bacteria(int AP, int HP, int cons, String type) {
		this.setAttack_point(AP);
		this.setHit_point(HP);
		this.setCons_value(cons);
		this.setType(type);
	}

	public void specialPower(MonoCelledLifeForm element,
			MonoCelledLifeForm element1,Method method) {// element1=bacteria

		int hit_number;
		double damage;
		double increased;
		double hit;
		if (element1.getAttack_point() >= element.getCons_value()) {
			double temperature=method.body.getTemeperture();
			temperature=temperature+Constants.PATHOGEN_ATTACK_TEMPERATURE_INC;
			method.body.setTemeperture(temperature);
			hit_number = element.getHit_number();
			hit_number++;
			element.setHit_number(hit_number);
			hit = element.getHit_point();
			damage = element1.getAttack_point() - element.getCons_value();
			hit = hit - damage;
			element.setHit_point(hit);
			increased=element.getDamage_for_one_turn();
			increased=increased+damage;
			element.setDamage_for_one_turn(increased);
			
			element.weaknesses(element, damage);
		}

		if (element1.getOk_not() == true) {
			if (getTurn() == 0) {
				setTurn(1);
			} else {
				System.out.println(getTurn());
				setTurn(0);
				System.out.println(getTurn());
			}
		} else if (element1.getOk_not() == false) {
			element1.setOk_not(true);
		}

	}

	public void weaknesses(MonoCelledLifeForm element, double damage) {
		double hit;
		double increased;
		if (damage > 75) {
			damage = 20;
			increased=element.getDamage_for_one_turn();
			increased=increased+damage;
			element.setDamage_for_one_turn(increased);
			hit = element.getHit_point();
			hit = hit - damage;
			element.setHit_point(hit);
		}

	}
}

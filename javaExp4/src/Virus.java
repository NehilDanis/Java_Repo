public class Virus extends Pathogens {

	private int virus_hit_number = 0;
	private double damage;

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public int getVirus_hit_number() {
		return virus_hit_number;
	}

	public Virus(int virus_hit_number) {
		this.virus_hit_number = virus_hit_number;
	}

	public Virus(int AP, int HP, int cons, String type) {
		this.setAttack_point(AP);
		this.setHit_point(HP);
		this.setCons_value(cons);
		this.setType(type);
	}

	public void specialPower(MonoCelledLifeForm element,
			MonoCelledLifeForm element1,Method method) {// element1=virus
		int hit_number;
		double hit;
		double increased;
		if (element1.getOk_not() == true) {
			double cons_value;
			cons_value = element.getCons_value();
			cons_value = cons_value - (cons_value / 2);
			element.setCons_value(cons_value);

			if (element1.getAttack_point() >= element.getCons_value()) {
				method.body.setTemeperture(method.body.getTemeperture()+Constants.PATHOGEN_ATTACK_TEMPERATURE_INC);
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
		} else if (element1.getOk_not() == false) {
			if (element1.getAttack_point() >= element.getCons_value()) {
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
			element1.setOk_not(true);
		}

	}

	public void weaknesses(MonoCelledLifeForm element, double damage) {
		int hit = getHit_number() + 1;
		double hit_point;
		double increased;
		Virus.this.virus_hit_number = hit;
		if (getVirus_hit_number() >= 1) {
			damage = damage / 10;
			increased=element.getDamage_for_one_turn();
			increased=increased+damage;
			element.setDamage_for_one_turn(increased);
			hit_point = element.getHit_point();
			hit_point = hit_point - damage;
			element.setHit_point(hit_point);

		}

	}
}

public class Microbe extends Pathogens {
	private double hit_point;
	private double damage;

	public Microbe(int AP, int HP, int cons, String type) {
		this.setAttack_point(AP);
		this.setHit_point(HP);
		this.setCons_value(cons);
		this.setType(type);
	}
	
	public void specialPower(MonoCelledLifeForm element,
			MonoCelledLifeForm element1,Method method) {// element1=microbe
		double hit;
		int hit_number;
		double increased;
		if (element1.getAttack_point() >= element.getCons_value()) {
			method.body.setTemeperture(method.body.getTemeperture()+Constants.PATHOGEN_ATTACK_TEMPERATURE_INC);
			hit_number = element.getHit_number();
			hit_number++;
			element.setHit_number(hit_number);
			damage = element1.getAttack_point() - element.getCons_value();
			hit=element.getHit_point();
			hit =hit-damage;
			element.setHit_point(hit);
			increased=element.getDamage_for_one_turn();
			increased=increased+damage;
			element.setDamage_for_one_turn(increased);
			element.weaknesses(element, damage);
		}

		if (element.getType().equalsIgnoreCase("neutrophil")) {
			this.hit_point = Constants.NEUTROPHIL_HIT_POINTS / 2;
		} else if (element1.getType().equalsIgnoreCase("eosinophil")) {
			this.hit_point = Constants.EOSINOPHIL_HIT_POINTS / 2;
		} else if (element1.getType().equalsIgnoreCase("monocyte")) {
			this.hit_point = Constants.MONOCYTE_HIT_POINTS / 2;
		}
		if (element1.getOk_not() == true) {
			if(element.getHit_point()<this.hit_point && element.getHit_point()!=0){
				element.weaknesses(element, damage);//yanlis olabilir.
//				if (element1.getAttack_point() >= element.getCons_value()) {
//					damage = element1.getAttack_point() - element.getCons_value();
//					element.weaknesses(element, damage);
//				}buda dogru olabilir.
			}

		} else if (element1.getOk_not() == false) {
			element1.setOk_not(true);
		}

	}

	public void weaknesses(MonoCelledLifeForm element, double damage) {
		// There is no weaknesses.
	}

}

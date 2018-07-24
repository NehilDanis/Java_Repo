public class Eosinophil extends Leukocytes {

	public Eosinophil(int AP, int HP, int cons, String type) {
		this.setAttack_point(AP);
		this.setHit_point(HP);
		this.setCons_value(cons);
		this.setType(type);
	}

	public void specialPower(MonoCelledLifeForm element,MonoCelledLifeForm element1,Method method) {//element=eosinophil
		
		int hit_number;
		double damage;
		double increased;
		double hit;
		if(element.getAttack_point()>=element1.getCons_value()){
			hit_number = element1.getHit_number();
			hit_number++;
			element1.setHit_number(hit_number);
			hit = element1.getHit_point();
			damage = element.getAttack_point() - element1.getCons_value();
			hit = hit - damage;
			element1.setHit_point(hit);
			if(getTurn()==1){
				element.setAttack_point(element.getAttack_point()/2);
				setTurn(0);
			}
			increased=element1.getDamage_for_one_turn();
			increased=increased+damage;
			element1.setDamage_for_one_turn(increased);
			
			element.weaknesses(element1, damage);
		}
		if(element.getOk_not()==true){
			if (getTurn() == 0) {
				setTurn(1);
			}
			
		}
		else if(element.getOk_not()==false){
			element.setOk_not(true);
		}
		

	}

	public void weaknesses(MonoCelledLifeForm element, double damage) {
		double value;
		double hit_point;
		double increased;
		value=element.getDamage_for_one_turn();
		value=value-damage;
		if(value>100){
			damage=20;
			increased=element.getDamage_for_one_turn();
			increased=increased+damage;
			element.setDamage_for_one_turn(increased);
			hit_point=element.getHit_point();
			hit_point=hit_point-damage;
			element.setHit_point(damage);
			
			
		}
		

	}

}

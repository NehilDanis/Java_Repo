import java.util.ArrayList;
import java.util.List;


public class Method {

	Output output = new Output();
	Body body = new Body();

	public static List<Pathogens> pathogens = new ArrayList<Pathogens>();
	public static List<Leukocytes> leukocytes = new ArrayList<Leukocytes>();
	public static int counter = 0;// This holds the number of vitamin drugs.

	public void addCell(String element, int counter) {

		if (element.equalsIgnoreCase("Bacteria")) {
			for (int i = 0; i < counter; i++) {
				pathogens.add(new Bacteria(Constants.BACTERIA_ATTACK_POWER,
						Constants.BACTERIA_HIT_POINTS,
						Constants.BACTERIA_CONSTITUTION, "bacteria"));
				Pathogens.counterP++;
			}
		}

		else if (element.equalsIgnoreCase("Eosinophil")) {
			for (int i = 0; i < counter; i++) {
				leukocytes.add(new Eosinophil(
						Constants.EOSINOPHIL_ATTACK_POWER,
						Constants.EOSINOPHIL_HIT_POINTS,
						Constants.EOSINOPHIL_CONSTITUTION, "eosinophil"));
				Leukocytes.counterL++;
			}
		}

		else if (element.equalsIgnoreCase("Microbe")) {
			for (int i = 0; i < counter; i++) {
				pathogens.add(new Microbe(Constants.MICROBE_ATTACK_POWER,
						Constants.MICROBE_HIT_POINTS,
						Constants.MICROBE_CONSTITUTION, "microbe"));
				Pathogens.counterP++;
			}
		}

		else if (element.equalsIgnoreCase("Monocyte")) {
			for (int i = 0; i < counter; i++) {
				leukocytes.add(new Monocyte(Constants.MONOCYTE_ATTACK_POWER,
						Constants.MONOCYTE_HIT_POINTS,
						Constants.MONOCYTE_CONSTITUTION, "monocyte"));
				Leukocytes.counterL++;
			}
		}

		else if (element.equalsIgnoreCase("Neutrophil")) {
			for (int i = 0; i < counter; i++) {
				leukocytes.add(new Neutrophil(
						Constants.NEUTROPHIL_ATTACK_POWER,
						Constants.NEUTROPHIL_HIT_POINTS,
						Constants.NEUTROPHIL_CONSTITUTION, "neutrophil"));
				Leukocytes.counterL++;
			}
		}

		else if (element.equalsIgnoreCase("Virus")) {
			for (int i = 0; i < counter; i++) {
				pathogens.add(new Virus(Constants.VIRUS_ATTACK_POWER,
						Constants.VIRUS_HIT_POINTS,
						Constants.VIRUS_CONSTITUTION, "virus"));
				Pathogens.counterP++;
			}
		}
	}

	public void attack(String out, Method method) {
		for (int leu = 0, pat = 0; pat < pathogens.size(); pat++, leu++) {// Pathogens
																			// will
																			// attack
																			// in
																			// here.

			if (leukocytes.size() == 0) {
				 output.writeOutput(leukocytes, pathogens, out,method);
				break;
			}
			if (leukocytes.get(leu).getHit_number() == 9) {
				break;
			}

			else if (pathogens.size() > leukocytes.size()
					&& leukocytes.size() != 0) {// if the size of pathogens is
												// bigger than leukocytes,the
												// code will execute this part.

				pathogens.get(pat).specialPower(leukocytes.get(leu),
						pathogens.get(pat), method);

				if (leukocytes.get(leu).getHit_point() <= 0) {// if leukocyte
																// was died by
																// pathogen,this
																// part will be
																// execute.
					leukocytes.remove(leu);
					leu--;
					if (leu == -1) {
						leu = 0;
					}

					if (pathogens.get(pat).getType()
							.equalsIgnoreCase("bacteria")) {
						if (pathogens.get(pat).getTurn() == 1) {
							if (leukocytes.size() != 0) {
								pathogens.get(pat).specialPower(
										leukocytes.get(leu),
										pathogens.get(pat), method);
							}

						}
					}
				} else {// if leukocyte is alive,this part will be execute.
					if (pathogens.get(pat).getType()
							.equalsIgnoreCase("bacteria")) {
						pathogens.get(pat).setTurn(0);
					}
				}
				if (leu == leukocytes.size() - 1 || pat == pathogens.size() - 1) {// If
																					// the
																					// is
																					// arrive
																					// to
																					// the
																					// end
																					// of
																					// the
																					// leukocyte
																					// arraylist,this
																					// part
																					// will
																					// be
																					// execute.
					leu = -1;
				}

			} else if (pathogens.size() <= leukocytes.size()
					&& pathogens.size() != 0) {// if the size of leukocytes is
				// bigger than pathogens,the
				// code will execute this part.
				pathogens.get(pat).specialPower(leukocytes.get(leu),
						pathogens.get(pat), method);
				if (leukocytes.get(leu).getHit_point() <= 0) {// if leukocyte
																// was died by
																// pathogen,this
																// part will be
																// execute.
					leukocytes.remove(leu);
					leu--;
					if (leu == -1) {
						leu = 0;
					}
					if (pathogens.get(pat).getType()
							.equalsIgnoreCase("bacteria")) {
						if (pathogens.get(pat).getTurn() == 1) {
							if (leukocytes.size() != 0) {
								pathogens.get(pat).specialPower(
										leukocytes.get(leu),
										pathogens.get(pat), method);
							}

						}
					}
				} else {// if leukocyte is alive,this part will be execute.
					if (pathogens.get(pat).getType()
							.equalsIgnoreCase("bacteria")) {
						pathogens.get(pat).setTurn(0);
					}
				}
			}
		}

		for (int leu = 0, pat = 0; leu < leukocytes.size(); leu++, pat++) {// Leukocytes
																			// will
																			// attack
																			// in
																			// here.
			if (pathogens.size() == 0) {
				output.writeOutput(leukocytes, pathogens, out,method);
				break;
			}
			if (pathogens.get(pat).getHit_number() == 9) {
				break;
			}

			else if (leukocytes.size() > pathogens.size()
					&& pathogens.size() != 0) {// if the size of leukocytes is
												// bigger than pathogens,the
												// code will execute this part.

				leukocytes.get(leu).specialPower(leukocytes.get(leu),
						pathogens.get(pat), method);

				if (pathogens.get(pat).getHit_point() <= 0) {// if pathogen
																// was died by
																// leukocyte,this
																// part will be
																// execute.
					pathogens.remove(pat);
					pat--;
					if (pat == -1) {
						pat = 0;
					}

					if (leukocytes.get(leu).getType()
							.equalsIgnoreCase("eosinophil")) {
						if (leukocytes.get(leu).getTurn() == 1) {
							leukocytes.get(leu).setAttack_point(
									2 * leukocytes.get(leu).getAttack_point());

						}

					}
				}
				if (pat == pathogens.size() - 1 || leu == leukocytes.size() - 1) {// If
																					// the
																					// code
																					// is
																					// arrive
																					// to
																					// the
																					// end
																					// of
																					// the
																					// pathogens
																					// arraylist,this
																					// part
																					// will
																					// be
																					// execute.
					pat = -1;
				}

			} else if (pathogens.size() >= leukocytes.size()
					&& leukocytes.size() != 0) {// if the size of pathogens is
				// bigger than or equal to leukocytes,the
				// code will execute this part.
				leukocytes.get(leu).specialPower(leukocytes.get(leu),
						pathogens.get(pat), method);

				if (pathogens.get(pat).getHit_point() <= 0) {// if pathogen
																// was died by
																// leukocyte,this
																// part will be
																// execute.
					pathogens.remove(pat);
					pat--;
					if (pat == -1) {
						pat = 0;
					}
					if (leukocytes.get(leu).getType()
							.equalsIgnoreCase("eosinophil")) {
						if (leukocytes.get(leu).getTurn() == 1) {
							leukocytes.get(leu).setAttack_point(
									2 * leukocytes.get(leu).getAttack_point());

						}

					}
				}
			}

		}

	}

	public void useDrug(String element, String out, Method method) {
		if (element.equalsIgnoreCase("vitamin")) {
			if (counter == 0) {
				double pulse = body.getPulse();
				pulse = pulse + 20;
				body.setPulse(pulse);
				if (pulse > Constants.BODY_MAX_PULSE
						|| pulse < Constants.BODY_START_PULSE) {
					output.writeOutput(leukocytes, pathogens, out, method);
				}
				for (int i = 0; i < leukocytes.size(); i++) {
					if (leukocytes.get(i).getType()
							.equalsIgnoreCase("monocyte")) {
						double initialIncreasedHP = leukocytes.get(i)
								.getHit_point();
						initialIncreasedHP = initialIncreasedHP
								+ (initialIncreasedHP / 2);
						if (initialIncreasedHP > Constants.MONOCYTE_HIT_POINTS) {
							initialIncreasedHP = Constants.MONOCYTE_HIT_POINTS;
						}
						leukocytes.get(i).setHit_point(initialIncreasedHP);

					} else if (leukocytes.get(i).getType()
							.equalsIgnoreCase("eosinophil")) {
						double initialIncreasedHP = leukocytes.get(i)
								.getHit_point();
						initialIncreasedHP = initialIncreasedHP
								+ (initialIncreasedHP / 2);
						if (initialIncreasedHP > Constants.EOSINOPHIL_HIT_POINTS) {
							initialIncreasedHP = Constants.EOSINOPHIL_HIT_POINTS;
						}
						leukocytes.get(i).setHit_point(initialIncreasedHP);

					} else if (leukocytes.get(i).getType()
							.equalsIgnoreCase("neutrophil")) {
						double initialIncreasedHP = leukocytes.get(i)
								.getHit_point();
						initialIncreasedHP = initialIncreasedHP
								+ (initialIncreasedHP / 2);
						if (initialIncreasedHP > Constants.NEUTROPHIL_HIT_POINTS) {
							initialIncreasedHP = Constants.NEUTROPHIL_HIT_POINTS;
						}
						leukocytes.get(i).setHit_point(initialIncreasedHP);

					}

				}
			}
			counter++;
		}

		else if (element.equalsIgnoreCase("anti-biotic")) {

			double pulse = body.getPulse();
			pulse = pulse + 10;
			body.setPulse(pulse);
			if (pulse > Constants.BODY_MAX_PULSE
					|| pulse < Constants.BODY_START_PULSE) {
				output.writeOutput(leukocytes, pathogens, out, method);
			}

			for (int i = 0; i < pathogens.size(); i++) {
				if (pathogens.get(i).getType().equalsIgnoreCase("bacteria")) {
					double HP = pathogens.get(i).getHit_point();
					HP = HP - 250;
					pathogens.get(i).setHit_point(HP);
				}
			}
		}

		else if (element.equalsIgnoreCase("anti-viral")) {

			double pulse = body.getPulse();
			pulse = pulse + 10;
			body.setPulse(pulse);
			if (pulse > Constants.BODY_MAX_PULSE
					|| pulse < Constants.BODY_START_PULSE) {
				output.writeOutput(leukocytes, pathogens, out, method);
			}

			for (int i = 0; i < pathogens.size(); i++) {
				if (pathogens.get(i).getType().equalsIgnoreCase("virus")) {
					double HP = pathogens.get(i).getHit_point();
					HP = HP - 400;
					pathogens.get(i).setHit_point(HP);
				}
			}

		}

		else if (element.equalsIgnoreCase("aspirin")) {

			double pulse = body.getPulse();
			pulse = pulse + 10;
			body.setPulse(pulse);
			if (pulse > Constants.BODY_MAX_PULSE
					|| pulse < Constants.BODY_START_PULSE) {
				output.writeOutput(leukocytes, pathogens, out, method);
			}

			double temperture = body.getTemeperture();
			temperture = temperture - 1.5;
			body.setTemeperture(temperture);

			for (int i = 0; i < leukocytes.size(); i++) {
				if (leukocytes.get(i).getType().equalsIgnoreCase("monocyte")) {
					double initialIncreasedHP = leukocytes.get(i)
							.getHit_point();
					initialIncreasedHP = initialIncreasedHP
							+ (initialIncreasedHP / 10);
					if (initialIncreasedHP > Constants.MONOCYTE_HIT_POINTS) {
						initialIncreasedHP = Constants.MONOCYTE_HIT_POINTS;
					}
					leukocytes.get(i).setHit_point(initialIncreasedHP);

				} else if (leukocytes.get(i).getType()
						.equalsIgnoreCase("eosinophil")) {
					double initialIncreasedHP = leukocytes.get(i)
							.getHit_point();
					initialIncreasedHP = initialIncreasedHP
							+ (initialIncreasedHP / 10);
					if (initialIncreasedHP > Constants.EOSINOPHIL_HIT_POINTS) {
						initialIncreasedHP = Constants.EOSINOPHIL_HIT_POINTS;
					}
					leukocytes.get(i).setHit_point(initialIncreasedHP);

				} else if (leukocytes.get(i).getType()
						.equalsIgnoreCase("neutrophil")) {
					double initialIncreasedHP = leukocytes.get(i)
							.getHit_point();
					initialIncreasedHP = initialIncreasedHP
							+ (initialIncreasedHP / 10);
					if (initialIncreasedHP > Constants.NEUTROPHIL_HIT_POINTS) {
						initialIncreasedHP = Constants.NEUTROPHIL_HIT_POINTS;
					}
					leukocytes.get(i).setHit_point(initialIncreasedHP);

				}

			}

		}

	}

	public void syntaxArmy(String arrayElement) throws syntaxArmy, wordOrNot,
			blankSpace {
		int counterWordOrNot = 0;// If any of them is a number,this counter will
									// be increased.
		int counterSyntaxArmy = 0;// If the code find the same element with
		// arrayElement,counter will be increased.
		String[] element = { "LEUKOCYTES", "PATHOGENS" };// We
															// can
															// just
															// use
															// this
															// words
															// in
															// the
															// input
															// file.

		char[] array = arrayElement.toCharArray();
		char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j] == numbers[i]) {
					counterWordOrNot++;
				}
			}
		}

		try {
			if (counterWordOrNot != 0) {
				throw new wordOrNot();
			} else {
				for (int i = 0; i < element.length; i++) {
					if (arrayElement.equals(element[i])) {
						counterSyntaxArmy++;
					}
				}
				try {
					if (arrayElement.equals("")) {
						throw new blankSpace();
					}
				} catch (blankSpace error) {
					System.out.println(error.toString());
					System.exit(0);
				}
				try {
					if (counterSyntaxArmy == 0) {
						throw new syntaxArmy();
					}

				} catch (syntaxArmy error) {
					System.out.println(error.toString());
					System.exit(0);
				}
			}

		} catch (wordOrNot error) {
			System.out.println(error.toString());
			System.exit(0);
		}

	}

	public void type(String[] array, String type) throws numberOrNot, noWord,
			type {
		int counterPathogen = 0;
		int counterLeukocyte = 0;
		int Leukocytes = 0;
		int Pathogens = 0;
		int counterNumberOrNot = 0;
		char[] array1 = array[1].toCharArray();
		char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		String[] Pathogen = { "VIRUS", "BACTERIA", "MICROBE" };
		String[] Leukocyte = { "MONOCYTE", "NEUTROPHIL", "EOSINOPHIL" };

		if (type.equals("LEUKOCYTES")) {
			for (int i = 0; i < Pathogen.length; i++) {
				if (array[0].equals(Pathogen[i])) {
					counterLeukocyte++;
				}
			}
			try {
				if (counterLeukocyte != 0) {
					throw new type();
				} else {
					for (int i = 0; i < Leukocyte.length; i++) {
						if (array[0].equals(Leukocyte[i])) {
							Leukocytes++;
						}
					}
					try {
						if (Leukocytes == 0) {
							throw new noWord();
						}
					} catch (noWord error) {
						System.out.println(error.toString());
						System.exit(0);
					}

				}
			} catch (type error) {
				System.out.println(error.toString());
				System.exit(0);
			}

			for (int i = 0; i < numbers.length; i++) {
				for (int j = 0; j < array1.length; j++) {
					if (array1[j] == numbers[i]) {
						counterNumberOrNot++;
					}
				}
			}
			try {
				if (counterNumberOrNot != array1.length) {
					throw new numberOrNot();
				}
			} catch (numberOrNot error) {
				System.out.println(error.toString());
				System.exit(0);
			}

		} else if (type.equals("PATHOGENS")) {
			for (int i = 0; i < Leukocyte.length; i++) {
				if (array[0].equals(Leukocyte[i])) {
					counterPathogen++;
				}
			}
			try {
				if (counterPathogen != 0) {
					throw new type();
				} else {
					for (int i = 0; i < Pathogen.length; i++) {
						if (array[0].equals(Pathogen[i])) {
							Pathogens++;
						}
					}
					try {
						if (Pathogens == 0) {
							throw new noWord();
						}
					} catch (noWord error) {
						System.out.println(error.toString());
						System.exit(0);
					}

				}
			} catch (type error) {
				System.out.println(error.toString());
				System.exit(0);
			}

			for (int i = 0; i < numbers.length; i++) {
				for (int j = 0; j < array1.length; j++) {
					if (array1[j] == numbers[i]) {
						counterNumberOrNot++;
					}
				}
			}
			try {
				if (counterNumberOrNot != array1.length) {
					throw new numberOrNot();
				}
			} catch (numberOrNot error) {
				System.out.println(error.toString());
				System.exit(0);
			}

		}

	}

	public int control(char[] array, char[] numbers) {
		int counter = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j] == numbers[i]) {
					counter++;
					break;
				}
			}
		}
		if (counter == 0) {
			return 0;
		} else {
			return 1;
		}

	}

	public void syntaxCommand(String[] arrayElement) {
		int counterSyntaxCommand0 = 0;// If the code find the same element with
		// arrayElement,counter will be increased.
		char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		if (arrayElement.length == 5) {
			char[] array0 = arrayElement[0].toCharArray();
			int a0 = control(array0, numbers);
			char[] array1 = arrayElement[1].toCharArray();
			int a1 = control(array1, numbers);
			char[] array2 = arrayElement[2].toCharArray();
			int a2 = control(array2, numbers);
			char[] array3 = arrayElement[3].toCharArray();
			int a3 = control(array3, numbers);
			try {
				if (a0 == 1 || a1 == 1 || a2 == 1 || a3 == 1) {
					throw new wordOrNot();
				}

				else {
					if (arrayElement[2].equals("TO")) {
						counterSyntaxCommand0++;
					}

					try {
						if (!arrayElement[0].equals("ADD")) {
							throw new noWord();
						}
						if (counterSyntaxCommand0 == 0) {
							throw new noWord();
						} else {
							counterSyntaxCommand0 = 0;
						}
					} catch (noWord error) {
						System.out.println(error.toString());
						System.exit(0);
					}

				}
			} catch (wordOrNot error) {
				System.out.println(error.toString());
				System.exit(0);
			}
		}// if

		else if (arrayElement.length == 2) {
			char[] array0 = arrayElement[0].toCharArray();
			int a0 = control(array0, numbers);
			char[] array1 = arrayElement[1].toCharArray();
			int a1 = control(array1, numbers);
			try {
				if (a0 == 1 || a1 == 1) {
					throw new wordOrNot();
				}
				try {
					if (!arrayElement[0].equals("USE")) {
						throw new noWord();
					}
				} catch (noWord error) {
					System.out.println(error.toString());
					System.exit(0);
				}

			} catch (wordOrNot error) {
				System.out.println(error.toString());
				System.exit(0);

			}

		}// else if

		else if (arrayElement.length == 1) {
			char[] array0 = arrayElement[0].toCharArray();
			int a0 = control(array0, numbers);
			try {
				if (a0 == 1) {
					throw new wordOrNot();
				}
				try {
					if (!arrayElement[0].equals("REPORT")) {
						throw new noWord();
					}
				} catch (noWord error) {
					System.out.println(error.toString());
					System.exit(0);
				}

			} catch (wordOrNot error) {
				System.out.println(error.toString());
				System.exit(0);

			}

		}// else if

	}// syntaxCommand end

	public void addCommandSyntax(String element, String type, String counter) {
		int counterType = 0;// for type
		int counterE = 0;// for element
		int counterNumber=0;//for counter
		char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		String[] types = { "LEUKOCYTES", "PATHOGENS" };// We can just use this
														// words in the
														// input file.
		String[] Pathogen = { "VIRUS", "BACTERIA", "MICROBE" };
		String[] Leukocyte = { "MONOCYTE", "NEUTROPHIL", "EOSINOPHIL" };
		char[] counterElement = counter.toCharArray();//This is our counter in char array type.
		for (int i = 0; i < types.length; i++) {
			if (types[i].equals(type)) {
				counterType++;
			}
		}

		try {
			if (counterType == 0) {
				throw new noWord();
			} else {
				if (type.equals("LEUKOCYTES")) {
					for (int i = 0; i < Leukocyte.length; i++) {
						if (Leukocyte[i].equals(element)) {
							counterE++;
						}
					}
					try {
						if (counterE == 0) {
							throw new type();
						}

					} catch (type error) {
						System.out.println(error.toString());
						System.exit(0);
					}

				} else if (type.equals("PATHOGENS")) {
					for (int i = 0; i < Pathogen.length; i++) {
						if (Pathogen[i].equals(element)) {
							counterE++;
						}
					}
					try {
						if (counterE == 0) {
							throw new type();
						}

					} catch (type error) {
						System.out.println(error.toString());
						System.exit(0);
					}

				}

			}

		} catch (noWord error) {
			System.out.println(error.toString());
			System.exit(0);
		}
		
		for(int i=0;i<numbers.length;i++){
			for(int j=0;j<counterElement.length;j++){
				if(numbers[i]==counterElement[j]){
					counterNumber++;
				}
			}
		}
		try{
			if(counterNumber!=counterElement.length){
				throw new numberOrNot();
			}
			
		}
		catch(numberOrNot error){
			System.out.println(error.toString());
			System.exit(0);
		}

	}

	public void useCommandSyntax(String element) {
		int drugCounter=0;
		String [] drugs={"VITAMIN","ASPIRIN","ANTI-BIOTIC","ANTI-VIRAL"};
		for(int i=0;i<drugs.length;i++){
			if(drugs[i].equals(element)){
				drugCounter++;
			}
		}
		try{
			if(drugCounter==0){
				throw new noWord();
			}
		}
		catch(noWord error){
			System.out.println(error.toString());
			System.exit(0);
		}
	}

}// class method


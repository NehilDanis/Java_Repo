import java.io.*;
import java.util.Scanner;

public class Input {
	Method method = new Method();
	Output output = new Output();
	Virus virus;
	Eosinophil eosinophil;


	public void readArmyInfoFile(String armyInfo, String commands, String out)
			throws syntaxErrors, syntaxArmy, type, numberOrNot, noWord,
			wordOrNot, blankSpace {
		File armyFile = new File(armyInfo);// All warriors of armies will given
											// us in this file.
		String read = null;

		try {
			String[] splittedArray = new String[5];
			Scanner sArmy = new Scanner(armyFile);
			while (sArmy.hasNextLine()) {
				read = sArmy.nextLine();
				splittedArray = read.split(" ");
				if (read.equals("---------------")) {
					continue;
				} else if (splittedArray.length == 1) {
					method.syntaxArmy(splittedArray[0]);
					if (splittedArray[0].equals("LEUKOCYTES")) {
						while (sArmy.hasNextLine()) {
							read = sArmy.nextLine();
							if (read.equals("---------------")) {
								continue;
							} else if (read.equals("")) {
								break;
							} else {
								splittedArray = read.split(" ");
								method.type(splittedArray, "LEUKOCYTES");
								int counter = Integer
										.parseInt(splittedArray[1]);
								method.addCell(splittedArray[0], counter);

							}

						}
					} else if (splittedArray[0].equals("PATHOGENS")) {
						while (sArmy.hasNextLine()) {
							read = sArmy.nextLine();
							if (read.equals("---------------")) {
								continue;
							} else if (read.equals("")) {
								break;
							} else {
								splittedArray = read.split(" ");
								method.type(splittedArray, "PATHOGENS");
								int counter = Integer
										.parseInt(splittedArray[1]);
								method.addCell(splittedArray[0], counter);

							}

						}
					}

				}
			}

			for (int i = 0; i < 5; i++) {// 5 turns equals 1 set.So the code
				// will invoke the attack metod
				// 5 times in 1 set.
				method.attack(out,method);
				virus = new Virus(0);
				if (Method.leukocytes.size() != 0) {
					for (int leu = 0; leu < Method.leukocytes.size(); leu++) {
						Method.leukocytes.get(leu).setHit_number(0);
						Method.leukocytes.get(leu).setDamage_for_one_turn(0);
					}
				}
				if (Method.pathogens.size() != 0) {
					for (int pat = 0; pat < Method.pathogens.size(); pat++) {
						Method.pathogens.get(pat).setHit_number(0);
						Method.pathogens.get(pat).setDamage_for_one_turn(0);
					}
				}
				if(Method.pathogens.size() == 0 || Method.leukocytes.size() == 0){
					output.writeOutput(Method.leukocytes, Method.pathogens, out,method);
				}
				else if(method.body.getTemeperture()>Constants.BODY_MAX_TEMPERATURE){
					output.writeOutput(Method.leukocytes, Method.pathogens, out,method);
				}
			}
			commandsFile(commands, out);// After copmleting 5 turns I mean 1
			// set,the code reads the commands
			// file.
			sArmy.close();

		} catch (FileNotFoundException error) {// Possible errors will catch
												// here.
			System.out.println(error.getStackTrace());
		}
	}

	public void commandsFile(String commands, String out) {
		File commandFile = new File(commands);// All commands that the code have
												// to execute will given us in
												// this file.
		String read = null;
		try {

			Scanner sCommand = new Scanner(commandFile);
			String[] splittedArray = new String[10];
			while (sCommand.hasNextLine()) {
				read = sCommand.nextLine();
				if (read.equals("")) {
					for (int i = 0; i < 5; i++) {// 5 turns equals 1 set.So the
													// code
						// will invoke the attack metod
						// 5 times in 1 set.
						method.attack(out,method);
						virus = new Virus(0);
						if (Method.leukocytes.size() != 0) {
							for (int leu = 0; leu < Method.leukocytes.size(); leu++) {
								Method.leukocytes.get(leu).setHit_number(0);
								Method.leukocytes.get(leu)
										.setDamage_for_one_turn(0);
							}
						}
						if (Method.pathogens.size() != 0) {
							for (int pat = 0; pat < Method.pathogens.size(); pat++) {
								Method.pathogens.get(pat).setHit_number(0);
								Method.pathogens.get(pat)
										.setDamage_for_one_turn(0);
							}
						}
						if(Method.pathogens.size() == 0 || Method.leukocytes.size() == 0){
							output.writeOutput(Method.leukocytes, Method.pathogens, out,method);
						}
						else if(method.body.getTemeperture()>Constants.BODY_MAX_TEMPERATURE){
							output.writeOutput(Method.leukocytes, Method.pathogens, out,method);
						}
					}
					Method.counter = 0;// This is for number of using vitamins.
				} else {
					splittedArray = read.split(" ");
					method.syntaxCommand(splittedArray);
					if (splittedArray[0].equals("ADD")) {
						method.addCommandSyntax(splittedArray[1],splittedArray[3],splittedArray[4]);
						int counter = Integer.parseInt(splittedArray[4]);
						method.addCell(splittedArray[1], counter);

					} else if (splittedArray[0].equals("USE")) {
						method.useCommandSyntax(splittedArray[1]);
						method.useDrug(splittedArray[1], out,method);
					} else if (splittedArray[0].equals("REPORT")) {
						output.writeOutput(Method.leukocytes, Method.pathogens,
								out,method);

					}
				}

			}
			sCommand.close();
			while (true) {
				method.attack(out,method);
				virus = new Virus(0);
				if (Method.leukocytes.size() != 0) {
					for (int leu = 0; leu < Method.leukocytes.size(); leu++) {
						Method.leukocytes.get(leu).setHit_number(0);
						Method.leukocytes.get(leu)
								.setDamage_for_one_turn(0);
					}
				}
				if (Method.pathogens.size() != 0) {
					for (int pat = 0; pat < Method.pathogens.size(); pat++) {
						Method.pathogens.get(pat).setHit_number(0);
						Method.pathogens.get(pat)
								.setDamage_for_one_turn(0);
					}
				}
				if(Method.pathogens.size() == 0 || Method.leukocytes.size() == 0){
					output.writeOutput(Method.leukocytes, Method.pathogens, out,method);
				}
				else if(method.body.getTemeperture()>Constants.BODY_MAX_TEMPERATURE){
					output.writeOutput(Method.leukocytes, Method.pathogens, out,method);
				}
					
			}

		} catch (FileNotFoundException error) {// Possible errors will catch
												// here.
			System.out.println(error.getStackTrace());
		}

	}

}

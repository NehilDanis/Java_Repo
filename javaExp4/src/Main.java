
public class Main {

	public static void main(String[] args) throws ErrorHandling, syntaxErrors,syntaxArmy,type,numberOrNot,noWord,wordOrNot,blankSpace{
		Input in = new Input();

		try {
			if (args.length < 3 || args.length > 3) {// This part will control
														// the number of files.
				throw new ErrorHandling();
			}

			else {// If there is no problem,readInputFile will invoke.
				try{
					if(args[0].isEmpty()){
						throw new emptyOrNot();
					}
					else {
						in.readArmyInfoFile(args[0], args[1],args[2]);
					}
					
				}
				catch(emptyOrNot error){
					System.out.println(error.toString());
					System.exit(0);
				}
			}

		} catch (ErrorHandling error) {// If the number of files are more or
										// less than the number is expected,this
										// part will catch the error.
			System.out.println(error.toString());
		}

	}

}

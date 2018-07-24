import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Output {
	public void writeOutput(List leukocyte,List pathogen,String output,Method method) {

		try {
			File fOut = new File(output);
			FileWriter writer = new FileWriter(fOut, true);
			BufferedWriter write = new BufferedWriter(writer);
			write.write("Leukocyte : " + System.lineSeparator());
			write.newLine();
			for (int i = 0; i < Method.leukocytes.size(); i++) {
				write.write(Method.leukocytes.get(i).getType() + "\t"
						+ "Remaining HP : "
						+ Method.leukocytes.get(i).getHit_point()
						+ System.lineSeparator());
			}
			write.newLine();
			write.write("Pathogens : " + System.lineSeparator());
			for (int i = 0; i < Method.pathogens.size(); i++) {
				write.write(Method.pathogens.get(i).getType() + "\t"
						+ "Remaining HP : "
						+ Method.pathogens.get(i).getHit_point()
						+ System.lineSeparator());
			}
			write.newLine();
			write.write("Body : " + System.lineSeparator());
			write.write("Temperture : " +method.body.getTemeperture()
					+ System.lineSeparator());
			write.write("Pulse : " + method.body.getPulse() + System.lineSeparator());
			write.write("----------------------------------------------------------------");
			write.newLine();
			write.newLine();
			if (method.body.getTemeperture() > Constants.BODY_MAX_TEMPERATURE
					|| method.body.getTemeperture() < Constants.BODY_START_TEMPERATURE) {
					
				write.write("Pathogens win!");
				System.exit(0);
			}
			else if(Method.pathogens.size()==0){
				write.write("Leukocytes win!");
				write.close();
				System.exit(0);
			}
			else if(Method.leukocytes.size()==0){
				write.write("Pathogens win!");
				write.close();
				System.exit(0);
			}
			write.close();

		} catch (Exception error) {
			System.out.println("ErrorWriteFile: " + error.getMessage());
		}

	}

}

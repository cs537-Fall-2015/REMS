package REMS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

	public static void main(String[] args) throws IOException {
		
		List<String> listOfCommands = new ArrayList<String>();
		for (String line : Files.readAllLines(Paths.get("P:/CS_537/REMS_Workspace/REMS/Commands.txt"))) {
		    for (String part : line.split("\\d+")) {
		        listOfCommands.add(part);
		    }
		}
		
		for (String list: listOfCommands) {
			System.out.println(list);
		}
		
		
		File file = new File("P:/CS_537/REMS_Workspace/REMS/Result.txt");
		
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		for (String list: listOfCommands) {
			bw.write(list + "\n");
		}
		
		bw.close();

		System.out.println("Done");

	}

}

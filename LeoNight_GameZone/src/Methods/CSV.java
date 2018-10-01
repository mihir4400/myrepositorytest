package Methods;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {
	//This method will read and returnt the data from CSV file.
	public static List<String[]> get(String filename) {
		List<String[]> data = new ArrayList<String[]>();
		String testRow;
		try {
			//open and read the file
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			//Read data as long as it's not empty
			//parse the data by comma using .split() method	
			//place in to a temporary array then add it to the list
			while ((testRow = br.readLine()) != null) {
				String[] line = testRow.split(",");
				data.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found" + filename);
		} catch (IOException e) {
			System.out.println("Error: Could not read" + filename);
		}
		return data;
	}	
}
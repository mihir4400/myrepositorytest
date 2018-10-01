package leonight;

import java.util.List;

public class dataReaders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//readCSV();
		readXLS();
	}
	public static void readCSV() {
		String filename = "C:\\\\Users\\\\Miiiii\\\\Desktop\\\\selenium\\\\UserAccounts.csv";
		List <String[]> records = Methods.CSV.get(filename);
		//Iterating through the list
		for (String[] record : records) {
			for(String field : record) {
				System.out.println(field);
			}
		}
	}
	public static void readXLS() {
		String filename = "C:\\Users\\Miiiii\\Desktop\\selenium\\UserLogin.xls";
		String[][] data = Methods.Excel.get(filename);
		for (String[] record : data) {
				System.out.println("\nNew RECORD");
				System.out.println(record[0]);
				System.out.println(record[1]);
				System.out.println(record[2]);
		}
	}
}


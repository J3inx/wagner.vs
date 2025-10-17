package readingFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class commaSplitValueReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String csvFile = "Lottery_Powerball.csv";
		String line;
		String csvSplitBy = ",";
		try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
			System.out.println("file found");
			ArrayList <String> records = new ArrayList<>();
			while((line = br.readLine())!=null) {
				String [] values = line.split(csvSplitBy);
				ArrayList <String> record = new ArrayList<>();
				for(String value: values) {
					record.add(value.trim());
				}
				records.addAll(record);
			}
			for(String r: records) {
				System.out.println(r);
			}
		}
		catch(IOException e) {
			System.out.println("file not found");
		}
	}

}

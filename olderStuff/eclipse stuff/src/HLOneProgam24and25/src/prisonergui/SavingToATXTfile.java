package prisonergui;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;

public class SavingToATXTfile {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("who are you taking to homecoming?");
		String person = kb.next();
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream("dates2024.txt",true));
			//the true allows it to "append" or to add to something after the last added value
			
		}
		catch(FileNotFoundException e) {
			System.out.println("Error: file not found");
			System.exit(0);
		}
		outputStream.println("your dates' name is: ");
		outputStream.println(person);
		//have to close a stream, printer, or a scanner after opening it
		outputStream.close();
		kb.close();
		System.out.println("we have written to a file");
	}

}

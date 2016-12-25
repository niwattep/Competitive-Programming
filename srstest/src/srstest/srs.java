package srstest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class srs {
	final static int numCol = 50;
	final static int numRow = 50;
	
	static ArrayList<String[]> table;
	
	static Scanner s = null;
	
	static String dm;
	
	static int[][] rtable = new int[numRow + 2][numCol + 2];

	public static void main(String[] args) {
		loadTable();
		s = new Scanner(System.in);
		System.out.print("Enter delimeter(',', ':', 't', 's', '_', '-'): ");
		dm = s.next();
		readTable(args[0], dm);
		
	}
	
	static void loadTable() {
		try {
			s = new Scanner(new FileReader("table.txt"));
			
			for (int i = 1; i <= 50; i++) {
				for (int j = 1; j <= 50; j++) {
					rtable[i][j] = s.nextInt();
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Random table not found");
			System.exit(0);
			
		}
		s.close();
	}

	static void readTable(String path, String d) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null) {
				table.add(line.split(d));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Error reading input from " + path);
			System.exit(0);
		}
		
		
	}
}

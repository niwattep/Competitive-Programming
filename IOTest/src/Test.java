import java.util.Set;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> lastnames = new ArrayList<String>();
		ArrayList<Integer> salaries = new ArrayList<Integer>();
		ArrayList<Boolean> goodOrBad = new ArrayList<Boolean>();
		
		//FileReader fr = new FileReader("test.txt");
		//BufferedReader br = new BufferedReader(fr);
		BufferedReader br = new BufferedReader(new FileReader("test.txt")); 
		
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] columns = line.split("\t");
			names.add(columns[0]);
			lastnames.add(columns[1]);
			salaries.add(Integer.parseInt(columns[2]));
			goodOrBad.add(Boolean.parseBoolean(columns[3]));
		}
		br.close();
		
		System.out.println(names);
		System.out.println(lastnames);
		System.out.println(salaries);
		System.out.println(goodOrBad);
		
		FileWriter fwr = new FileWriter("test2.txt");
		PrintWriter pwr = new PrintWriter(fwr);
		BufferedWriter bwr = new BufferedWriter(pwr);
		
		for (int i = 0; i < 1001; i++) {
			bwr.write("die!!!\n");
		}
		bwr.close();
		
		FileOutputStream fos = new FileOutputStream("test3.txt");
		PrintStream ps = new PrintStream(fos);
		
		for (int i = 0; i < 1001; i++) {
			ps.println("die!!!");
		}
		ps.close();
		
		Object[] namesA = names.toArray();
		Object[] lastnamesA = lastnames.toArray();
		Object[] salariesA = salaries.toArray();
		Employee em = new Employee((String)namesA[0], (String)lastnamesA[0], (int)salariesA[0]);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Employee.em"));
		oos.writeObject(em);
		oos.close();
		
		
	}

}

class Employee implements Serializable {
	private String name;
	private String lastname;
	private int salary;
	
	public Employee(String name, String lastname, int salary) {
		 this.name = name;
		 this.lastname = lastname;
		 this.salary = salary;
	}
}

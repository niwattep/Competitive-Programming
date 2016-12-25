import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class RemoveSpace {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		BufferedReader br = new BufferedReader(new FileReader("raw.txt")); 
		String line = null;
		String string = "";
		while ((line = br.readLine()) != null) {
			string += line;
		}
		string = string.replaceAll("\\B", " ");
		br.close();
		FileOutputStream fos = new FileOutputStream("withspace.txt");
		PrintStream ps = new PrintStream(fos);
		ps.println(string);
		ps.close();
	}

}

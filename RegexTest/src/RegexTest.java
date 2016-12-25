import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("a.*string");
		Matcher matcher = pattern.matcher("a string");

		System.out.println(matcher.matches());
		System.out.println(matcher.find());
		
		Pattern pattern2 = Pattern.compile("a.*string");
		Matcher matcher2 = pattern2.matcher("Here is a string with more than just the pattern.");

		System.out.println(matcher2.matches());
		System.out.println(matcher2.find());

		String input = "Here is a WikiWord followed by AnotherWikiWord, then SomeWikiWord.";
		Pattern pattern3 = Pattern.compile("[A-Z][a-z]*([A-Z][a-z]*)+");
		Matcher matcher3 = pattern3.matcher(input);

		while (matcher3.find()) {
			System.out.println("Found this wiki word: " + matcher3.group(0));
		}



	}



}

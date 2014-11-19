package regEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class runRegEx {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//Scanner sc1 = new Scanner(System.in);

		while (true) {

			System.out.println("Bitte einen regulären Ausdruck eingeben: ");

			String eingabePattern = sc.nextLine();
			Pattern p = null;
			boolean found = false;

			try {
				p = Pattern.compile(eingabePattern);
			} catch (PatternSyntaxException e) {
				System.err.println("Syntaxfehler im Ausdruck: " + e.getMessage());
			}

			System.out
					.println("Bitte Text eingeben, der durchsucht werden soll: ");
			String eingabeMatcher = sc.nextLine();

			Matcher m = p.matcher(eingabeMatcher);

			while (m.find()) {
				found = true;
				System.out.println("Treffer " + '"' + m.group() + '"'
						+ " zwischen " + m.start() + " und " + m.end());

			}
			
			if (!found){
				
				System.out.println("Keine Treffer");
			}

			System.out.println();

		}
		
		

	}

}

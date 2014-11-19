package umwandeln;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Umwandeln {

	public String transliterate(String filename) {

		HashMap<String, String> hm = new HashMap<String, String>();
		String eineZeile;

		hm.put("ä", "ae");
		hm.put("Ä", "Ae");
		hm.put("ö", "oe");
		hm.put("Ö", "Oe");
		hm.put("ü", "ue");
		hm.put("Ü", "Ue");
		hm.put("ß", "ss");

		StringBuilder sb = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(filename));
				BufferedWriter bw = new BufferedWriter(new FileWriter("tr_"
						+ filename))) {

			while ((eineZeile = br.readLine()) != null) {

				for (String s : hm.keySet()) {

					eineZeile = eineZeile.replaceAll(s, hm.get(s));
				}

				bw.write(eineZeile);
				bw.newLine();
				sb.append(eineZeile+ "\n");

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Fehler: " + e.getMessage());
		}

		return sb.toString();

	}

}

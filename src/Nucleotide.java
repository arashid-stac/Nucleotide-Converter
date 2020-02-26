import java.util.Hashtable;

public class Nucleotide {
	int atg_pos;
	String stop_protein;

	int getFirstProtein(String input_sequence) {
		atg_pos = input_sequence.indexOf("ATG");

		return atg_pos;
	}

	String getStopProtein(Hashtable<String, String> ht, String input_sequence) {
		for (int i = atg_pos; i < input_sequence.length(); i = i + 3) {
			stop_protein = String.valueOf(input_sequence.charAt(i)) + String.valueOf(input_sequence.charAt(i + 1))
					+ String.valueOf(input_sequence.charAt(i + 2));
			if (ht.get(stop_protein) == "STOP") {
				break;
			}
		}

		return stop_protein;
	}

	String retrieveProteinSequence(Hashtable<String, String> ht, String input_sequence) {
		int i = atg_pos;
		String protein_sequence = "";
		while ((String.valueOf(input_sequence.charAt(i)) + String.valueOf(input_sequence.charAt(i + 1))
				+ String.valueOf(input_sequence.charAt(i + 2))) != stop_protein) {
			protein_sequence = protein_sequence + " " + ht.get((String.valueOf(input_sequence.charAt(i))
					+ String.valueOf(input_sequence.charAt(i + 1)) + String.valueOf(input_sequence.charAt(i + 2))));
			i = i + 3;
			if (i > input_sequence.indexOf(stop_protein)) {
				break;
			}
		}
		return protein_sequence;
	}
}

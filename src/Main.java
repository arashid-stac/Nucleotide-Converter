import java.util.Hashtable;
import java.util.Scanner;

public class Main {

	private static Scanner input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashtable<String, String> amino_acids = new Hashtable<String, String>();
		amino_acids.put("TTT", "Phe");
		amino_acids.put("TCT", "Ser");
		amino_acids.put("TAT", "Tyr");
		amino_acids.put("TGT", "Cys");
		amino_acids.put("TTC", "Phe");
		amino_acids.put("TCC", "Ser");
		amino_acids.put("TAC", "Tyr");
		amino_acids.put("TGC", "Cys");
		amino_acids.put("TTA", "Leu");
		amino_acids.put("TCA", "Ser");
		amino_acids.put("TAA", "STOP");
		amino_acids.put("TGA", "STOP");
		amino_acids.put("TTG", "Leu");
		amino_acids.put("TCG", "Ser");
		amino_acids.put("TAG", "STOP");
		amino_acids.put("CGT", "Trp");
		amino_acids.put("CTT", "Leu");
		amino_acids.put("CCT", "Pro");
		amino_acids.put("CAT", "His");
		amino_acids.put("CGC", "Arg");
		amino_acids.put("CTC", "Leu");
		amino_acids.put("CCC", "Pro");
		amino_acids.put("CAC", "His");
		amino_acids.put("CGA", "Arg");
		amino_acids.put("CTA", "Leu");
		amino_acids.put("CCA", "Pro");
		amino_acids.put("CAA", "Gln");
		amino_acids.put("CGG", "Arg");
		amino_acids.put("CTG", "Leu");
		amino_acids.put("CCG", "Pro");
		amino_acids.put("CAG", "Gln");
		amino_acids.put("AGT", "Ser");
		amino_acids.put("ATT", "Ile");
		amino_acids.put("ACT", "Thr");
		amino_acids.put("AAT", "Asn");
		amino_acids.put("AGC", "Ser");
		amino_acids.put("ATC", "Ile");
		amino_acids.put("ACC", "Thr");
		amino_acids.put("AAC", "Asn");
		amino_acids.put("AGA", "Arg");
		amino_acids.put("ATA", "Ile");
		amino_acids.put("ACA", "Thr");
		amino_acids.put("AAA", "Lys");
		amino_acids.put("AGG", "Arg");
		amino_acids.put("ATG", "Met");
		amino_acids.put("ACG", "Thr");
		amino_acids.put("AAG", "Lys");
		amino_acids.put("GGT", "Gly");
		amino_acids.put("GTT", "Val");
		amino_acids.put("GCT", "Ala");
		amino_acids.put("GAT", "Asp");
		amino_acids.put("GGC", "Gly");
		amino_acids.put("GTC", "Val");
		amino_acids.put("GCC", "Ala");
		amino_acids.put("GAC", "Asp");
		amino_acids.put("GGA", "Gly");
		amino_acids.put("GTA", "Val");
		amino_acids.put("GCA", "Ala");
		amino_acids.put("GAA", "Glu");
		amino_acids.put("GGG", "Gly");
		amino_acids.put("GCG", "Ala");
		amino_acids.put("GAG", "Glu");
		
		boolean isValid = false;
		String input_sequence;
		Nucleotide nucleotide = new Nucleotide();
		do {
			input = new Scanner(System.in);
			input_sequence = input.nextLine().toUpperCase().replace(" ", "");
			
			if (input_sequence.length() % 3 != 0) {
				System.out.println("Input length not divisible by 3.");
				continue;
			}

			int atg_pos = nucleotide.getFirstProtein(input_sequence);
			if (atg_pos == -1 || atg_pos % 3 != 0) {
				System.out.println("No start found.");
				continue;
			}

			String stop_protein = nucleotide.getStopProtein(amino_acids, input_sequence);
			if (amino_acids.get(stop_protein) != "STOP") {
				System.out.println("No STOP found.");
				continue;
			}
			
			String protein_sequence = nucleotide.retrieveProteinSequence(amino_acids, input_sequence);
			if (protein_sequence.contains("null")) {
				System.out.println("Invalid character input.");
				continue;
			}
			isValid = true;
			System.out.println(protein_sequence);
		} while (isValid == false);
		
	}

}

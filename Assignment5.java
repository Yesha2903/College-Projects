import java.util.*;

public class Assignment5 {
    public static boolean validator(String dna) {
            if (dna.isEmpty()) {
                return false;
            }
            if (dna.length() % 3 != 0) {
                return false;
            }
            for (char c : dna.toCharArray()) {
                if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
                    return false;
                }
            }
            return true;
        }

    // }
    public static String reverser(String dna) {
        if (dna.isEmpty()) {
            return "";
        }
        return reverser(dna.substring(1)) + dna.charAt(0);
    }

    public static String inverser(String dna) {
        if (dna.isEmpty()) {
            return "";
        }
        char invertedChar;
        switch (dna.charAt(0)) {
            case 'A':
                invertedChar = 'T';
                break;
            case 'C':
                invertedChar = 'G';
                break;
            case 'G':
                invertedChar= 'C';
                break;
            case 'T':
                invertedChar = 'A';
                break;
            default:
                invertedChar = dna.charAt(0);
                break;
        }
        return invertedChar + inverser(dna.substring(1));
    }

    public static String translator(String dna) {
        if (dna.isEmpty()) {
            return "";
        }
        String codon = dna.substring(0, 3);
        String aminoAcid = translateCodon(codon);
        return aminoAcid + translator(dna.substring(3));
    }

    private static String translateCodon(String codon) {
        String aminoacid = "";
        switch (codon) {
            case "GCA":
            case "GCC":
            case "GCG":
            case "GCT":
                aminoacid = "A";
                break;
            case "TGC":
            case "TGT":
                aminoacid = "C";
                break;
            case "GAC":
            case "GAT":
                aminoacid = "D";
                break;
            case "GAA":
            case "GAG":
                aminoacid = "E";
                break;
            case "TTC":
            case "TTT":
                aminoacid = "F";
                break;
            case "GGA":
            case "GGC":
            case "GGG":
            case "GGT":
                aminoacid = "G";
                break;
            case "CAC":
            case "CAT":
                aminoacid = "H";
                break;
            case "ATA":
            case "ATC":
            case "ATT":
                aminoacid = "I";
                break;
            case "AAA":
            case "AAG":
                aminoacid = "K";
                break;
            case "CTA":
            case "CTC":
            case "CTG":
            case "CTT":
            case "TTA":
            case "TTG":
                aminoacid = "L";
                break;
            case "ATG":
                aminoacid = "M";
                break;
            case "AAT":
            case "AAC":
                aminoacid = "N";
                break;
            case "CCA":
            case "CCC":
            case "CCG":
            case "CCT":
                aminoacid = "P";
                break;
            case "CAA":
            case "CAG":
                aminoacid = "Q";
                break;
            case "AGA":
            case "AGG":
            case "CGA":
            case "CGC":
            case "CGG":
            case "CGT":
                aminoacid = "R";
                break;
            case "AGC":
            case "AGT":
            case "TCA":
            case "TCC":
            case "TCG":
            case "TCT":
                aminoacid = "S";
                break;
            case "ACA":
            case "ACC":
            case "ACG":
            case "ACT":
                aminoacid = "T";
                break;
            case "GTA":
            case "GTC":
            case "GTG":
            case "GTT":
                aminoacid = "V";
                break;
            case "TGG":
                aminoacid = "W";
                break;
            case "TAC":
            case "TAT":
                aminoacid = "Y";
                break;
            case "TAA":
            case "TAG":
            case "TGA":
                aminoacid = "-";
                break;
        }
        return aminoacid;
    }


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("[DNA Reverser and Translator]");
            System.out.print("Enter a DNA sequence: ");
            String input = scanner.nextLine().toUpperCase(); // Convert to uppercase
            scanner.close();

            if (validator(input)) {
                String reversed = reverser(input);
                String inversed = inverser(reversed);
                String translated = translator(inversed);
                System.out.println("Your DNA sequence reversed and translated is: " + "\n" + translated);
            } else {
                System.out.println("The DNA sequence is invalid.");
            }
        }
    }

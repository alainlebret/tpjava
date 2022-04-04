package covid19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiGenesFinder {
    public String findGenes(String dnaOri) {
        String gene = "";
        String dna = dnaOri.toLowerCase();
        int start = -1;

        while (true) {
            start = dna.indexOf("atg", start);
            if (start == -1) {
                break;
            }
            int stop = findStopCodon(dna, start);
            if (stop > start) {
                String currGene = dnaOri.substring(start, stop + 3);
                System.out.println("From: " + start + " to " + stop + "Gene: "
                        + currGene);
            }
        }
        return gene;
    }

    private int findStopCodon(String dna, int start) {
        for (int i = start + 3; i < dna.length() - 3; i += 3) {
            String currFrameString = dna.substring(i, i + 3);

            if (currFrameString.equals("TAG")) {
                return i;
            } else if (currFrameString.equals("TGA")) {
                return i;

            } else if (currFrameString.equals("TAA")) {
                return i;
            }
        }
        return -1;
    }

    public void testing() {
        MultiGenesFinder fMG = new MultiGenesFinder();
        String dna = "CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA";

        fMG.findGenes(dna);
        System.out.println("DNA string is: " + dna);
    }

    public static void othermain(String[] args) {

        String dna = "CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA";
        String sequence = dna.toLowerCase();
        int index = 0;
        int newIndex = 0;
        while (true) {
            index = sequence.indexOf("atg", index);
            if (index == -1)
                return;
            newIndex = sequence.indexOf("tag", index + 3);
            if (newIndex == -1) // Check needed only if a stop codon is not guaranteed for each start codon.
                return;
            System.out.println("From " + (index + 3) + " to " + newIndex + " Gene: " + sequence.substring(index + 3, newIndex));
            index = newIndex + 3;
        }
    }

    public static void main(String[] args) {

        String dna = "CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA";

        Pattern p = Pattern.compile("ATG([ATGC]+?)TAG");
        Matcher m = p.matcher(dna);

        while (m.find())
            System.out.println("From " + m.start(1) + " to " + m.end(1) + " Gene: " + m.group(1));
    }
}
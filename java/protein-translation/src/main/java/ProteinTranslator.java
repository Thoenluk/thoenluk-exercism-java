
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

class ProteinTranslator {

    private static final Map<String, String> dict = Map.ofEntries(
            entry("AUG", "Methionine"),
            entry("UUU", "Phenylalanine"),
            entry("UUC", "Phenylalanine"),
            entry("UUA", "Leucine"),
            entry("UUG", "Leucine"),
            entry("UCU", "Serine"),
            entry("UCC", "Serine"),
            entry("UCG", "Serine"),
            entry("UCA", "Serine"),
            entry("UAU", "Tyrosine"),
            entry("UAC", "Tyrosine"),
            entry("UGU", "Cysteine"),
            entry("UGC", "Cysteine"),
            entry("UGG", "Tryptophan"),
            entry("UAA", "STOP"),
            entry("UAG", "STOP"),
            entry("UGA", "STOP")
    );

    List<String> translate(String rnaSequence) {
        List<String> output = new LinkedList<>();
        String protein = "";
        for (int i = 0; i < rnaSequence.length(); i += 3) {
            protein = dict.get(rnaSequence.substring(i, i + 3));
            if (protein.equals("STOP")) {
                break;
            }
            output.add(protein);
        }
        return output;
    }
}

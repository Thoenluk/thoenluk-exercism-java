
import java.util.HashMap;

public class WordCount {
    public HashMap<String, Integer> phrase(String phrase) {
        HashMap<String, Integer> occurences = new HashMap<>();
        phrase = phrase.replaceAll("(?!\\w*'?\\w)(\\W+)", " ").trim().toLowerCase();
        for(String word : phrase.split(" ")) {
            occurences.put(word, occurences.containsKey(word) ? occurences.get(word) + 1 : 1);
        }
        return occurences;
    }
}
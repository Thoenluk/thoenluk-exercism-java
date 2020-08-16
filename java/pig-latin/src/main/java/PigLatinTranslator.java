
import java.util.Arrays;
import java.util.HashSet;

class PigLatinTranslator {

    public String translate(String phrase) {
        String output = "";
        String[] words = phrase.toLowerCase().split(" ");
        HashSet<Character> vowels = new HashSet<>(Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u'}));
        for (String word : words) {
            int firstVowelIndex = 0;
            for (int i = 0; i < word.length(); i++) {
                if (vowels.contains(word.charAt(i))
                        || (i == 0 && word.length() >= 2 && (word.substring(0, 2).equals("xr") || word.substring(0, 2).equals("yt")))
                        || (i > 0 && word.charAt(i) == 'y')) {
                    if (i > 0 && word.charAt(i) == 'u' && word.charAt(i - 1) == 'q') {
                        firstVowelIndex++;
                    }
                    break;
                }
                firstVowelIndex++;
            }
            word = word.substring(firstVowelIndex) + word.substring(0, firstVowelIndex) + "ay";
            output += word + " ";
        }
        return output.trim();
    }

}

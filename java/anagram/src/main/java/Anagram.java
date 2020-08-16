
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

class Anagram {
    private HashMap<Character, Integer> originalLetters;
    private String originalWord;
    
    public Anagram(String originalWord){
        this.originalWord = originalWord;
        this.originalLetters = countLetters(originalWord);
    }
    
    public LinkedList match(Collection<String> words){
        LinkedList<String> matches = new LinkedList<>();
        for(String word : words){
            if(!word.equalsIgnoreCase(originalWord) && countLetters(word).equals(originalLetters)){
                matches.add(word);
            }
        }
        return matches;
    }
    
    private HashMap countLetters(String word){
        HashMap<Character, Integer> letters = new HashMap<>();
        for(Character curr : word.toLowerCase().toCharArray()){
            if(!letters.containsKey(curr)){
                letters.put(curr, 0);
            }
            letters.put(curr, letters.get(curr) + 1);
        }
        return letters;
    }
}
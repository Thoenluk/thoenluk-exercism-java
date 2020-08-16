
import java.util.HashSet;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        HashSet<Character> previousChars = new HashSet<>();
        for(Character current : phrase.toLowerCase().toCharArray()){
            if(current != '-' && current != ' '  && previousChars.contains(current)){
                return false;
            } else {
              previousChars.add(current);  
            }
        }
        return true;
    }

}

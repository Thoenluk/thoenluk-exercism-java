
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketChecker {
    private boolean matchedCorrectly = true;
    private final Stack<Character> openings = new Stack<>();
    private static final Map<Character, Character> CLOSINGS = Map.of('(', ')', '[', ']', '{', '}');
    
    public BracketChecker(String input) {
        for(char current : input.toCharArray()) {
            switch(current) {
                case '(':
                case '[':
                case '{':
                    openings.push(current);
                    break;
                case ')':
                case ']':
                case '}':
                    if(openings.empty() || CLOSINGS.get(openings.pop()) != current) {
                        matchedCorrectly = false;
                        return;
                    }
                    break;
            }
        }
        matchedCorrectly = matchedCorrectly && openings.empty();
        // Currently, this line is only reached iff matchedCorrectly is true.
        // But that is a bit of an obtuse assumption, so future proofing it is nice.
    }
    
    public boolean areBracketsMatchedAndNestedCorrectly() {
        return matchedCorrectly;
    }
}
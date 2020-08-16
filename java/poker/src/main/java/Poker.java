
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Poker {
    private LinkedList<String> bestHands;
    
    public Poker(List<String> hands) {
        this.bestHands = new LinkedList<>();
        int bestScore = Integer.MIN_VALUE;
        
    }
    
    public List<String> getBestHands(){
        return bestHands;
    }
}
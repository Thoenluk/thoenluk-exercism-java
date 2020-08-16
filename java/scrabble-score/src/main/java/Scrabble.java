import java.util.HashMap;

class Scrabble {
    
    private static final HashMap<Character, Integer> values;    
    String word;
    int score;
    
    static {
        values = new HashMap<>();
        char[][] letterGroups = new char[][]{
            {'a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't'},
            {'d', 'g'},
            {'b', 'c', 'm', 'p'},
            {'f', 'h', 'v', 'w', 'y'},
            {'k'},
            {'j', 'x'},
            {'q', 'z'}
        };
        int[] letterValues = new int[]{1, 2, 3, 4, 5, 8, 10};
        for(int i = 0; i < letterGroups.length; i++){
            for(char current : letterGroups[i]){
                values.put(current, letterValues[i]);
            }
        }
    }
        
    Scrabble(String word) {
        this.word = word;
        this.score = Integer.MIN_VALUE;
    }

    int getScore() {
        if(score == Integer.MIN_VALUE){
            score = 0;
            for(char current : word.toLowerCase().toCharArray()){
                score += values.get(current);
            }
        }
        return score;
    }

}

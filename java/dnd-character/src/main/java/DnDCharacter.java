
import java.util.Random;

class DnDCharacter {
    
    int[] scores; //I refuse to make six variables.
    
    public DnDCharacter(){
        this.scores = new int[6];
    }

    int ability() {
        Random die = new Random();
        int score = 0, lowestScore = Integer.MAX_VALUE, currentRoll;
        for(int i = 0; i < 4; i++){
            currentRoll = die.nextInt(6) + 1;
            score += currentRoll;
            lowestScore = currentRoll < lowestScore ? currentRoll : lowestScore;
        }
        score -= lowestScore;
        return score;
    }

    int modifier(int input) {
        input -= input % 2;
        return (input - 10) / 2;
    }

    int getStrength() {
        return safeGetAbility(0);
    }

    int getDexterity() {
        return safeGetAbility(1);
    }

    int getConstitution() {
        return safeGetAbility(2);
    }

    int getIntelligence() {
        return safeGetAbility(3);
    }

    int getWisdom() {
        return safeGetAbility(4);
    }

    int getCharisma() {
        return safeGetAbility(5);
    }

    int getHitpoints() {
        return 10 + modifier(getConstitution());
    }
    
    private int safeGetAbility(int index){
        if(scores[index] == 0){
            scores[index] = ability();
        }
        return scores[index];
    }

}

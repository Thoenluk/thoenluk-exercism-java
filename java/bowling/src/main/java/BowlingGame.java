
import java.util.ArrayList;

public class BowlingGame {
    private final int[][] frames;
    private int currentFrame;
    private int currentThrow;

    public BowlingGame() {
        this.frames = new int[10][];
        for(int i = 0; i < 9; i++){
            frames[i] = new int[2];
        }
        frames[9] = new int[3];
        currentFrame = 0;
        currentThrow = 0;
    }
    
    public void roll(int pins) {
        if(pins < 0){
            throw new IllegalStateException("Negative roll is invalid");
        }
        if(currentFrame == 10){
            throw new IllegalStateException("Cannot roll after game is over");
        }
        int scoreInFrame = 0;
        int acceptableValue = 10;
        for(int i = 0; i <= currentThrow; i++){
            scoreInFrame += frames[currentFrame][i];
            scoreInFrame %= 10;
        }
        if(pins + scoreInFrame > 10){
            throw new IllegalStateException("Pin count exceeds pins on the lane");
        }
        frames[currentFrame][currentThrow] = pins;
        currentThrow++;
        switch(currentThrow){
            case 1:
                if(pins == 10 && currentFrame < 9){
                    currentThrow = 0;
                    currentFrame++;
                }
                break;
            case 2:
                if(currentFrame < 9 || (currentFrame == 9 && pins + frames[9][0] < 10)){
                    currentThrow = 0;
                    currentFrame++;
                }
                break;
            case 3:
                currentThrow = 0;
                currentFrame++;
        }
    }
    
    public int score() {
        if(currentFrame < 10){
            throw new IllegalStateException("Score cannot be taken until the end of the game");
        }
        int score = 0, i, j;
        for(i = 0; i < 9; i++){
            for(j = 0; j < 2; j++){
                score += frames[i][j];
            }
            if(frames[i][0] + frames[i][1] == 10){
                score += frames[i + 1][0];
            }
            if(frames[i][0] == 10){
                if(frames[i + 1][0] == 10 && i < 8){
                    score += frames[i + 2][0];
                } else {
                    score += frames[i + 1][1];
                }
            }
        }
        for(j = 0; j < 3; j++){
            score += frames[9][j];
        }
        return score;
    }
    
}

import java.util.ArrayList;
import java.util.List;

class MinesweeperBoard {
    private final List<String> numberedBoard;
    
    public MinesweeperBoard(List<String> board){
        this.numberedBoard = new ArrayList<>(board.size());
        int x, y, currentIndex, mines;
        String line;
        char current;
        for(int lineIndex = 0; lineIndex < board.size(); lineIndex++){
            line = board.get(lineIndex);
            StringBuilder sb = new StringBuilder();
            for(currentIndex = 0; currentIndex < line.length(); currentIndex++){
                current = line.charAt(currentIndex);
                if(current == ' '){
                    mines = 0;
                    for(y = lineIndex - 1; y <= lineIndex + 1; y++){
                        if(0 <= y && y < board.size()){
                            for(x = currentIndex - 1; x <= currentIndex + 1; x++){
                                if(0 <= x && x < line.length() && board.get(y).charAt(x) == '*'){
                                    mines++;
                                }
                            }
                        }
                    }
                    sb.append(mines > 0 ? mines : " ");
                } else {
                    sb.append(current);
                }
            }
            numberedBoard.add(sb.toString());
        }
    }
    
    public List<String> withNumbers(){
        return numberedBoard;
    }
}
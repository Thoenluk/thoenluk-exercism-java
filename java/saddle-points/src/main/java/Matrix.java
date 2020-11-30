import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {
    
    Set<MatrixCoordinate> saddlePoints = new HashSet<>();

    Matrix(List<List<Integer>> values) {
        if(values.isEmpty()){
            return;
        }
        int row, col, current, i;
        int[] maxRowValues = new int[values.size()];
        int[] minColValues = new int[values.get(0).size()];
        Arrays.fill(minColValues, Integer.MAX_VALUE);
        boolean[][] isSaddlePoint = new boolean[values.size()][values.get(0).size()];
        for(row = 0; row < values.size(); row++){
            for(col = 0; col < values.get(row).size(); col++){
                current = values.get(row).get(col);
                if(current > maxRowValues[row]){
                    maxRowValues[row] = current;
                    for(i = 0; i < isSaddlePoint[row].length; i++){
                        isSaddlePoint[row][i] = false;
                    }
                }
                if(current < minColValues[col]){
                    minColValues[col] = current;
                    for(i = 0; i < isSaddlePoint.length; i++){
                        isSaddlePoint[i][col] = false;
                    }
                }
                if(current == maxRowValues[row] && current == minColValues[col]){
                    isSaddlePoint[row][col] = true;
                }
            }
        }
        for(row = 0; row < values.size(); row++){
            for(col = 0; col < values.get(row).size(); col++){
                if(isSaddlePoint[row][col]){
                    saddlePoints.add(new MatrixCoordinate(row + 1, col + 1));
                }
            }
        }
        
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return saddlePoints;
    }
}

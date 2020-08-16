class Queen {
    private final int row, column;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    
    public Queen(int row, int column){
        if(row < 0 || column < 0){
            throw new IllegalArgumentException("Queen position must have positive " + (row < 0 ? "row" : "column") + ".");
        }
        if(row >= 8 || column >= 8){
            throw new IllegalArgumentException("Queen position must have " + (row >= 8 ? "row" : "column") + " <= 7.");
        }
        this.row = row;
        this.column = column;
    }
    
    @Override
    public boolean equals(Object other){
        if(!(other instanceof Queen)){
            return false;
        }
        Queen o = (Queen) other;
        return this.row == o.row && this.column == o.column;
    }
}

class QueenAttackCalculator {
    private final Queen first, second;
    //I would just like to comment on how supremely wasteful this construct is. You could give Queen a method canAttack(Queen) which would be better in so many ways.
    public QueenAttackCalculator(Queen first, Queen second){
        if(null == first || null == second){
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if(first.equals(second)){
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
        this.first = first;
        this.second = second;
    }
    
    public boolean canQueensAttackOneAnother(){
        return first.getRow() == second.getRow()
                || first.getColumn() == second.getColumn()
                || Math.abs(first.getRow() - second.getRow()) == Math.abs(first.getColumn() - second.getColumn());
    }
}
class CollatzCalculator {

    int computeStepCount(int start) {
        if(start < 1){
            throw new IllegalArgumentException("Only natural numbers are allowed");
        }
        int steps = 0;
        while(start > 1){
            start = start % 2 == 1 ? 3 * start + 1 : start / 2;
            steps++;
        }
        return steps;
    }

}

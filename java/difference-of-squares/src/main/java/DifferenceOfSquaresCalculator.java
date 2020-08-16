class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum = (input * input + input)/2;
        return sum * sum;
    }

    int computeSumOfSquaresTo(int input) {
        return (2 * input * input * input + 3 * input * input + input)/6;
        //I promise I did my best to derive this myself. But I ended up Wikipediaing it.
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}

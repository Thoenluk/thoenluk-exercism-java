import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if(square < 1 || 64 < square){
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return BigInteger.TWO.pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        //The sum of all powers of 2 up to 2^n is 2^(n + 1) - 1. I know this because math.
        return grainsOnSquare(64).multiply(BigInteger.TWO).subtract(BigInteger.ONE);
    }

}

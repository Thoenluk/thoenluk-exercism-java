
class Hamming {

    int distance = 0;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
        int leftLength = leftStrand.length(), rightLength = rightStrand.length();

        if (leftLength != rightLength) {
            if (leftLength == 0) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if (rightLength == 0) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        for (int i = 0; i < leftLength; i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                distance++;
            }
        }
    }
    
    public int getHammingDistance(){
        return distance;
    }
}

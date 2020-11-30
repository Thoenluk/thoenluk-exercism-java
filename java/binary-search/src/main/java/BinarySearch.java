
import java.util.List;

class BinarySearch {
    private List<Integer> list;
    
    public BinarySearch(List<Integer> list) {
        this.list = list;
    }
    
    public int indexOf(Integer target) throws ValueNotFoundException {
        int lowerBound = 0;
        int upperBound = list.size() - 1;
        int currentIndex;
        while(lowerBound <= upperBound) {
            currentIndex = lowerBound + (upperBound - lowerBound) / 2;
            switch(list.get(currentIndex).compareTo(target)) {
                case -1: // Target is greater: Step towards the end of the list.
                    lowerBound = currentIndex + 1;
                    break;
                case 0: // Equal: Found it, so return index
                    return currentIndex;
                case 1: // Target is lesser: Step towards the beginning of the list.
                    upperBound = currentIndex - 1;
                    break;
            }
        }
        throw new ValueNotFoundException("Value not in array");
    }
}
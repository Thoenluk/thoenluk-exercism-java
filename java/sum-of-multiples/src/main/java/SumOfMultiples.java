
import java.util.HashSet;

class SumOfMultiples {
    
    int sum = 0;

    SumOfMultiples(int number, int[] set) {
        HashSet<Integer> multiples = new HashSet<>();
        int i;
        for(Integer factor : set){
            if(factor != 0){
                for(i = 1; i * factor < number; i++){
                    multiples.add(i * factor);
                }
            }
        }
        multiples.forEach(multiple -> {sum += multiple;});
    }

    int getSum() {
        return sum;
    }

}

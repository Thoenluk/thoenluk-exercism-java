
import java.util.HashSet;
import java.util.LinkedList;

class NaturalNumber {
    
    private final int value;
    private final LinkedList<Integer> primeFactors;
    private final HashSet<Integer> allFactors;
    
    public NaturalNumber(int value) throws IllegalArgumentException{
        if(value < 1){
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.value = value;
        this.primeFactors = new LinkedList<>();
        this.allFactors = new HashSet<>();
    }

    public Classification getClassification(){
        findPrimeFactors(value);
        compileCompositeFactors();
        int sum = 0;
        for(Integer factor : allFactors){
            sum += factor;
        }
        sum -= value;
        if(sum != 0){
            sum = sum / Math.abs(sum);
        }
        switch(sum){
            case -1:
                return Classification.DEFICIENT;
            case 0:
            default:
                return Classification.PERFECT;
            case 1:
                return Classification.ABUNDANT;
        }
    }
    
    private void findPrimeFactors(int remaining){
        for(int i = 2; i <= remaining; i++){
            if(remaining % i == 0){
                this.primeFactors.add(i);
                findPrimeFactors(remaining/i);
                break;
            }
        }
    }
    
    private void compileCompositeFactors(){
        int limit = 1 << primeFactors.size();
        int product, pos;
        for(int combination = 0; combination < limit; combination++){
            product = 1;
            for(pos = 0; 1 << pos <= combination; pos++){
                if(((1 << pos) & combination) > 0){
                    product *= primeFactors.get(pos);
                }
            }
            if(product != value){
                allFactors.add(product);                
            }
        }
    }
}

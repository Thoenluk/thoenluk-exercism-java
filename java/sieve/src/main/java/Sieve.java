import java.util.LinkedList;
import java.util.List;

class Sieve {
    List<Integer> primes = new LinkedList<>();
    
    Sieve(int maxPrime) {
        boolean[] isComposite = new boolean[maxPrime + 1];
        int i, sum;
        for(i = 2; i <= maxPrime; i++){
            if(!isComposite[i]){
                primes.add(i);
                for(sum = 2 * i; sum <= maxPrime; sum += i){ // Since we're playing complexity golf, replace from-scratch multiplication with n additions.
                    isComposite[sum] = true;
                }
            }
        }
    }

    List<Integer> getPrimes() {
        return primes;
    }
}

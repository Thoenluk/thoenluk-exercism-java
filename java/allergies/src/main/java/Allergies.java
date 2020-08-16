
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Allergies {
    private final int score;
    
    public Allergies(int score){
        this.score = score;
    }
    
    public boolean isAllergicTo(Allergen allergen){
        return 0 < (score & allergen.getScore());
    }
    
    public List<Allergen> getList(){
        List<Allergen> allergens = Stream.of(Allergen.values()).collect(Collectors.toList());
        allergens.removeIf((element) -> {return !isAllergicTo(element);});
        return allergens;
    }
}
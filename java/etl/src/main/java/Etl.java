import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        HashMap<String, Integer> transformed = new HashMap<>();
        for(Entry<Integer, List<String>> current : old.entrySet()) {
            for(String letter : current.getValue()) {
                transformed.put(letter.toLowerCase(), current.getKey());
            }
        }
        return transformed;
    }
}

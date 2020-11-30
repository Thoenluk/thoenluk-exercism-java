
import java.util.HashSet;
import java.util.Random;

public class Robot {
    private static HashSet<String> usedNames = new HashSet<>();
    // Technically, hashes could collide, so each name may block some others from being
    // chosen. But as there are only 676000 possible names, and a String's hashcode
    // is virtually random even with five digits. As there are four billion possible
    // hash codes, the odds are quite low. Also, wasting names is fine, overlapping is bad.
    private static Random rand = new Random();
    private String name;
    
    public Robot() {
        generateName();
    }
    
    private void generateName() {
        StringBuilder sb;
        do {
            sb = new StringBuilder();
            sb.append((char) ('A' + rand.nextInt(26)));
            sb.append((char) ('A' + rand.nextInt(26)));
            sb.append(String.format("%03d", rand.nextInt(1000)));
            name = sb.toString();
        } while(!usedNames.add(name));
    }
    
    public String getName() {
        return name;
    }
    
    public void reset() {
        String oldName = name;
        generateName();
        usedNames.remove(oldName);
    }
}
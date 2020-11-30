
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class School {
    // Sorting manually is for chumps. Hooray for self-sorting collections!
    TreeMap<Integer, TreeSet<String>> students = new TreeMap<>();
    
    public void add(String name, int grade) {
        if(!students.containsKey(grade)) {
            students.put(grade, new TreeSet<>());
        }
        students.get(grade).add(name);
    }
    
    public List<String> roster() {
        List<String> roster = new LinkedList<>();
        for(Set<String> grade : students.values()) {
            for(String student : grade) {
                roster.add(student);
            }
        }
        return roster;
    }
    
    public List<String> grade(int grade) {
        if(!students.containsKey(grade)) {
            students.put(grade, new TreeSet<>());
        }
        return List.copyOf(students.get(grade));
    }
}
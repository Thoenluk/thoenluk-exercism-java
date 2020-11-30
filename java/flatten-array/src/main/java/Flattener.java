
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Flattener {    
    public List flatten(List nested) {
        LinkedList<Object> flat = new LinkedList<>();
        Stack<Iterator> iterators = new Stack();
        iterators.add(nested.iterator());
        Object current;
        while(!iterators.empty()) {
            if(!iterators.peek().hasNext()) {
                iterators.pop();
            } else {
                current = iterators.peek().next();
                if(current instanceof List) {
                    iterators.push(((List) current).iterator());
                } else if(null != current) {
                    flat.add(current);
                }
            }
        }
        return flat;
    }
}

import java.util.LinkedList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char input) { //Whose idea was it to name the input a?
        LinkedList<String> list = new LinkedList<>();
        StringBuilder builder;
        int distanceFromA = input - 'A';
        int i, j;
        char current;
        for (i = distanceFromA; i >= 0; i--) {
            builder = new StringBuilder();
            current = (char) (input - i);
            for (j = i; j > 0; j--) {
                builder.append(' ');
            }
            builder.append(current);
            if (current != 'A') {
                for (j = 2 * (distanceFromA - i) - 1; j > 0; j--) {
                    builder.append(' ');
                }
                builder.append(current);
            }
            for (j = i; j > 0; j--) {
                builder.append(' ');
            }
            list.add(list.size() / 2, builder.toString());
            if (i > 0) {
                list.add(list.size() / 2, builder.toString());
            }
        }
        return list;
    }

}

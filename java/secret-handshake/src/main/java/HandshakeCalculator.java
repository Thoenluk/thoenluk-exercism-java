import java.util.LinkedList;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        boolean reverse = (number & (0x1 << 4)) > 0;
        LinkedList<Signal> handshake = new LinkedList<>();
        for(Signal current : Signal.values()){
            if((number & (0x1 << current.ordinal())) > 0){
                handshake.add(reverse ? 0 : handshake.size(), current);
            }
        }
        return handshake; //The way this line incidentally ended up makes me giggle.
    }

}

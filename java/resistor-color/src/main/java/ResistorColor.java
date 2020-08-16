
import java.util.HashMap;
import java.util.LinkedList;

class ResistorColor {
    private final HashMap<String, Integer> colourCodes;
    
    public ResistorColor(){
        String[] colours = new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        this.colourCodes = new HashMap<>();
        for(int i = 0; i < colours.length; i++){
            colourCodes.put(colours[i], i);
        }
    }
    
    int colorCode(String color) {
        return colourCodes.get(color);
    }

    String[] colors() {
        LinkedList<String> colours = new LinkedList<>();
        colours.addAll(colourCodes.keySet());
        colours.sort((a, b) -> {return colourCodes.get(a) - colourCodes.get(b);});
        return colours.toArray(new String[colours.size()]);
        //Yes, this is stupid and the colours array used in the constructor should simply
        //be saved and returned here. Please don't do something like this. I just fancied
        //the challenge of saving exactly and only the HashMap.
    }
}

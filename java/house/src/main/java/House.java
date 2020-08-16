class House {
    private static final String[] ITEMS = new String[]{
        "the malt that lay in ",
        "the rat that ate ",
        "the cat that killed ",
        "the dog that worried ",
        "the cow with the crumpled horn that tossed ",
        "the maiden all forlorn that milked ",
        "the man all tattered and torn that kissed ",
        "the priest all shaven and shorn that married ",
        "the rooster that crowed in the morn that woke ",
        "the farmer sowing his corn that kept ",
        "the horse and the hound and the horn that belonged to "
    }; //This is purely for legibility. Optimal uglified code would be to just initialise
    //the full strings into the array right away. But this is lovely and that solution
    //makes me want to draw deer on the wall of my cave (i.e. it's troglodytic)
    
    private final String[] verses = new String[12];
    
    public House(){
        int i, j;
        StringBuilder builder;
        for(i = 0; i < verses.length; i++){
            builder = new StringBuilder();
            builder.append("This is ");
            for(j = i - 1; j >= 0; j--){
                builder.append(ITEMS[j]);
            }
            builder.append("the house that Jack built."); //Also, a partridge in a pear tree.
            verses[i] = builder.toString();
        }
    };
    
    String verse(int verseNumber) {
        return verses[verseNumber - 1];
    }

    String verses(int startVerse, int endVerse) {
        String lines = "";
        for(int i = startVerse; i <= endVerse; i++){
            lines += verse(i);
            if(i < endVerse){
                lines += "\n";
            }
        }
        return lines;
    }
    
    String sing() {
        return verses(1, 12);
    }
}

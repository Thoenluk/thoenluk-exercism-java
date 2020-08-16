class TwelveDays {
    private static final String[] ITEMS = new String[]{
        " a Partridge in a Pear Tree.\n",
        " two Turtle Doves, and",
        " three French Hens,",
        " four Calling Birds,",
        " five Gold Rings,",
        " six Geese-a-Laying,",
        " seven Swans-a-Swimming,",
        " eight Maids-a-Milking,",
        " nine Ladies Dancing,",
        " ten Lords-a-Leaping,",
        " eleven Pipers Piping,",
        " twelve Drummers Drumming,"
    }; //This is purely for legibility. Optimal uglified code would be to just initialise
    //the full strings into the array right away. But this is lovely and that solution
    //makes me want to draw deer on the wall of my cave (i.e. it's troglodytic)
    
    private static final String[] COUNT_WORDS = new String[]{
      "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"  
    };
    
    private final String[] verses = new String[12];
    
    public TwelveDays(){
        int i, j;
        for(i = 0; i < verses.length; i++){
            verses[i] = "On the " + COUNT_WORDS[i] + " day of Christmas my true love gave to me:";
            for(j = i; j >= 0; j--){
                verses[i] += ITEMS[j];
            }
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

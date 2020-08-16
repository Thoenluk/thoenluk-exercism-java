class ResistorColorDuo {
    enum Colour {
        BLACK,
        BROWN,
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        BLUE,
        VIOLET,
        GREY,
        WHITE;
    }
    
    int value(String[] colors) {
        int value = 0;
        for(int i = 0; i < 2 && i < colors.length; i++){
            value *= 10;
            value += Colour.valueOf(colors[i].toUpperCase()).ordinal();   
        }
        return value;
    }
}

class Proverb {

    String poem;
    
    Proverb(String[] words) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < words.length - 1; i++){
            builder.append("For want of a ");
            builder.append(words[i]);
            builder.append(" the ");
            builder.append(words[i + 1]);
            builder.append(" was lost.\n");
        }
        if(words.length > 0){
            builder.append("And all for the want of a ");
            builder.append(words[0]);
            builder.append(".");
        }
        poem = builder.toString();
    }

    String recite() {
        return poem;
    }

}

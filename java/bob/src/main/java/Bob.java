public class Bob {
    private static final String QUESTION = "Sure.";
    private static final String YELL = "Whoa, chill out!";
    private static final String YELLED_QUESTION = "Calm down, I know what I'm doing!";
    private static final String SILENCE = "Fine. Be that way!";
    private static final String ANYTHING = "Whatever.";
    
    public Bob(){}
    
    public String hey(String statement){
        statement = statement.trim();
        if(statement.isEmpty()){
            return SILENCE;
        }
        int expression = 0; //Could combine declaration into assignment one line down.
        //Could also work with bitshifts here to make the intention a bit clearer. But this is clean.
        expression += isYelled(statement) ? 1 : 0;
        expression += statement.endsWith("?") ? 2 : 0;
        switch(expression){
            default: //This line does nothing, but it makes the IDE happy.
            case 0:
                return ANYTHING;
            case 1:
                return YELL;
            case 2:
                return QUESTION;
            case 3:
                return YELLED_QUESTION;
        }
    }
    
    private boolean isYelled(String statement){
        //A string is yelled iff it contains one or more letters of the alphabet, all
        //of which are uppercase. Flipped around: If it contains one or more lowercase
        //letters or contains no letters at all, it is not yelled.
        boolean yelled = false;
        for(char current : statement.toCharArray()){
            if('a' <= current && current <= 'z'){
                return false; //lowercase letter; statement CAN'T be yelled.
            }
            yelled |= 'A' <= current && current <= 'Z'; //Could be replaced with regex maybe.
        }
        return yelled;
    }
}
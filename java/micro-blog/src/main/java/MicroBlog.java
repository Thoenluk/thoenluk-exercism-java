class MicroBlog {
    public String truncate(String input) {
        char[] chars = input.toCharArray();
        int totalCharsFound = 0;
        int i;
        for(i = 0; i < chars.length; i++){
            if(!Character.isSupplementaryCodePoint(chars[i])){
                totalCharsFound++;
                if(totalCharsFound == 5){
                    i++;
                    break;
                }
            }
        }
        return input.substring(0, i);
    }
}

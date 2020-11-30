class RunLengthEncoding {
    public String encode(String text) {
        if(text.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char current = text.charAt(0);
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == current) {
                count++;
            } else {
                sb.append(count > 1 ? count : "").append(current);
                count = 1;
                current = text.charAt(i);
            }
        }
        sb.append(count > 1 ? count : "").append(current);
        return sb.toString();
    }
    
    public String decode(String cipher) {
        if(cipher.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char current;
        for(int i = 0; i < cipher.length(); i++) {
            current = cipher.charAt(i);
            if(Character.isDigit(current)) {
                count *= 10;
                count += current - '0';
            } else {
                count = count > 0 ? count : 1;
                while(count > 0) {
                    sb.append(current);
                    count--;
                }
                count = 0;
            }
        }
        return sb.toString();
    }
}
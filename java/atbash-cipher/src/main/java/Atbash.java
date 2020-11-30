public class Atbash {
    public String encode(String text) {
        StringBuilder sb = new StringBuilder();
        char current;
        for(int i = 0; i < text.length(); i++) {
            current = text.charAt(i);
            if(Character.isLetter(current)) {
                sb.append((char)('a' - current + (Character.isUpperCase(current) ? 'Z' : 'z')));
            } else if(Character.isDigit(current)) {
                sb.append(current);
            }
            if((sb.length() + 1) % 6 == 0 && i <= text.length() - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
    
    public String decode(String cipher) {
        StringBuilder sb = new StringBuilder();
        char current;
        cipher = cipher.replace(" ", "");
        for(int i = 0; i < cipher.length(); i++) {
            current = cipher.charAt(i);
            if(Character.isLetter(current)){
                sb.append((char)('a' - current + (Character.isUpperCase(current) ? 'Z' : 'z')));
            } else if(Character.isDigit(current)) {
                sb.append(current);
            }
        }
        return sb.toString();
    }
}
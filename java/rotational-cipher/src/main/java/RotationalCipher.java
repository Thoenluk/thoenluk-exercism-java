class RotationalCipher {
    
    private final int shiftKey;
    
    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        char[] cipher = data.toCharArray();
        int offset;
        for(int i = 0; i < cipher.length; i++){
            if(Character.isLetter(cipher[i])){
                offset = Character.isUpperCase(cipher[i]) ? 'A' : 'a';
                cipher[i] -= offset;
                cipher[i] += shiftKey;
                cipher[i] %= 26;
                cipher[i] += offset;
            }
        }
        return new String(cipher);
    }

}

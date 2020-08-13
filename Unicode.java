package encryptdecrypt;

public class Unicode implements CryptoStrategy{

    @Override
    public char[] encrypt(char[] msg, int key) {
        for (int i = 0; i < msg.length; i++) {
            msg[i] += (char)key;
        }
        return  msg;
    }

    @Override
    public char[] decrypt(char[] msg, int key) {
        for (int i = 0; i < msg.length; i++) {
            msg[i] -= (char)key;
        }
        return  msg;
    }

}

package encryptdecrypt;

public class Shift implements CryptoStrategy{

    private final char[] lowercaseAlphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final char[] uppercaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Override
    public char[] encrypt(char[] msg, int key) {
        for (int i = 0; i < msg.length; i++) {
            int count = 0;
            if (Character.isUpperCase(msg[i])) {
                while (msg[i] != uppercaseAlphabet[count] && count < 25) {
                    count++;
                }
                if (msg[i] == uppercaseAlphabet[count]) {
                    if (count+key < 25) {
                        msg[i] = uppercaseAlphabet[count + key];
                    }
                    else {
                        msg[i] = uppercaseAlphabet[(count + key) % 26];
                    }
                }
            }
            if(Character.isLowerCase(msg[i])) {
                while (msg[i] != lowercaseAlphabet[count] && count < 25) {
                    count++;
                }
                if (msg[i] == lowercaseAlphabet[count]) {
                    if (count+key < 25) {
                        msg[i] = lowercaseAlphabet[count + key];
                    }
                    else {
                        msg[i] = lowercaseAlphabet[(count + key) % 26];
                    }
                }
            }
        }
        return msg;
    }

    @Override
    public char[] decrypt(char[] msg, int key) {
        for (int i = 0; i < msg.length; i++) {
            int count = 0;
            if (Character.isUpperCase(msg[i])) {
                while (msg[i] != uppercaseAlphabet[count] && count < 25) {
                    count++;
                }
                if (msg[i] == uppercaseAlphabet[count]) {
                    if (count-key >= 0) {
                        msg[i] = uppercaseAlphabet[count - key];
                    }
                    else {
                        msg[i] = uppercaseAlphabet[(count - key) + 26];
                    }
                }
            }
            if(Character.isLowerCase(msg[i])) {
                while (msg[i] != lowercaseAlphabet[count] && count < 25) {
                    count++;
                }
                if (msg[i] == lowercaseAlphabet[count]) {
                    if (count-key >= 0) {
                        msg[i] = lowercaseAlphabet[count - key];
                    }
                    else {
                        msg[i] = lowercaseAlphabet[(count - key) + 26];
                    }
                }
            }
        }
        return msg;
    }
}

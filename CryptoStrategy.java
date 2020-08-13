package encryptdecrypt;

public interface CryptoStrategy {

    char[] encrypt(char[] msg, int key);
    char[] decrypt(char[] msg, int key);
}

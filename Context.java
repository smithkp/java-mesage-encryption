package encryptdecrypt;

public class Context {
    private CryptoStrategy strategy;
    private char[] msg;
    private int key;

    public void setStrategy(CryptoStrategy strategy) {

        this.strategy = strategy;
    }

    public void setMessage(char[] msg) {
        this.msg = msg;
    }

    public void setKey(int key) {
        this.key = key;
    }


    public char[] encrypt() {
        return strategy.encrypt(msg,key);
    }

    public char[] decrypt() {
        return strategy.decrypt(msg,key);
    }
}

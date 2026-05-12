public class CaesarCipher {

    static String encrypt(String text, int shift) {
        String encrypt = "";
        for (int i = 0; i < text.length(); i++) {
            encrypt = text.charAt(i + shift);
        }
        return encrypt;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("hello", 3));

    }
}

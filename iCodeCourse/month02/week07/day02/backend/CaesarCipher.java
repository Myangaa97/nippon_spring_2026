public class CaesarCipher {

    static String encrypt(String text, int shift) {
        String encrypted = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            encrypted += (char) (c + shift);
        }
        return encrypted;
    }

    static String decrypt(String text, int shift) {
        String decrypted = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            decrypted += (char) (c - shift);
        }
        return decrypted;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("hello", 3));
        System.out.println(decrypt("khoor", 3));
    }
}

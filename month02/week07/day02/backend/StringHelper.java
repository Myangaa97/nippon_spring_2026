public class StringHelper {

    static String reverse(String text) {
        String reversed = "";
        for (int i = 0; i < text.length(); i++) {
            reversed = text.charAt(i) + reversed;
        }
        return reversed;
    }

    static boolean isPalindrome(String text) {
        boolean palindrome = true;
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                palindrome = false;
            }
        }

        if (palindrome)
            return true;
        return false;
    }

    static int countChar(String text, char sign) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == sign) {
                count++;
            }
        }
        return count;
    }

    static String repeat(String s, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += s;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse("Hello"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("hello"));
        System.out.println(countChar("programming", 'g'));
        System.out.println(repeat("ha", 5));
    }
}
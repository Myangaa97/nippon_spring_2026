package com.app;

public class StringUtils {
    public static String reverse(String greeting) {
        StringBuilder reversed = new StringBuilder();

        for (int i = greeting.length() - 1; i >= 0; i--) {
            reversed.append(greeting.charAt(i));
        }
        return reversed.toString();
    }

    public static int countVowels(String text) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPalindrome(String text) {
        boolean palindrome = true;
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                palindrome = false;
            }
        }
<<<<<<< HEAD
        if (palindrome)
            return true;
        return false;
=======
        return palindrome;
>>>>>>> 12a385a521493a3652251606f0821a392734a94f
    }

    public static String capitalize(String text) {
        return text.toUpperCase();
    }

}

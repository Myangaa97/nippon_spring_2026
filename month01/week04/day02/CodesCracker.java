import java.util.Scanner;

public class CodesCracker {
    public static void main(String[] args) {
        int ASCII;
        char ch;
        Scanner scan = new Scanner(System.in);

        System.out.println("ASCII\t\tCharacter");
        for (ASCII = 0; ASCII <= 255; ASCII++) {
            ch = (char) ASCII;
            System.out.println(ASCII + "\t\t" + ch);
        }

        scan.close();
    }
}
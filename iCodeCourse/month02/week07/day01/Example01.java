public class Example01 {
    static void printLune(String text) {
        System.out.println(text);
    }

    // Utga butsaadag
    static void aboutMe() {
        System.out.println("fuygigiugi");
        System.out.println("fuygigiugi");
        System.out.println("fuygigiugi");

    }

    static int square(int n) {
        return n * n;
    }

    static String stringConcat(String name) {
        return "Hello" + name;
    }

    static String repeat(String s, int times) {
        String result = "";
        for(int i = 0; i < times; i++) {
            result += s;
        }
        return result;
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        printLune("Hello");
        printLune("Test");

        int a = square(4);
        System.out.println(a);
        int b = square(15);
        System.out.println(b);
        System.out.println(square(16));

        System.out.println(stringConcat("dggkhdk"));
        System.out.println(stringConcat("gdkgk"));
        System.out.println(stringConcat("gdui"));

        aboutMe();
        aboutMe();
        aboutMe();

        System.out.println(repeat("* ", 15));
        System.out.println(isEven(5));

    }
}
public class Exe03 {
    static void greetUser(String name, int age) {
        System.out.println("Сайн уу, " + "! Та " + age + "настай байна.");
    }

    static double celsiusToFahrenheit(double c) {
        return (c * 9/5) + 32;
    }

    public static void main(String[] args) {
        greetUser("myangaa", 32);
        System.out.println(celsiusToFahrenheit(32));
    }
}

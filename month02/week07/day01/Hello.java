public class Hello {
    static void hello (String name) {
        System.out.println("=== Тавтай морилно уу ===");
        System.out.println("Хэрэглэгч: " + name);
        System.out.println("========================");
    }

    public static void main(String[] args) {

        hello("Батаа");
        hello("Eminem");
        hello("Jordan");
        hello("Ronaldo");
        hello("Ferguson");

        System.out.println("=== Тавтай морилно уу ===");
        System.out.println("Хэрэглэгч: Eminem");
        System.out.println("========================");
    }
}
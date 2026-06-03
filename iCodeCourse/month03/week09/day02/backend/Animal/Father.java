public class Father {
    private String name;
    private int age;

    public Father(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("My name is " + name + ". I am " + age + " years old.");
    }
}
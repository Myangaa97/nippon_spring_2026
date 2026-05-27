class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("Hello, My name is " + name + ".");
    }

    void showInfo() {
        System.out.println("My name is " + name + ". " + age + "years old.");
    }
}

public class Student {
    String name; // propirty
    int age;
    double gpa;

    Student(String name, int age, double gpa) {
        this.name = name; // constructor
        this.age = age;
        this.gpa = gpa;
    }

    public void printHello() {
        System.out.println("Hello Student");
    }

    public void introduceMyself() {
        System.out.println("My name is " + name + " and I'm " + age + "years old. I have a grade of " + gpa);
    }

    String nextYear() {
        return "jfdggkjh";
    }
}

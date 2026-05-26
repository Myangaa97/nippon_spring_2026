public class Student extends Person {
    String major;
    double gpa;

    public Student(String name, int age, String major, double gpa) {
        super(name, age);
        this.major = major;
        this.gpa = gpa;
    }

    @Override
    public void printInfo() {
        System.out
                .println("My name is " + getName() + ". I am " + getAge() + " years old. " + major + ". GPA : " + gpa);
    }

    boolean isHonors() {
        return true;
    }
}

class Person {
    void introduce() {
        System.out.println("I am a person");
    }
}

class Student extends Person {
    void introduce() {
        System.out.println("I am a student");
    }
}

public class PersonExte {
    public static void main(String[] args) {
        Student s = new Student();
        s.introduce();
    }
}

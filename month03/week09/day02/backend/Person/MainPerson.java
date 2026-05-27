public class MainPerson {
    public static void main(String[] args) {
        Person p1 = new Person("myangaa", 32);
        p1.introduce();

        Student s1 = new Student("Myangaa", 32, "Engineer", 2.7);
        s1.introduce();
        System.out.println(s1.isHonors());

        GraduateStudent g1 = new GraduateStudent("John", 35, "Doctor", 3.7, "High-impact");
        g1.introduce();
    }
}

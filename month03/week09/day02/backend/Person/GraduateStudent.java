public class GraduateStudent extends Student {
    String thesisTopic;

    public GraduateStudent(String name, int age, String major, double gpa, String thesisTopic) {
        super(name, age, major, gpa);
        this.thesisTopic = thesisTopic;
    }

    @Override
    public void introduce() {
        System.out.println("Диссертаци: " + thesisTopic);
    }
}

public class MainEmp {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", 28, "Google", 250000);
        Employee e2 = new Employee("Doe", 24, "Amazon", 25000);
        Manager m1 = new Manager("Phil", 44, "Amazon", 30000, 5);

        System.out.println("Employee 1");
        e1.showInfo();
        e1.introduce();
        e1.work();

        System.out.println();
        System.out.println("Employee 2");
        e2.work();

        System.out.println();
        System.out.println("Manager");
        m1.work();
        m1.showInfo();
    }
}
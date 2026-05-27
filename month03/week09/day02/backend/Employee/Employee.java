class Employee extends Person {
    String company;
    double salary;

    Employee(String name, int age, String company, double salary) {
        super(name, age);
        this.company = company;
        this.salary = salary;
    }

    void work() {
        System.out.println(name + "I worked " + company);
    }

    void getSalary() {
        System.out.printf("%s : Salary: %f", name, salary);
    }

    boolean earnsMore(Employee other) {
        return this.salary > other.salary;
    }

    @Override
    public void showInfo() {
        System.out.println("Company is " + company + " . Salary is " + salary);
    }

}

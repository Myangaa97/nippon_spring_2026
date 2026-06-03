class Manager extends Employee {
    int teamSize;

    Manager(String name, int age, String company, double salary, int teamSize) {
        super(name, age, company, salary);
        this.teamSize = teamSize;
    }

    void manage() {
        System.out.println("Team member is " + teamSize);
    }

    @Override
    public void showInfo() {
        System.out.println("My name is " + name + ". " + age + "years old. Team member is " + teamSize);
    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println("Class and Objects");
        Human myangaa = new Human();
        System.out.println(myangaa.firstName); // dot notation
        System.out.println(myangaa.lastName);
        System.out.println(myangaa.gender);
        System.out.println(myangaa.age);

        myangaa.gender = "male";
        myangaa.firstName = "Myangaa";
        myangaa.lastName = "Tugsbaatar";

        System.out.println(myangaa.firstName); // dot notation
        System.out.println(myangaa.lastName);
        System.out.println(myangaa.gender);
        System.out.println(myangaa.age);

        Animal cat = new Animal();
        cat.huis = "male";
        cat.nas = 5;
        cat.turul = "mammalia";

        // Animal
        System.out.println(cat.huis);
        System.out.println(cat.nas);
        System.out.println(cat.turul);

        //
        Child mychild = new Child("myangaa", 0);
        System.out.println(mychild.name);
        System.out.println(mychild.age);

        // Student
        Student abcStu = new Student("myangaa", 32, 3.2);
        System.out.println(abcStu.name);
        System.out.println(abcStu.age);
        System.out.println(abcStu.gpa);

        abcStu.printHello();
        abcStu.introduceMyself();
        System.out.println(abcStu.nextYear());

    }
}
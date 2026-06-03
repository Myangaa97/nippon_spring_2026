public class Main {
    public static void main(String[] args) {
        Father myFather = new Father("Tugsbaatar", 55);
        myFather.printInfo();

        Son mySon = new Son("Myangaa", 32);
        mySon.printInfo();

        Animal animal = new Animal(true, "female", "fat");
        animal.printInfo();

        Cat cat = new Cat(false, "male", "lazy");
        cat.printInfo();

        Bird bird = new Bird(true, "male", "fly");
        bird.printInfo();
        System.out.println(bird.iCanFly());
    }
}

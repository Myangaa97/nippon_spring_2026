public class Cat extends Animal {
    public Cat(boolean canRun, String gender, String race) {
        super(canRun, gender, race);
    }

    @Override
    public void printInfo() {
        System.out.println("Cat has gender of " + getGender() + " has " + getRace());
    }
}

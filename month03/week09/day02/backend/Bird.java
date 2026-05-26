public class Bird extends Animal {
    public Bird(boolean canRun, String gender, String race) {
        super(canRun, gender, race);
    }

    public boolean iCanFly() {
        return true;
    }

    @Override
    public void printInfo() {
        System.out.println("Bird can " + getRace() + " has a " + getGender());
    }
}

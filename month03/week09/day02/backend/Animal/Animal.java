public class Animal {
    private String race;
    private String gender;
    private boolean canRun;

    public Animal(boolean canRun, String gender, String race) {
        this.canRun = canRun;
        this.gender = gender;
        this.race = race;
    }

    public void printInfo() {
        String runnable;
        if (canRun) {
            runnable = "runnable";
        } else {
            runnable = "not runnable";
        }
        System.out.println("This animal is race of " + race + " and is " + gender + " animal. Animal is " + runnable);
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }
}

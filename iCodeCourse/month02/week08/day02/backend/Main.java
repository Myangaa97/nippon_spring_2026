public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 3);
        Rectangle r2 = new Rectangle(4, 4);
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(3);
        StudentTracker s1 = new StudentTracker("John", 100, 90, 80, 70, 60);
        StudentTracker s2 = new StudentTracker("Wick", 95, 85, 75, 65, 55);
        StudentTracker s3 = new StudentTracker("Dann", 90, 85, 80, 75, 70);

        System.out.println("----- Rectangle -----");
        r1.showInfo();
        System.out.println(r2.isSquare());

        System.out.println("----- Circle -----");
        c1.showInfo();
        System.out.println(c1.isLarger(c2));

        System.out.println("----- Student Tracker -----");
        s1.showReport();
        s2.showReport();
        s3.showReport();

        StudentTracker best = s1;

        if (s2.maxGpa() > best.maxGpa()) {
            best = s2;
        }

        if (s3.maxGpa() > best.maxGpa()) {
            best = s3;
        }

        System.out.println("Хамгийн өндөр GPA-тай: " + best.name);
        System.out.println("GPA: " + best.maxGpa());
    }

}

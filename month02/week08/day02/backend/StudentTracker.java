public class StudentTracker {
    String name;
    int[] gpa = new int[5];

    StudentTracker(String name, int s1, int s2, int s3, int s4, int s5) {
        this.name = name;
        gpa[0] = s1;
        gpa[1] = s2;
        gpa[2] = s3;
        gpa[3] = s4;
        gpa[4] = s5;
    }

    int average() {
        int sum = 0;
        for (int i = 0; i < gpa.length; i++) {
            sum = sum + gpa[i];
        }
        return sum / gpa.length;
    }

    void gpa() {
        String gpad;
        for (int i = 0; i < gpa.length; i++) {
            if (gpa[i] >= 90) {
                gpad = "4.0";
            } else if (gpa[i] >= 80) {
                gpad = "3.0";
            } else if (gpa[i] >= 70) {
                gpad = "2.0";
            } else {
                gpad = "1.0";
            }
            System.out.printf(gpa[i] + " : " + gpad + ", ");
        }
    }

    void grade() {
        for (int i = 0; i < gpa.length; i++) {

            int n = gpa[i] / 10;

            String graded = switch (n) {
                case 10, 9 -> "A";
                case 8 -> "B";
                case 7 -> "C";
                case 6 -> "D";
                default -> "F";
            };

            System.out.printf(gpa[i] + " : " + graded + ", ");
        }
    }

    int maxGpa() {
        int max = 0;
        for (int i = 0; i < gpa.length; i++) {
            if (gpa[i] > max) {
                max = gpa[i];
            }
        }
        return max;
    }

    public void showReport() {
        System.out.println(name);
        System.out.println("Дундаж: " + average());
        grade();
        System.out.println();
        gpa();
        System.out.println();
        System.out.println("========================================\n");
    }

}
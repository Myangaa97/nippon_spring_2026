public class StudentSystem {
    public static void main(String[] args) {
        int[][] scores = {
                { 85, 90, 78 }, // Батаа
                { 92, 88, 95 }, // Сараа
                { 70, 65, 80 }, // Дорж
                { 96, 91, 89 }, // Нарaa
                { 55, 60, 72 } // Болд
        };

        String[] students = { "Батаа", "Сараа", "Дорж", "Нарaa", "Болд" };

        double[] stuAverages = new double[scores.length];

        for (int i = 0; i < scores.length; i++) {
            int eachSum = 0;
            for (int j = 0; j < scores[i].length; j++) {
                eachSum += scores[i][j];
            }

            stuAverages[i] = (double) eachSum / scores[i].length;
        }

        System.out.println("===== Дүнгийн Тайлан =====");

        for (int i = 0; i < students.length; i++) {

            int level = (int) stuAverages[i];
            int n = level / 10;
            String grade = switch (n) {
                case 10, 9 -> "A";
                case 8 -> "B";
                case 7 -> "C";
                case 6 -> "D";
                default -> "F";
            };

            String result;

            if (level > 60) {
                result = grade + " | Тэнцсэн";
            } else {
                result = grade + " | Тэнцээгүй";
            }

            System.out.printf("%s | %.1f | %s\n", students[i], stuAverages[i], result);
        }

        System.out.println("==========================");

        int maxIndex = 0;
        double totalSum = 0;
        double max = stuAverages[0];
        for (int i = 0; i < stuAverages.length; i++) {
            totalSum += stuAverages[i];
            if (stuAverages[i] > max) {
                max = stuAverages[i];
                maxIndex = i;
            }
        }
        double totalAverages = totalSum / stuAverages.length;
        System.out.printf("Ангийн дундаж: %.1f\n", totalAverages);
        System.out.printf("Шилдэг оюутан: %s (%.1f)", students[maxIndex], stuAverages[maxIndex]);
    }
}
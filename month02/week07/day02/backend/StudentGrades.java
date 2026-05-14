public class StudentGrades {
    static String[] letterGrade(int[] score) {
        String[] stuScores = new String[score.length];

        for (int i = 0; i < score.length; i++) {
            int n = score[i] / 10;
            String grade = switch (n) {
                case 10, 9 -> "A";
                case 8 -> "B";
                case 7 -> "C";
                case 6 -> "D";
                default -> "F";
            };
            stuScores[i] = grade;
        }
        return stuScores;
    }

    static double classAverage(int[] score) {
        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }
        return sum / score.length;
    }

    static int topScore(int[] score) {
        int max = 0;
        for (int i = 0; i < score.length; i++) {
            if (max < score[i]) {
                max = score[i];
            }
        }
        return max;
    }

    static int countPassing(int[] score) {
        int count = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] > 60) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("===== Оюутны Дүн =====");
        int[] nums = { 1, 2, 3, 4, 5 };
        int[] score = { 85, 92, 67, 78, 55 };

        String[] grades = letterGrade(score);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + ". " + score[i] + " -> " + grades[i]);
        }

        System.out.printf("Дундаж: %.2f\n", classAverage(score));
        System.out.println("Хамгийн өндөр: " + topScore(score));
        System.out.println("Тэнцсэн: " + countPassing(score) + " / " + score.length);
        System.out.println("======================");
    }
}

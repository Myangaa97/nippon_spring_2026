public class FiveFive {
    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 17, 8, 22, 5 },
                { 11, 6, 30, 4, 19 },
                { 25, 2, 13, 28, 7 },
                { 9, 21, 1, 16, 24 },
                { 18, 10, 27, 14, 20 }
        };
        int count = 0;
        int max = matrix[0][0];
        int min = matrix[0][0];
        int maxRow = 0, maxCol = 0;
        int minRow = 0, minCol = 0;
        int[] rowSum = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                rowSum[i] += matrix[i][j];

                System.out.print(matrix[i][j] + "\t");

                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }

                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
            System.out.println();
        }
        int totalSum = 0;
        for (int sum : rowSum) {
            totalSum += sum;
        }

        int average = totalSum / rowSum.length;

        System.out.println("Нийт нийлбэр: " + totalSum);
        System.out.println("Дундаж: " + average);
        System.out.println("Хамгийн том: " + max + " Байршил: [" + maxRow + "][" + maxCol + "]");
        System.out.println("Хамгийн жижиг: " + min + " Байршил: [" + minRow + "][" + minCol + "]");

        int dSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            dSum += matrix[i][i];
        }
        System.out.println("Үндсэн диагональ нийлбэр: " + dSum);

        for (int i = 0; i < rowSum.length; i++) {
            System.out.println((i + 1) + "-р мөрийн нийлбэр: " + rowSum[i]);
        }

        System.out.printf("Анхны тоонууд: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] >= 2) {
                    count = 0;
                    for (int a = 2; a < matrix[i][j]; a++) {
                        if (matrix[i][j] % a == 0) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.printf(matrix[i][j] + " ");
                    }
                }
            }
        }
    }
}

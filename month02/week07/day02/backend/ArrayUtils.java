public class ArrayUtils {
    static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    static int max(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    static double average(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum / arr.length;
    }

    static int[] printArray() {
        int[] data = { 3, 7, 2, 9, 1 };
        return data;
    }

    static int count(int[] arr, int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 7, 2, 9, 1 };
        System.out.printf("Массив: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.printf("]\n");
        System.out.println("Sum: " + sum(arr));
        System.out.println("Max: " + max(arr));
        System.out.println("Min: " + min(arr));
        System.out.println("Average: " + average(arr));
        System.out.println("Count of 3: " + count(arr, 3));
    }
}

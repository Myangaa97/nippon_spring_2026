public class ArrayTransformer {

    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
    }

    static int[] reverse(int[] arr) {
        int[] newArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[arr.length - 1 - i];
        }
        return newArray;
    }

    static int[] filter(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                count += 1;
        }

        int[] newArray = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                newArray[index++] = arr[i];
            }
        }
        return newArray;

    }

    static int[] multiplyBy(int[] arr, int factor) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * factor;
        }
        return arr;
    }

    static int[] multiply(int[] arr, int factor) {
        int[] newArray = new int[arr.length];
        int index = 0;
        for (int n : arr) {
            n = n * factor;
            newArray[index++] = n;
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 3, 7, 2, 9, 5 };

        printArray(arr1);
        printArray(arr2);
        printArray(reverse(arr1));
        printArray(filter(arr1));
        printArray(multiplyBy(arr1, 3));
        printArray(multiply(arr1, 5));

    }
}

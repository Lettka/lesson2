package homework;

import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {

        //1
        int[] array1 = {1, 1, 0, 1, 1};
        System.out.println("task1\narray = " + Arrays.toString(array1));
        System.out.println("inverted array = " + Arrays.toString(reverseArray(array1)));

        //2
        int[] array2 = new int[8];
        fillArray(array2);
        System.out.println("\ntask2\n" + Arrays.toString(array2));

        //3
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("\ntask3\narray3 = " + Arrays.toString(array3));
        multiplyLessThanSix(array3);
        System.out.println("result = " + Arrays.toString(array3));

        //4
        System.out.println("\ntask4\narray3 = " + Arrays.toString(array3));
        System.out.println("max = " + findMax(array3) + "\tmin = " + findMin(array3));

        //5
        int[] array5 = {10, 1, 2, 2, 1, 2, 2, 2};
        System.out.println("\ntask5\n" + Arrays.toString(array5));
        System.out.println(checkBalance(array5));

        //6
        int[] array6 = {3, 5, 6, 1, 4, 0, 2, 7};
        int n = -7;
        System.out.println("\ntask6\n" + Arrays.toString(array6));
        displaceElements(array6, n);
        System.out.println("step = " + n + "\n" + Arrays.toString(array6));
    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static int[] reverseArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 1 ? 0 : 1;
        }
        return arr;
    }

    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void multiplyLessThanSix(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 6;
            }
        }
    }

    //4. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    //5. *** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.

    public static boolean checkBalance(int[] arr) {
        int sumLeft = arr[0];
        int sumRight = arr[arr.length - 1];
        for (int i = 1, j = arr.length - 2; i <= j; ) {
            if (sumLeft < sumRight) {
                sumLeft += arr[i];
                i++;
            } else {
                sumRight += arr[j];
                j--;
            }
        }
        return sumLeft == sumRight;
    }

    //6. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    // или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    // Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.

    public static void displaceElements(int[] arr, int n) {
        for (int i = n < 0 ? -n : arr.length - n; i != 0; i--) {
            int temp = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = temp;
        }
    }

}

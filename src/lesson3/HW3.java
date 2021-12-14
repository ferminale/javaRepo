package lesson3;

import java.util.Random;
import java.util.Scanner;

public class HW3 {

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {

        array01();
        System.out.println("__________________________");
        myArray100();
        System.out.println("__________________________");
        myArray6();
        System.out.println("__________________________");
        myArraySquare();
        System.out.println("__________________________");
        myArray2args(10, 24);
        System.out.println("__________________________");
        myArrayMinMax();
        System.out.println("__________________________");
    }

    public static void array01() {
        int[] myArray = new int[10];

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = random.nextInt(2);
        }
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " | ");
        }

        System.out.println();
        System.out.println(" Result 0 -> 1 ");

        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == 1) {
                myArray[i] = 0;
            } else {
                myArray[i] = 1;
            }
        }
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " | ");

        }
        System.out.println();
    }

    public static void myArray100() {
        int[] myArray1 = new int[100];

        for (int i = 0; i < myArray1.length; i++) {
            myArray1[i] = i + 1;
        }
        for (int i = 0; i < myArray1.length; i++) {
            System.out.print(myArray1[i] + " | ");
        }
        System.out.println();
    }

    public static void myArray6() {
        int[] myArray2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < myArray2.length; i++) {
            if (myArray2[i] < 6) myArray2[i] *= 2;
        }
        for (int i = 0; i < myArray2.length; i++) {
            System.out.print(myArray2[i] + " | ");
        }
        System.out.println();
    }

    public static void myArraySquare() {
        int[][] myArray3 = new int[8][8];
        System.out.println("Before:");
        for (int i = 0; i < myArray3.length; i++) {
            for (int j = 0; j < myArray3[i].length; j++) {
                myArray3[i][j] = 0;
            }
        }
        for (int[] anArr : myArray3) {
            for (int anAnArr : anArr) {
                System.out.print(anAnArr + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("After:");
        for (int i = 0; i < myArray3.length; i++) {
            myArray3[i][i] = 1;
            myArray3[i][myArray3.length - 1 - i] = 1;

        }
        for (int[] anArr : myArray3) {
            for (int anAnArr : anArr) {
                System.out.print(anAnArr + " ");
            }
            System.out.println();
        }
    }

    public static void myArray2args(int len, int initialValue) {
        int[] myArray1st = new int[len];
        for (int i = 0; i < myArray1st.length; i++) {
            myArray1st[i] = initialValue;
        }
        for (int i = 0; i < myArray1st.length; i++) {
            System.out.print(myArray1st[i] + " | ");
        }
        System.out.println();
    }

    public static void myArrayMinMax() {
        int[] myArray5 = new int[10];

        for (int i = 0; i < myArray5.length; i++) {
            myArray5[i] = random.nextInt(10);
        }
        for (int i = 0; i < myArray5.length; i++) {
            System.out.print(myArray5[i] + " | ");
        }
        int min = myArray5[0];
        for (int i = 0; i < myArray5.length; i++) {
            if (myArray5[i] < min) {
                min = myArray5[i];
            }

        }
        System.out.println();
        System.out.println("Минимальное значение = " + min);

        int max = myArray5[0];
        for (int i = 0; i < myArray5.length; i++) {
            if (myArray5[i] > max) {
                max = myArray5[i];
            }

        }
        System.out.println("Максимальное значение = " + max);
        System.out.println();
    }
}
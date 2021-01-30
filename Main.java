package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static <T> void swap(int i, int j, T[] a) {
        T exchange = a[i];

        a[i] = a[j];
        a[j] = exchange;
    }

    private static <T> void shuffleArray(T[] a) {
        Random random = new Random();
        for(int i = 0; i < a.length; i++) {
            int randomInt = random.nextInt(a.length - 1);
            swap(i, randomInt, a);
        }
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (a[lo].compareTo(a[++i]) > 0)
                if (i == hi) break;

            while (a[lo].compareTo(a[--j]) < 0)
                if (j == lo) break;

            if(i >= j) break;
            swap(i, j, a);
        }

        swap(lo, j, a);
        return j;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void main(String[] args) {
        String[] testArray = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

        shuffleArray(testArray);
        System.out.println(Arrays.toString(testArray));

        sort(testArray, 0, testArray.length - 1);

        System.out.println(Arrays.toString(testArray));
    }
}

package com.github.n1ay.sorting;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by kamil on 08.06.17.
 */
public class MainApp {
    public static void main(String[] args) {

        Comparator<Integer> integerComparator = (o1, o2) -> {
          if(o1 > o2)
              return 1;
          else if (o1.intValue() == o2.intValue())
              return  0;
          else return -1;
        };

        Integer[] array = initIntArray(3000000);
        SortTimer<Integer> sortTimer = new SortTimer<>();
        //printArray(array);

        /*sortTimer.measure(new BubbleSort<>(), array, integerComparator);
        sortTimer.measure(new SelectionSort<>(), array, integerComparator);
        sortTimer.measure(new InsertionSort<>(), array, integerComparator);
        sortTimer.measure(new MergeSort<>(), array, integerComparator);
        */sortTimer.measure(new QuickSort<>(), array, integerComparator);
        //sortTimer.measure(new HeapSort<>(), array, integerComparator);
        //sortTimer.measure(new CountingSort<>(), array, integerComparator);
        sortTimer.measure(new IterativeQuickSort<>(), array, integerComparator);
        sortTimer.measure(new IterativeMergeSort<>(), array, integerComparator);
    }

    public static Integer[] initIntArray(int length) {
        Random random = new Random();
        Integer[] array = new Integer [length];
        for(int i=0; i<length; i++)
            array[i] = random.nextInt(length*2);

        return array;
    }

    public static void check(Integer[] array, String method) {
        for(int i=0; i<array.length-1; i++)
            if(array[i]>array[i+1]) {
                System.out.println(method+" check error");
                return;
            }
    }

    public static void printArray(Integer[] array) {
        for(Integer i: array)
            System.out.print(i+" ");
        System.out.println();
    }
}

package com.github.n1ay.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kamil on 09.06.17.
 */
public class QuickSort<T> implements Sorter<T> {

    private Comparator<T> comparator;

    @Override
    public T[] sort(T[] array, Comparator<T> comparator) {
        T[] result = Arrays.copyOf(array, array.length);
        this.comparator = comparator;
        divide(result, 0, array.length-1);
        return result;
    }

    private void divide(T[] array, int from, int to) {
        if (to - from >= 2) {
            T pivot = array[to];
            int i = from, j = from;
            while (i < to) {
                while (i < to && comparator.compare(array[i], pivot) > 0)
                    i++;
                T tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                j++;
                i++;
            }
            array[to] = array[j];
            array[j] = pivot;
            if (j - 1 - from > 1)
                divide(array, from, j - 1);
            else if (j - 1 - from == 1)
                swapSort(array, from, j - 1);
            if (to - j - 1 > 1)
                divide(array, j + 1, to);
            else if (to - j - 1 == 1)
                swapSort(array, j + 1, to);
        }
    }
    private void swapSort(T[] array, int index1, int index2) {
        if(comparator.compare(array[index1], array[index2]) > 0) {
            T tmp = array[index1];
            array[index1] = array[index2];
            array[index2] = tmp;
        }
    }
}
package com.github.n1ay.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

/**
 * Created by kamil on 13.06.17.
 */
public class IterativeMergeSort<T> implements Sorter<T> {
    Comparator<T> comparator;

    @Override
    public T[] sort(T[] array, Comparator<T> comparator) {
        this.comparator = comparator;
        T[] result = Arrays.copyOf(array, array.length);
        T[] resultTmp = Arrays.copyOf(array, array.length);
        if(result.length > 2) {
            if(result.length%2 == 0) {
                for (int i = 0; i < result.length - 1; i += 2)
                    swapSort(resultTmp, i, i + 1);
                //TODO:
            } else {
                for (int i = 0; i < result.length - 2; i += 2)
                    swapSort(resultTmp, i, i + 1);
                //TODO:
            }
            return result;
        } else if (result.length == 2) {
            swapSort(result, 0, 1);
        }
        return result;
    }

    private void merge(T[] array, int from, int to) {
        //TODO:
    }


    private void swapSort(T[] array, int index1, int index2) {
        if(comparator.compare(array[index1], array[index2]) > 0) {
            T tmp = array[index1];
            array[index1] = array[index2];
            array[index2] = tmp;
        }
    }
}

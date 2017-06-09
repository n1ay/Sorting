package com.github.n1ay.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kamil on 08.06.17.
 */
public class SelectionSort<T> implements Sorter<T> {
    @Override
    public T[] sort(T[] array, Comparator<T> comparator) {
        T[] result= Arrays.copyOf(array, array.length);
        T max = result[0];
        int maxIndex = 0;
        for(int i=0; i<result.length; i++) {
            for(int j=0; j<result.length-i; j++)
                if(comparator.compare(result[j], max) > 0) {
                    max = result[j];
                    maxIndex = j;
                }
            T tmp = result[result.length-i-1];
            result[result.length-i-1] = max;
            result[maxIndex] = tmp;
            max = result[0];
            maxIndex = 0;
        }
        return result;
    }
}

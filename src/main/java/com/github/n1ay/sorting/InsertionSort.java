package com.github.n1ay.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kamil on 08.06.17.
 */
public class InsertionSort<T> implements Sorter<T> {
    @Override
    public T[] sort(T[] array, Comparator<T> comparator) {
        T[] result= Arrays.copyOf(array, array.length);
        int j;
        for(int i=1; i<result.length; i++) {
            j=i-1;
            T tmp = result[i];
            while(j >= 0 && comparator.compare(tmp, result[j]) < 0) {
                result[j+1] = result[j];
                j--;
            }
            result[j+1]=tmp;
        }
        return result;
    }
}

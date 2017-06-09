package com.github.n1ay.sorting;

import java.util.Comparator;
import java.util.Arrays;

/**
 * Created by kamil on 08.06.17.
 */
public class BubbleSort<T> implements Sorter<T> {

    @Override
    public T[] sort(T[] array, Comparator<T> comparator) {
        T[] result=Arrays.copyOf(array, array.length);
        for(int i=0; i<result.length; i++) {
            for(int j=0; j<result.length-1-i; j++)
                if(comparator.compare(result[j], result[j+1]) > 0) {
                    T tmp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = tmp;
                }
        }
        return result;
    }
}

package com.github.n1ay.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

/**
 * Created by kamil on 08.06.17.
 */
public class MergeSort<T> implements Sorter<T> {

    Comparator<T> comparator;

    @Override
    public T[] sort(T[] array, Comparator<T> comparator) {
        this.comparator = comparator;
        T[] result = Arrays.copyOf(array, array.length);
        Vector<T[]> vec, vec2 = new Vector<>(2);
        if(result.length > 2) {
            vec = divide(result);
            T[] arr1 = sort(vec.elementAt(0), comparator);
            T[] arr2 = sort(vec.elementAt(1), comparator);
            return merge(arr1, arr2);
        } else if (result.length == 2) {
            if (comparator.compare(result[0], result[1]) > 0) {
                T tmp = result[0];
                result[0] = result[1];
                result[1] = tmp;
            }
        }
        return result;
    }

    private Vector<T[]> divide(T[] array) {
        T[] result1, result2;
        int middle = array.length/2;
        result1 = Arrays.copyOfRange(array, 0, middle);
        result2 = Arrays.copyOfRange(array, middle, array.length);

        Vector<T[]> vector = new Vector<>(2);
        vector.add(result1);
        vector.add(result2);

        return vector;
    }

    private T[] merge(T[] array1, T[] array2) {
        T[] result = (T[])Array.newInstance(array1.getClass().getComponentType(), array1.length+array2.length);
        int i=0, j=0;
        while(i<array1.length && j<array2.length) {
            if (comparator.compare(array1[i], array2[j]) > 0) {
                result[i+j] = array2[j];
                j++;
            } else {
                result[i+j] = array1[i];
                i++;
            }
        }
        while(i<array1.length) {
            result[i+j] = array1[i];
            i++;
        }
        while(j<array2.length) {
            result[i+j] = array2[j];
            j++;
        }

        return result;
    }
}

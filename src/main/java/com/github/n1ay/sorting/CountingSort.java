package com.github.n1ay.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kamil on 09.06.17.
 */
public class CountingSort<T extends Integer> implements Sorter<T> {
    @Override
    public T[] sort(T[] array, Comparator<T> comparator) {
        T[] result = Arrays.copyOf(array, array.length);
        T min = result[0];
        T max = result[0];
        for (T t : result) {
            if (comparator.compare(t, max) > 0)
                max = t;
            else if (comparator.compare(t, min) < 0)
                min = t;
        }
        int range = max.intValue() - min.intValue() + 1;
        int[] counter = new int[range];
        for (T t : result) {
            counter[t.intValue()-min.intValue()]++;
        }
        int j = 0;
        for (int i = 0; i < result.length;) {
            while (counter[j] > 0) {
                result[i] = (T)new Integer(j+min.intValue());
                counter[j]--;
                i++;
            }
            while(j<counter.length && counter[j] == 0)
                j++;
        }

        return result;
    }
}

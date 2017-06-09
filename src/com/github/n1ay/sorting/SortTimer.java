package com.github.n1ay.sorting;

import java.util.Comparator;

/**
 * Created by kamil on 08.06.17.
 */
public class SortTimer<T> implements Sorter<T> {

    Sorter<T> sorter = null;

    @Override
    public T[] sort(T[] array, Comparator<T> comparator) {
        return sorter.sort(array, comparator);
    }

    public void measure(Sorter<T> sorter, T[] array, Comparator<T> comparator) {
        this.sorter = sorter;
        long time1 = System.currentTimeMillis();
        this.sort(array, comparator);
        long time2 = System.currentTimeMillis();
        System.out.println(sorter.getClass().getName() + " " + (time2 - time1));
    }
}

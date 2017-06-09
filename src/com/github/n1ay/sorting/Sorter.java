package com.github.n1ay.sorting;

import java.util.Comparator;

/**
 * Created by kamil on 08.06.17.
 */
public interface Sorter<T> {
    T[] sort(T[] array, Comparator<T> comparator);
}

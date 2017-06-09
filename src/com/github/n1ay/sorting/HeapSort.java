package com.github.n1ay.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kamil on 09.06.17.
 */
public class HeapSort<T> implements Sorter<T> {

    private Comparator<T> comparator;

    @Override
    public T[] sort(T[] array, Comparator<T> comparator) {
        this.comparator = comparator;
        T[] result = Arrays.copyOf(array, array.length);
        buildHeap(result);
        for(int i=result.length-1; i>0; i--) {
            T tmp = result[0];
            result[0] = result[i];
            result[i] = tmp;
            heapify(result, 0, i-1);
        }
        return result;
    }

    private void buildHeap(T[] array) {
        int i=array.length-1;
        while(i > 0) {
            int p = getParentIndex(i);
            int c = getChild(p);
            //child with greater value
            int gc = c;
            if(c + 1 < array.length) {
                if(comparator.compare(array[c], array[c+1]) < 0)
                    gc = c+1;
            }
            if(comparator.compare(array[gc], array[p]) > 0) {
                T tmp = array[gc];
                array[gc] = array[p];
                array[p] = tmp;
                heapify(array, gc, array.length-1);
            }
            i=c-1;
        }
    }

    private void heapify(T[] array, int index, int last) {
        int c = getChild(index);
        //child with greater value
        int gc = c;
        if(c + 1 <= last) {
            if (comparator.compare(array[c], array[c+1]) < 0)
                gc = c+1;
            if (comparator.compare(array[index], array[gc]) < 0) {
                T tmp = array[index];
                array[index] = array[gc];
                array[gc] = tmp;
                heapify(array, gc, last);
            }
        }
        else if(c == last) {
            if (comparator.compare(array[index], array[c]) < 0) {
                T tmp = array[index];
                array[index] = array[c];
                array[c] = tmp;
            }
        }
    }

    private int getParentIndex(int index) {
        return (index-1)/2;
    }

    private int getChild(int index) {
        return index*2 + 1;
    }
}

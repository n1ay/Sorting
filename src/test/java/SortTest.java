import com.github.n1ay.sorting.*;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

/**
 * Created by kamil on 13.06.17.
 */

//all classes should have their own test class
public class SortTest {

    @Test
    public void testBubbleSort() {
         Integer[] array = TestUtils.initIntArray(10000);
         assertEquals(TestUtils.checkIfSorted(new BubbleSort<Integer>().sort(array, TestUtils.integerComparator)), true);
    }

    @Test
    public void testCountingSort() {
        Integer[] array = TestUtils.initIntArray(10000);
        assertEquals(TestUtils.checkIfSorted(new CountingSort<Integer>().sort(array, TestUtils.integerComparator)), true);
    }

    @Test
    public void testHeapSort() {
        Integer[] array = TestUtils.initIntArray(10000);
        assertEquals(TestUtils.checkIfSorted(new HeapSort<Integer>().sort(array, TestUtils.integerComparator)), true);
    }

    @Test
    public void testInsertingSort() {
        Integer[] array = TestUtils.initIntArray(10000);
        assertEquals(TestUtils.checkIfSorted(new InsertionSort<Integer>().sort(array, TestUtils.integerComparator)), true);
    }

    @Test
    public void testMergeSort() {
        Integer[] array = TestUtils.initIntArray(10000);
        assertEquals(TestUtils.checkIfSorted(new MergeSort<Integer>().sort(array, TestUtils.integerComparator)), true);
    }

    @Test
    public void testQuickSort() {
        Integer[] array = TestUtils.initIntArray(10000);
        assertEquals(TestUtils.checkIfSorted(new QuickSort<Integer>().sort(array, TestUtils.integerComparator)), true);
    }

    @Test
    public void testSelectionSort() {
        Integer[] array = TestUtils.initIntArray(10000);
        assertEquals(TestUtils.checkIfSorted(new SelectionSort<Integer>().sort(array, TestUtils.integerComparator)), true);
    }

    @Test
    public void testIterativeQuickSort() {
        Integer[] array = TestUtils.initIntArray(10000);
        assertEquals(TestUtils.checkIfSorted(new IterativeQuickSort<Integer>().sort(array, TestUtils.integerComparator)), true);
    }

    @Test
    public void testIterativeMergeSort() {
        Integer[] array = TestUtils.initIntArray(10000);
        assertEquals(TestUtils.checkIfSorted(new IterativeMergeSort<Integer>().sort(array, TestUtils.integerComparator)), true);
    }

}

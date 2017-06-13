import java.util.Comparator;
import java.util.Random;

/**
 * Created by kamil on 13.06.17.
 */
public class TestUtils {
    public static Comparator<Integer> integerComparator = (o1, o2) -> {
        if(o1 > o2)
            return 1;
        else if (o1 == o2)
            return 0;
        else
            return -1;
    };

    public static boolean checkIfSorted(Integer[] array) {
        for(int i=0; i<array.length-1; i++) {
            if(array[i] > array[i+1])
                return false;
        }
        return true;
    }

    public static Integer[] initIntArray(int length) {
        Integer[] result = new Integer [length];
        for(int i=0; i<length; i++)
            result[i] = new Integer(new Random().nextInt(length*2));

        return result;
    }
}

package main.java.arrays.two_d_array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sort2Arrays {
    /**
     * Create custom objects (your WtVal class)
     * Idea:
     * Group related values into objects (e.g., wt and val), sort them directly using a comparator.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] val = {50, 10, 40, 70};
        int[] wt = {4, 1, 3, 5};
        class WtVal {
            int wt;
            int val;

            public int getWt() {
                return wt;
            }

            @Override
            public String toString() {
                return "WtVal{" + "wt=" + wt + ", val=" + val +'}';
            }
        }
        WtVal[] array = new WtVal[val.length];
        for (int i = 0; i < val.length; i++) {
            WtVal wv = new WtVal();
            wv.wt = wt[i];
            wv.val = val[i];
            array[i] = wv;
        }
        List<WtVal> wtList = Arrays.stream(array).sorted(Comparator.comparing(x -> x.val / x.wt)).collect(Collectors.toList());
        System.out.println(wtList.toString());
    }

    /**
     * Sorting using indices
     * Idea:
     * Keep the original arrays, create an index array, sort indices based on a[i], then rearrange the arrays.
     */
    public static void indexBasedSorting() {

        int[] a = {5, 2, 9, 1};
        int[] b = {50, 20, 90, 10};

        // Create an array of indices
        Integer[] indices = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            indices[i] = i;
        }

        // Sort indices based on corresponding values in a
        Arrays.sort(indices, (i, j) -> Integer.compare(a[i], a[j]));

        // Create sorted arrays
        int[] sortedA = new int[a.length];
        int[] sortedB = new int[b.length];
        for (int i = 0; i < a.length; i++) {
            sortedA[i] = a[indices[i]];
            sortedB[i] = b[indices[i]];
        }

        // Print results
        System.out.println("Sorted a: " + Arrays.toString(sortedA));
        System.out.println("Sorted b: " + Arrays.toString(sortedB));

    }
}

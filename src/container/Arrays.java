package container;

import java.util.Random;

/**
 * This class contains several methods for manipulating arrays.
 */
@SuppressWarnings("unchecked")
public class Arrays {

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * Sort the specific comparable array into ascending order using selection sort.
     * @param a The array to be sorted.
     */
    public static void selectionSort(Comparable[] a) {
        for (int i = 0, n = a.length; i < n; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (a[j].compareTo(a[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
    }


    /**
     * Sort the specific comparable array into ascending order using bubble sort.
     * @param a The array to be sorted.
     */
    public static void bubbleSort(Comparable[] a) {
        for (int j = a.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (a[i].compareTo(a[i+1]) > 0) {
                    swap(a, i, i+1);
                }
            }
        }
    }


    /**
     * Sort the specific comparable array into ascending order using insertion sort.
     * @param a The array to be sorted.
     */
    public static void insertionSort(Comparable[] a) {
        for (int i = 1, n = a.length; i < n; i++) {
            int j = i - 1;
            Comparable insert = a[i];
            while (j >= 0 && insert.compareTo(a[j]) <= 0) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = insert;
        }
    }


    private static Comparable[] aux;
    /**
     * Sort the specific comparable array into ascending order using merge sort.
     * @param a The array to be sorted.
     */
    public static void mergeSort(Comparable[] a) {
        aux = new Comparable[a.length];
        mergeSort(a, 0, a.length - 1);
    }
    private static void mergeSort(Comparable[] a, int fromIndex, int toIndex) {
        if (fromIndex >= toIndex) {
            return;
        }
        int midIndex = fromIndex + (toIndex - fromIndex) / 2;
        mergeSort(a, fromIndex, midIndex);
        mergeSort(a, midIndex+1, toIndex);
        merge(a, fromIndex, midIndex, toIndex);
    }
    private static void merge(Comparable[] a, int fromIndex, int midIndex, int toIndex) {
        int i = fromIndex;
        int j = midIndex + 1;
        // shallow copy of array
        for (int k = fromIndex; k <= toIndex; k++) {
            aux[k] = a[k];
        }
        // merge to the original array.
        for (int k = fromIndex; k <= toIndex; k++) {
            if (i > midIndex) {
                a[k] = aux[j++];
            } else if (j > toIndex) {
                a[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) <= 0) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }


    private static Random r;
    /**
     * Sort the speicific array into ascending order using quick sort.
     * @param a The array to be sorted.
     */
    public static void quickSort(Comparable[] a) {
        r = new Random();
        quickSort(a, 0, a.length - 1);
    }
    private static void quickSort(Comparable[] a, int fromIndex, int toIndex) {
        if (toIndex > fromIndex) {
            int pivotIndex = partition(a, fromIndex, toIndex);
            quickSort(a, fromIndex, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, toIndex);
        }
    }
    private static int partition(Comparable[] a, int fromIndex, int toIndex) {
        // choose the pivot randomly.
        int rIndex = fromIndex + r.nextInt(toIndex - fromIndex + 1);
        swap(a, rIndex, toIndex);
        // partition in place.
        Comparable pivot = a[toIndex];
        int p = fromIndex;  // pivot index
        for (int i = fromIndex; i <= toIndex; i++) {
            // item from left of the pivot is always no larger than pivot
            if (a[i].compareTo(pivot) <= 0) {
                swap(a, p, i);
                p++;
            }
        }
        return p - 1;
    }


    /**
     * Returns a string representation of the elements in the array.
     * @param a The array whose string representation returns
     * @return String representation of a.
     */
    public static String toString (Object[] a) {
        if (a == null) {  return "null";  }
        StringBuilder builder = new StringBuilder(a.length*2 + 3);
        builder.append("[ ");
        for (int i = 0, n = a.length; i < n; i++) {
            builder.append(a[i].toString());
            builder.append(" ");
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * Find the longest increasing subarray.
     * @param a The given array
     * @return The longest increasing subarray.
     */
    public static Comparable[] longestIncreasingSubarray(Comparable[] a) {
        int N = a.length;
        int lis[] = new int[N];  // lis ending with a[i]
        lis[0] = 1;
        for (int i = 1; i < N; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i].compareTo(a[j]) > 0) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        int max = 1;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, lis[i]);
        }
        Comparable[] res = new Comparable[max];
        for (int i = N-1; i >=0; i--) {
            if (lis[i] == max) {
                res[--max] = a[i];
            }
        }
        return res;
    }
}
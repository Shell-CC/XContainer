package container;

public class Strings {

    /**
     * Sort an array of fixed-length strings using LSD sorting in O(WN) time
     * @param a The specific array of N strings to be sorted.
     * @param W The length of each fixed-size string.
     */
    public static void LsdSort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        // sort by key-index sorting from dth to 0th in the string
        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R+1];
            // compute frequency counts
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            // Transform counts to indices
            for (int r = 0; r < R; r++) {
                count[r+1] += count[r];
            }
            // Distribute the records
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            // copy back
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
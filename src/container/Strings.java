package container;

public class Strings {

    /**
     * Sort an array of fixed-length strings using LSD sorting in O(WN) time
     * @param a The specific array of N strings to be sorted.
     * @param W The length of each fixed-size string.
     */
    public static void lsdSort(String[] a, int W) {
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


    private static String[] aux;
    private static int R;
    /**
     * Sort an array of strings using MSD sorting.
     * @param strs The specific array of N strings to be sorted.
     */
    public static void msdSort(String[] strs) {
        int N = strs.length;
        aux = new String[N];
        R = 256;
        msdSort(strs, 0, N-1, 0);
    }
    /**
     * Sort the string array in a specific range based on dth character.
     */
    private static void msdSort(String[] a, int fromIndex, int toIndex, int d) {
        if (fromIndex < toIndex) {
            int[] count = new int[R+2];
            // compute frequency counts
            for (int i = fromIndex; i <= toIndex; i++) {
                count[charAt(a[i], d) + 2]++;
            }
            // transform couts into indices
            for (int r = 0; r < R+1; r++) {
                count[r+1] += count[r];
            }
            // distribute
            for (int i = fromIndex; i <= toIndex; i++) {
                aux[count[charAt(a[i], d) + 1]++] = a[i];
            }
            // copy bak
            for (int i = fromIndex; i <= toIndex ; i++) {
                a[i] = aux[i - fromIndex];
            }
            // recursive sort for each character
            for (int r = 0; r < R; r++) {
                msdSort(a, fromIndex+count[r], fromIndex+count[r+1]-1, d+1);
            }
        }
    }
    // return the ascii code of the dth character in the string, or -1 if not in.
    private static int charAt(String s, int d) {
        return d < s.length() ? (int)s.charAt(d) : -1;
    }


    /**
     * Pattern search using KMP algorithm.
     * @param pat The needle to be searched.
     * @param s The haystack to be be searched in.
     * @return The begin index of the pattern first found. If not found, return -1.
     */
    public static int kmpPatternSearch(String s, String pat) {
        int[] pmt = computePmt(pat);
        for (int i = 0, j = 0, N = s.length(), M = pat.length(); i < N; ) {
            if (s.charAt(i) == pat.charAt(j)) { // if matched
                i++;
                j++;
                if (j == M) { // found
                    return i - M;
                }
            } else {    // if not matched
                if (j == 0) {
                    i++;
                } else {
                    j = pmt[j-1];
                }
            }
        }
        return -1;
    }
    private static int[] computePmt(String pat) {
        int M = pat.length();
        int[] pmt = new int[M];
        pmt[0] = 0;
        for (int i = 1, len = 0; i < M; ) {
            if (pmt[i] == pmt[len]) { // if suffix is also prefix
                pmt[i] = ++len;
                i++;
            } else {              // if suffix is not prefix
                if (len == 0) {
                    pmt[i] = 0;
                    i++;
                } else {
                    len = pmt[len-1];
                }
            }
        }
        return pmt;
    }
}
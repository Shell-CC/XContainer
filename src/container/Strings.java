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


    /**
     * Find the longest common substring of the given two string.
     * @param s One of the string
     * @param t The other string
     * @return The longest common substring of the given two string.
     */
    public static String longestCommonSubstring(String s, String t) {
        // Define C[i][j] to be the length of LCS of s[0: i-1] and t[0: j-1]
        int M = s.length(); int N = t.length();
        int[][] c = new int[M+1][N+1];
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (s.charAt(i-1) == t.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                } else {
                    c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
                }
            }
        }
        /* Print the array
          System.out.println("  " + t);
        for (int i = 0; i <= M; i++) {
            if (i == 0) System.out.print(" ");
            else System.out.print(s.charAt(i-1));
            for (int j = 0; j <= N; j++) {
                System.out.print(c[i][j]);
            }
            System.out.println();
            }*/
        int len = c[M][N];
        char[] lcs = new char[len];
        for (int i = M, j = N; i > 0 && j > 0; ) {
            if (s.charAt(i-1) == t.charAt(j-1)) {
                lcs[--len] = s.charAt(i-1);
                i--; j--;
            } else if (c[i][j-1] > c[i-1][j]) {
                j--;
            } else {
                i--;
            }
        }
        return new String(lcs);
    }


    /**
     * Count all palindrome substring with duplicates.
     * @param The given string.
     * @return Nunmber of substrings.
     */
    public static int countPalindromeSubstring(String s) {
        assert s != null;
        int N = s.length();
        int count = 0;
        for (int d = 0; d <= 1; d++) {
            // when d = 0, search all odd-length palindroid substring centered at i
            // when d = 1, search all even-length palindroid substring
            for (int i = 0; i < N - d; i++) {
                int left = i;
                int right = i + d;
                while (left >= 0 && right < N) {
                    if (s.charAt(left) != s.charAt(right)) {
                        break;
                    }
                    count++;
                    System.out.println(s.substring(left, right+1));
                    left--;
                    right++;
                }
            }
        }
        return count;
    }
}
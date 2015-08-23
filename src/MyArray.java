package container;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class MyArray {

    /**
     * reverse the elements within an array.
     */
    public static void reverse(int[] arr) {
        reverse(arr, 0, arr.length-1);
    }
    /**
     * Reverse a range of the array.
     *
     * For example, with fromIndex = 2 and toIndex = 5,
     * the array [1,2,3,4,5,6,7] is rotated to [1,2,6,5,4,3,7].
     */
    public static void reverse(int[] arr, int fromIndex, int toIndex) {
        if (fromIndex >= 0 && toIndex < arr.length && toIndex >= fromIndex) {
            int len = (toIndex - fromIndex + 1) / 2;
            for (int i = fromIndex; i < fromIndex + len; i++) {
                int tmp = arr[i];
                arr[i] = arr[toIndex+fromIndex-i];
                arr[toIndex+fromIndex-i] = tmp;
            }
        }
    }


    /**
     * Given an array of integers, find if the array contains any duplicates.
     *
     * @return true, if any value appears at least twice in the array,
     * false, if every element is distinct.
     */
    public static boolean containsDuplicate(int[] nums) {
        Set set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }


    /**
     * Given an array of integers and an integer k,
     * find out whether there are two distinct indices i and j in the array
     * such that nums[i] = nums[j] and the difference between i and j is at most k.
     *
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i])-i <= k && map.get(nums[i]) >= -k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }


    /**
     * Rotate an array of n elements to the right by k steps.
     *
     * For example, with n = 7 and k = 3 (or k = 10, or k = -4),
     * the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     */
    public static void rotate(int[] arr, int k) {
        if (k > arr.length) {
            rotate(arr, k - arr.length);
        } else if (k <= 0){
            rotate(arr, k + arr.length);
        } else {
            reverse(arr, 0, arr.length-1);
            reverse(arr, 0, k-1);
            reverse(arr, k, arr.length-1);
        }
    }


    /**
     * Given a sorted array, remove the duplicates in place
     * such that each element appear only once and return the new length.
     * Do not allocate extra space for another array.
     *
     * For example, given input array nums = [1,1,2],
     * Your function should return length = 2, with [1,2,*].
     * It doesn't matter what you leave beyond the new length.
     */
    public static int removeDuplicates(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        int i = 0;
        int j = 1;
        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                j++;
            } else {
                i++;
                arr[i] = arr[j];
                j++;
            }
        }
        return i+1;
    }


    /**
     * Sort the array into the ascending numerical order using quick sort.
     * @param arr the array to be sorted.
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    /**
     * Sort the specific range of the array into ascending order using quick sort.
     * @param arr the array to be sorted.
     * @param fromIndex the beginning index of the specific range, inclusively.
     * @param toIndex the end index of the specific range, exclusively.
     */
    public static void quickSort(int[] arr, int fromIndex, int toIndex) {
        if (fromIndex < toIndex) {
            int pivotIndex = partition(arr, fromIndex, toIndex);
            quickSort(arr, fromIndex, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, toIndex);
        }
    }
    private static int partition(int[] arr, int fromIndex, int toIndex) {
        int pivot = arr[toIndex];
        int pi = fromIndex;  // pivot index
        for (int i = fromIndex; i <= toIndex; i++) {
            // item from lect of pi is always no larger than pivot
            if (arr[i] <= pivot) {
                int tmp = arr[pi];
                arr[pi] = arr[i];
                arr[i] = tmp;
                pi++;
            }
        }
        return pi - 1;
    }


    public static String toString(int[] arr) {
        String s = "[ ";
        for (int i = 0; i < arr.length; i++) {
            s = s + Integer.toString(arr[i]) + " ";
        }
        return s + "]";
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 7, 8, 3, 5, 6, 4};
        System.out.println("arr1: " + toString(arr1));
        quickSort(arr1);
        System.out.println("sorted arr1: " + toString(arr1));
        MyArray.reverse(arr1);
        System.out.println("After reversing:");
        System.out.println("arr1: " + toString(arr1));
        MyArray.rotate(arr1, -4);
        System.out.println("After rotating by -4: ");
        System.out.println("arr1: " + toString(arr1));

        int[] arr2 = {3, 7, 7, 7, 4, 5, 5, 2, 0, 8, 8, 8, 8, 5};
        System.out.println("Checking duplicate: ");
        System.out.println(toString(arr1) + ": " + containsDuplicate(arr1));
        System.out.println(toString(arr2) + ": " + containsDuplicate(arr2));
    }
}
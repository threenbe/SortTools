// SortTools.java 
/*
 * EE422C Project 1 submission by
 * Raiyan Chowdhury
 * rac4444
 * 16235
 * Spring 2017
 * Slip days used: 0
 */

package assignment1;
public class SortTools {
	/**
	  * This method tests to see if the given array is sorted.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @return true if array is sorted
	  */
	public static boolean isSorted(int[] x, int n) {
		for (int i = 0; i < n - 1; i++) {
			if (x[i] > x[i+1]) return false;
		}
		return true;
	}
	/**
	 * This method tests to see if the given array contains the value v 
	 * within the first n elements.
	 * @param x is the array, sorted in non-decreasing order
	 * @param n is the size of the input to be checked
	 * @param v is the value being searched for
	 * @return either the index of v or -1 if v isn't found. 
	 * If v is found multiple times, any index (less than n) will do.
	 */
	public static int find(int[] x, int n, int v) {//implements a binary search
		int start = 0;
		int mid;
		int end = n - 1;
		
		while (start <= end) {
			mid = (start + end)/2;
			
			if (v == x[mid]) return mid;
			
			if (v < x[mid]) end = mid - 1;
			else start = mid + 1;
		}
		return -1;
	}
	/**
	 * This method returns a newly created array sorted in non-decreasing
	 * order that contains the first n elements of x and the value v. If
	 * v is already in x, then another copy of v is not added.
	 * @param x is the given array, sorted in non-decreasing order
	 * @param n is the size of the input to be used
	 * @param v is the value to be inserted
	 * @return a new sorted array containing the value v at least once
	 */
	public static int[] insertGeneral(int[] x, int n, int v) {
		if (find(x, n, v) == -1) {
			int[] y = new int[n+1];
			int i, j;
			boolean inserted = false;
			
			for (i = 0, j = 0; i < n; i++, j++) {
				//insert v into appropriate spot when found
				if (x[i] > v && inserted == false) {
					y[j] = v;
					i--;//because we still haven't copied the current value in x
					inserted = true;
				} else {//else simply copy current value from x to y
					y[j] = x[i];
				}
			}
			if (j == i) y[j] = v;//if the value belongs in the last position
			return y;
		}
		
		else {
			int[] y = new int[n];
			for (int i = 0; i < n; i++) {
				y[i] = x[i];
			}
			return y;
		}
	}
	/**
	 * This method modifies x to contain the value v if v is not already
	 * an element of x within the first n elements.
	 * @param x is the given array, sorted in non-decreasing order
	 * @param n is the size of the input to be used
	 * @param v is the value to be inserted
	 * @return n if v was an element of x already, n+1 if v had to be inserted
	 */
	public static int insertInPlace(int[] x, int n, int v) {
		if (find(x, n, v) != -1) {
			return n;
		}
		
		else {
			int i;
			for (i = n; i > 0; i--) {
				if (x[i-1] < v) {//insert v into appropriate slot
					x[i] = v;
					return n+1;
				} else {//else continue to move elements in x up
					x[i] = x[i-1];
				}
			}
			x[i] = v;//if i == 0
			return n+1;
		}
	}
	/**
	 * This method sorts the first n elements of x in non-decreasing order
	 * using insertion sort. 
	 * @param x is the given array
	 * @param n is the size of the input to be sorted
	 */
	public static void insertSort(int[] x, int n) {//implements insertion sort
		for (int i = 1; i < n; i++) {
			int j, temp = x[i];
			
			for (j = i-1; j >= 0 && x[j] > temp; j--) {
				x[j+1] = x[j];
			}
			x[j+1] = temp;
		}
	}
}

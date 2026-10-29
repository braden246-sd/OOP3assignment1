package utilities;

import java.util.Comparator;
import products.Product;

/**
 * Provides sorting algorithms for product arrays.
 * The algorithms sort products in descending order according
 * to the supplied comparator.
 */
public class Sorts {

	/**
	 * Sorts products in descending order using bubble sort.
	 *
	 * @param products the array of products to sort
	 * @param comparator determines how products are compared
	 */
	public static void bubbleSort(Product[] products, Comparator<Product> comparator) {
		for (int i = 0; i < products.length - 1; i++) {
			for (int j = 0; j < products.length - 1 - i; j++) {
				if (comparator.compare(products[j], products[j + 1]) < 0) {
					Product temp = products[j];
					products[j] = products[j + 1];
					products[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * Sorts products in descending order using insertion sort.
	 *
	 * @param products the array of products to sort
	 * @param comparator determines how products are compared
	 */
	public static void insertionSort(Product[] products, Comparator<Product> comparator) {
		for (int i = 1; i < products.length; i++) {
			Product key = products[i];
			int j = i - 1;

			while (j >= 0 && comparator.compare(products[j], key) < 0) {
				products[j + 1] = products[j];
				j--;
			}

			products[j + 1] = key;
		}
	}

	/**
	 * Sorts products in descending order using selection sort.
	 *
	 * @param products the array of products to sort
	 * @param comparator determines how products are compared
	 */
	public static void selectionSort(Product[] products, Comparator<Product> comparator) {
		for (int i = 0; i < products.length - 1; i++) {
			int largestIndex = i;

			for (int j = i + 1; j < products.length; j++) {
				if (comparator.compare(products[j], products[largestIndex]) > 0) {
					largestIndex = j;
				}
			}

			Product temp = products[i];
			products[i] = products[largestIndex];
			products[largestIndex] = temp;
		}
	}

	/**
	 * Sorts products in descending order using merge sort.
	 * Divides the array into two halves, sorts each half, and merges them.
	 *
	 * @param products the array of products to sort
	 * @param comparator determines how products are compared
	 */
	public static void mergeSort(Product[] products, Comparator<Product> comparator) {
		if (products.length > 1) {
			Product[] left = new Product[products.length / 2];
			Product[] right = new Product[products.length - left.length];

			for (int i = 0; i < left.length; i++) {
				left[i] = products[i];
			}

			for (int i = 0; i < right.length; i++) {
				right[i] = products[left.length + i];
			}

			mergeSort(left, comparator);
			mergeSort(right, comparator);

			merge(products, left, right, comparator);
		}
	}

	/**
	 * Merges two sorted halves into the original array in descending order.
	 *
	 * @param products the array receiving the merged result
	 * @param left the sorted left half
	 * @param right the sorted right half
	 * @param comparator determines how products are compared
	 */
	private static void merge(Product[] products, Product[] left, Product[] right, Comparator<Product> comparator) {
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < left.length && j < right.length) {
			if (comparator.compare(left[i], right[j]) >= 0) {
				products[k] = left[i];
				i++;
			} else {
				products[k] = right[j];
				j++;
			}

			k++;
		}

		while (i < left.length) {
			products[k] = left[i];
			i++;
			k++;
		}

		while (j < right.length) {
			products[k] = right[j];
			j++;
			k++;
		}
	}

	/**
	 * Sorts products in descending order using quick sort with a median-of-three pivot.
	 *
	 * @param products the array of products to sort
	 * @param comparator determines how products are compared
	 */
	public static void quickSort(Product[] products, Comparator<Product> comparator) {
		quickSort(products, 0, products.length - 1, comparator);
	}

	/**
	 * Recursively sorts the portion of the array between the given indexes.
	 *
	 * @param products the array being sorted
	 * @param low the first index of the portion to sort
	 * @param high the last index of the portion to sort
	 * @param comparator determines how products are compared
	 */
	private static void quickSort(Product[] products, int low, int high, Comparator<Product> comparator) {
		if (low < high) {
			int pivotIndex = partition(products, low, high, comparator);

			quickSort(products, low, pivotIndex - 1, comparator);
			quickSort(products, pivotIndex + 1, high, comparator);
		}
	}

	/**
	 * Orders the first, middle, and last elements by the comparator
	 * and returns the index of the median element.
	 *
	 * @param products the array containing the elements
	 * @param low the first index of the portion being sorted
	 * @param high the last index of the portion being sorted
	 * @param comparator determines how products are compared
	 * @return the index of the median element
	 */
	private static int medianOfThree(Product[] products, int low, int high, Comparator<Product> comparator) {
		int middle = low + (high - low) / 2;

		if (comparator.compare(products[low], products[middle]) > 0) {
			Product temp = products[low];
			products[low] = products[middle];
			products[middle] = temp;
		}

		if (comparator.compare(products[low], products[high]) > 0) {
			Product temp = products[low];
			products[low] = products[high];
			products[high] = temp;
		}

		if (comparator.compare(products[middle], products[high]) > 0) {
			Product temp = products[middle];
			products[middle] = products[high];
			products[high] = temp;
		}

		return middle;
	}

	/**
	 * Partitions the array around a pivot, placing larger comparison values first.
	 *
	 * @param products the array being partitioned
	 * @param low the first index of the portion being sorted
	 * @param high the last index of the portion being sorted
	 * @param comparator determines how products are compared
	 * @return the pivot's final index
	 */
	private static int partition(Product[] products, int low, int high, Comparator<Product> comparator) {
		int pivotIndex = medianOfThree(products, low, high, comparator);

		Product temp = products[pivotIndex];
		products[pivotIndex] = products[high];
		products[high] = temp;

		Product pivot = products[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (comparator.compare(products[j], pivot) > 0) {
				i++;

				temp = products[i];
				products[i] = products[j];
				products[j] = temp;
			}
		}

		temp = products[i + 1];
		products[i + 1] = products[high];
		products[high] = temp;

		return i + 1;
	}

	/**
	 * Sorts the products in descending order using heap sort.
	 * A min-heap moves the smallest remaining element to the
	 * end of the unsorted portion during each iteration.
	 *
	 * @param products the array of products to sort
	 * @param comparator determines how products are compared
	 */
	public static void heapSort(Product[] products, Comparator<Product> comparator) {
		int n = products.length;

		buildHeap(products, n, comparator);

		for (int i = n - 1; i > 0; i--) {
			Product temp = products[0];
			products[0] = products[i];
			products[i] = temp;

			heapify(products, i, 0, comparator);
		}
	}

	/**
	 * Builds a min-heap from the product array.
	 *
	 * @param products the array of products
	 * @param n the number of elements in the heap
	 * @param comparator determines how products are compared
	 */
	private static void buildHeap(Product[] products, int n, Comparator<Product> comparator) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(products, n, i, comparator);
		}
	}

	/**
	 * Restores the min-heap property for a subtree rooted at index i.
	 *
	 * @param products the array of products
	 * @param n the number of elements currently in the heap
	 * @param i the index of the subtree root
	 * @param comparator determines how products are compared
	 */
	private static void heapify(Product[] products, int n, int i, Comparator<Product> comparator) {
		int smallest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && comparator.compare(products[left], products[smallest]) < 0) {
			smallest = left;
		}

		if (right < n && comparator.compare(products[right], products[smallest]) < 0) {
			smallest = right;
		}

		if (smallest != i) {
			Product temp = products[i];
			products[i] = products[smallest];
			products[smallest] = temp;

			heapify(products, n, smallest, comparator);
		}
	}

}
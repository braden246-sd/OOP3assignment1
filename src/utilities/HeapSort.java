package utilities;
import java.util.Comparator;
import products.Product;

//Created by Nathan Foran

public class HeapSort {
	/**
	 * Sorts the products in descending order using heap sort.
	 * A min-heap moves the smallest remaining element to the
	 * end of the unsorted portion during each iteration.
	 *
	 * @param products the array of products to sort
	 * @param comparator determines how products are compared
	 */
	public static void sort(Product[] products, Comparator<Product> comparator) {
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

package utilities;
import products.Product;
import java.util.Comparator;

//created by Nathan Foran

public class QuickSort {
	/**
	 * Sorts products in descending order using quick sort with a median-of-three pivot.
	 *
	 * @param products the array of products to sort
	 * @param comparator determines how products are compared
	 */
	public static void sort(Product[] products, Comparator<Product> comparator) {
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
}

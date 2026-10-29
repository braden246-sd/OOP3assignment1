package utilities;
import products.Product;
import java.util.Comparator;

public class SelectionSort {
	
	/**
	 * Sorts products in descending order using selection sort.
	 *
	 * @param products the array of products to sort
	 * @param comparator determines how products are compared
	 */
	public static void sort(Product[] products, Comparator<Product> comparator) {
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

}

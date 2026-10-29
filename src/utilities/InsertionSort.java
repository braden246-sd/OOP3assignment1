package utilities;
import products.Product;
import java.util.Comparator;

public class InsertionSort {
	/**
	 * Sorts products in descending order using insertion sort.
	 *
	 * @param products the array of products to sort
	 * @param comparator determines how products are compared
	 */
	public static void sort(Product[] products, Comparator<Product> comparator) {
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
		

}

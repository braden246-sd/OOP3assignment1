
package utilities;

import java.util.Comparator;
import products.Product;

/**
 * Compares products by their updated prices.
 */
public class UpdatedPriceComparator implements Comparator<Product>
{
	
	/**
	 * Compares two products by their updated prices.
	 *
	 * @param first the first product to compare
	 * @param second the second product to compare
	 * @return a negative value if the first price is lower, zero if
	 *         the prices are equal, or a positive value if the first
	 *         price is higher
	 */
    @Override
    public int compare(Product first, Product second)
    {
        return Double.compare(first.getUpdatedPrice(),
                              second.getUpdatedPrice());
    }
}
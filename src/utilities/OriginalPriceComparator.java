package utilities;

import java.util.Comparator;
import products.Product;

/**
 * Compares products by their original prices.
 */
public class OriginalPriceComparator implements Comparator<Product>
{
	
	/**
	 * Compares two products by their original prices.
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
        return Double.compare(first.getOriginalPrice(),
                              second.getOriginalPrice());
    }
}
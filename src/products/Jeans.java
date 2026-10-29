package products;

/**
 * Represents a jeans product with an adjustment factor of 0.5
 * for calculating its real price difference.
 */
public class Jeans extends Product
{
	/**
	 * Creates a pair of jeans with its original and updated prices.
	 *
	 * @param originalPrice the original price of the jeans
	 * @param updatedPrice the updated price of the jeans
	 */
    public Jeans(double originalPrice, double updatedPrice)
    {
        super(originalPrice, updatedPrice);
    }

    /**
     * Calculates the jeans' real price difference using an adjustment
     * factor of 0.5.
     *
     * @return the absolute price difference multiplied by 0.5
     */
    @Override
    public double calcRealDiff()
    {
        return 0.5 * Math.abs(getOriginalPrice() - getUpdatedPrice());
    }
}
package products;

/**
 * Represents a shoe product with an adjustment factor of 0.4
 * for calculating its real price difference.
 */
public class Shoes extends Product
{
	/**
	 * Creates shoes with their original and updated prices.
	 *
	 * @param originalPrice the original price of the shoes
	 * @param updatedPrice the updated price of the shoes
	 */
    public Shoes(double originalPrice, double updatedPrice)
    {
        super(originalPrice, updatedPrice);
    }

    /**
     * Calculates the shoes' real price difference using an adjustment
     * factor of 0.4.
     *
     * @return the absolute price difference multiplied by 0.4
     */
    @Override
    public double calcRealDiff()
    {
        return 0.4 * Math.abs(getOriginalPrice() - getUpdatedPrice());
    }
}
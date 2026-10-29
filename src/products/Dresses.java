package products;

/**
 * Represents a dress product with an adjustment factor of 0.6
 * for calculating its real price difference.
 */
public class Dresses extends Product
{
	
	/**
	 * Creates a dress with its original and updated prices.
	 *
	 * @param originalPrice the original price of the dress
	 * @param updatedPrice the updated price of the dress
	 */
    public Dresses(double originalPrice, double updatedPrice)
    {
        super(originalPrice, updatedPrice);
    }

    /**
     * Calculates the dress's real price difference using an adjustment
     * factor of 0.6.
     *
     * @return the absolute price difference multiplied by 0.6
     */
    @Override
    public double calcRealDiff()
    {
        return 0.6 * Math.abs(getOriginalPrice() - getUpdatedPrice());
    }
}
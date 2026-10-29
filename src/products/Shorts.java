package products;

/**
 * Represents a shorts product with an adjustment factor of 0.3
 * for calculating its real price difference.
 */
public class Shorts extends Product
{
	
	/**
	 * Creates a pair of shorts with its original and updated prices.
	 *
	 * @param originalPrice the original price of the shorts
	 * @param updatedPrice the updated price of the shorts
	 */
    public Shorts(double originalPrice, double updatedPrice)
    {
        super(originalPrice, updatedPrice);
    }

    /**
     * Calculates the shorts' real price difference using an adjustment
     * factor of 0.3.
     *
     * @return the absolute price difference multiplied by 0.3
     */
    @Override
    public double calcRealDiff()
    {
        return 0.3 * Math.abs(getOriginalPrice() - getUpdatedPrice());
    }
}
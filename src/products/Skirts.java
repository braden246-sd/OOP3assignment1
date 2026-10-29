package products;

/**
 * Represents a skirt product with an adjustment factor of 0.1
 * for calculating its real price difference.
 */
public class Skirts extends Product
{
	
	/**
	 * Creates a skirt with its original and updated prices.
	 *
	 * @param originalPrice the original price of the skirt
	 * @param updatedPrice the updated price of the skirt
	 */
    public Skirts(double originalPrice, double updatedPrice)
    {
        super(originalPrice, updatedPrice);
    }

    /**
     * Calculates the skirt's real price difference using an adjustment
     * factor of 0.1.
     *
     * @return the absolute price difference multiplied by 0.1
     */
    @Override
    public double calcRealDiff()
    {
        return 0.1 * Math.abs(getOriginalPrice() - getUpdatedPrice());
    }
}
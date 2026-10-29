package products;

/**
 * Represents a jacket product with an adjustment factor of 0.7
 * for calculating its real price difference.
 */
public class Jackets extends Product
{
	
	/**
	 * Creates a jacket with its original and updated prices.
	 *
	 * @param originalPrice the original price of the jacket
	 * @param updatedPrice the updated price of the jacket
	 */
    public Jackets(double originalPrice, double updatedPrice)
    {
        super(originalPrice, updatedPrice);
    }
    
    /**
     * Calculates the jacket's real price difference using an adjustment
     * factor of 0.7.
     *
     * @return the absolute price difference multiplied by 0.7
     */
    @Override
    public double calcRealDiff()
    {
        return 0.7 * Math.abs(getOriginalPrice() - getUpdatedPrice());
    }
}
package products;

/**
 * Represents a T-shirt product with an adjustment factor of 0.2
 * for calculating its real price difference.
 */
public class TShirts extends Product
{
	
	/**
	 * Creates a T-shirt with its original and updated prices.
	 *
	 * @param originalPrice the original price of the T-shirt
	 * @param updatedPrice the updated price of the T-shirt
	 */
    public TShirts(double originalPrice, double updatedPrice)
    {
        super(originalPrice, updatedPrice);
    }

    /**
     * Calculates the T-shirt's real price difference using an adjustment
     * factor of 0.2.
     *
     * @return the absolute price difference multiplied by 0.2
     */
    @Override
    public double calcRealDiff()
    {
        return 0.2 * Math.abs(getOriginalPrice() - getUpdatedPrice());
    }
}
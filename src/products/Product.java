package products;

/**
 * Represents a product with an original price and an updated price.
 * Subclasses define how the adjusted price difference is calculated.
 * Products are naturally ordered by their calculated price differences.
 */
public abstract class Product implements Comparable<Product>
{
    private double originalPrice;
    private double updatedPrice;

    /**
     * Creates a product with its original and updated prices.
     *
     * @param originalPrice the original price of the product
     * @param updatedPrice the updated price of the product
     */
    public Product(double originalPrice, double updatedPrice)
    {
        this.originalPrice = originalPrice;
        this.updatedPrice = updatedPrice;
    }

    /**
     * Returns the original price of the product.
     *
     * @return the original price
     */
    public double getOriginalPrice()
    {
        return originalPrice;
    }

    /**
     * Returns the updated price of the product.
     *
     * @return the updated price
     */
    public double getUpdatedPrice()
    {
        return updatedPrice;
    }

    /**
     * Calculates the adjusted difference between the two prices.
     *
     * @return the adjusted price difference
     */
    public abstract double calcRealDiff();

    /**
     * Compares this product with another product using their calculated
     * price differences.
     *
     * @param other the product to compare with
     * @return a negative value if this product has a smaller difference,
     *         zero if the differences are equal, or a positive value
     *         if this product has a larger difference
     */
    @Override
    public int compareTo(Product other)
    {
        return Double.compare(this.calcRealDiff(), other.calcRealDiff());
    }
}
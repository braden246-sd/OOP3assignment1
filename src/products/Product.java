//Created by Braden Ouellet October 2026
//step 2 create a abstract class the represents original price and updated price 

package products;


public abstract class Product
	implements Comparable<Product> //lets Product objects compare themselves with compareTo()
{
	
	protected double originalPrice;
	protected double updatedPrice; //uses protected because subclasses willl need access to these variables
	
	public Product (double originalPrice, double updatedPrice) {
		
		//constructor to set the original and updated prices 
		this.originalPrice = originalPrice;
		this.updatedPrice = updatedPrice;
	}
	
	public double getOriginalPrice() {
		return originalPrice;
	}
	
	public double getUpdatedPrice() {
		return updatedPrice;
	}
	
	public abstract double calcRealDiff();
	
	
	@Override 
	public int compareTo(Product other) {
		return Double.compare(this.calcRealDiff(), other.calcRealDiff());
		
		/*
		 * if Double.compare returns a negative number the product is smaller, zero the products are 
		 * equal and a positive number this product is larger 
		 * if product 1 difference is 25 and product 2 difference is 75 Double.compare(25, 75) returns a negative number
		 */
	}

}

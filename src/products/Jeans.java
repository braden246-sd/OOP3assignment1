//Created by Braden Ouellet October 2026

package products;

public class Jeans extends Product {
	
	public Jeans(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice); //super calls the parent constructor 
	}
	
	@Override
	public double calcRealDiff() {
		return 0.5 * Math.abs(originalPrice - updatedPrice);
		
		//for jeans the adjustment is 0.5
		// Adjustment * Absolute value of (Original Price - Updated Price) - from assignment 
	}

}

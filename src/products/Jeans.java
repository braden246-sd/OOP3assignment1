//Created by Braden Ouellet October 2026

package products;

public class Jeans extends Product {
<<<<<<< HEAD
	//all the subclasses jeans tshirt etc are basically the same except for the adjustment amount
=======
>>>>>>> dd1ed79cef80ebf057af8f7c2e12a7b3b4e0bf5c
	
	public Jeans(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice); //super calls the parent constructor 
	}
	
	@Override
	public double calcRealDiff() {
		return 0.5 * Math.abs(originalPrice - updatedPrice);
		
		//for jeans the adjustment is 0.5
		// Adjustment * Absolute value of (Original Price - Updated Price) - from assignment 
<<<<<<< HEAD
		
=======
>>>>>>> dd1ed79cef80ebf057af8f7c2e12a7b3b4e0bf5c
	}

}

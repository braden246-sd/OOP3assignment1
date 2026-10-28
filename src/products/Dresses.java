//created by Braden Ouellet October 2026
package products;
//see jeans.java for any explanation these are all basically the same


public class Dresses extends Product {
	public Dresses (double originalPrice, double updatedPrice) {
		super (originalPrice, updatedPrice);
	}
	
	@Override 
	public double calcRealDiff() {
		return 0.6 * Math.abs(originalPrice - updatedPrice);
	}

}

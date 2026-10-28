//created by Braden Ouellet October 2026
package products;
//see jeans.java for any explanation these are all basically the same


public class Shorts extends Product {
	public Shorts (double originalPrice, double updatedPrice) {
		super (originalPrice, updatedPrice);
	}
	
	@Override 
	public double calcRealDiff() {
		return 0.3 * Math.abs(originalPrice - updatedPrice);
	}

}

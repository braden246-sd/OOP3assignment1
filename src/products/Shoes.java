//created by Braden Ouellet October 2026
package products;
//see jeans.java for any explanation these are all basically the same


public class Shoes extends Product {
	public Shoes (double originalPrice, double updatedPrice) {
		super (originalPrice, updatedPrice);
	}
	
	@Override 
	public double calcRealDiff() {
		return 0.2 * Math.abs(originalPrice - updatedPrice);
	}

}

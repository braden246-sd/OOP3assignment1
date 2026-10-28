package utilities;
import java.util.Comparator;
import products.Product;
//created by Braden Ouellet october 2026
public class OriginalPriceComparator implements Comparator<Product> {
	
	
	@Override
	public int compare(Product p1, Product p2) {
		return Double.compare(p1.getOriginalPrice(), p2.getOriginalPrice());
	}

}

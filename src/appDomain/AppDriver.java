package appDomain;
import java.util.Comparator;
import products.Product;
import utilities.*;

/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 
 * class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver
{
	/**
	 *  The main method is the entry point of the application.
	 *  
	 *  @param args The input to control the execution of the application.
	 */
	public static void main( String[] args )
	{
		try {
			
		String fileName = "res/products1.txt";
		char compareType = 'o';
		char sortType ='m';
		
		Product[] products = FileLoader.loadProducts(fileName);
		Comparator<Product> comparator;
		
		switch(compareType) {
		
		case 'o': comparator = new OriginalPriceComparator();
		break;
		
		case 'u': comparator = new UpdatedPriceComparator();
		break;
		
		default:
			throw new IllegalArgumentException("Invalid compare type");
		}
		
		switch(sortType) {
		case 'b': BubbleSort.sort(products, comparator);
			break;
		case 'm': MergeSort.sort(products, comparator);
			break;
		case 'i': 
			//placeholder for algorithm
			break;
		case 's':
			break;
		case 'q':
			break;
		case 'z': 
			break;
		}
		
		for(Product product : products ) {
			System.out.print(products);
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}
}

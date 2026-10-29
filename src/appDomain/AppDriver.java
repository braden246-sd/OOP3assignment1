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
	
	private static void displayProducts(Product[] products) {
	    if(products.length <= 10) {
	        for(Product product : products) {
	            System.out.println(product);
	        }
	        return;
	    }
	 int step;
	 
	 if(products.length <= 1000) {
		 step = 100;
	 }
	 else { 
		 step = 1000;
	 }
	 System.out.println("First element is: " + products[0]);
	 
	 for (int i = step - 1; i < products.length - 1; i += step) {
		 System.out.println((i+1) + "-th element: " + products[i]);
	 }
	 System.out.println("Last element is: " + products[products.length -1]);
	}
	        
	public static void main( String[] args )
	{
		try {

			String fileName= "res/products1.txt";
			char compareType = 'o';
			char sortType = 'm';
			
		for(int i = 0; i < args.length; i++) {
			String arg = args[i].toLowerCase(); //case sensitive like assignment says 
			
			if(arg.startsWith("-f")) {
				fileName =  args[i].substring(2);
				//running the jar file without the "res/" here does not work but the assignment doc
				//has the jar input as java -jar Sort.jar -tu -sQ -f"res\products1.txt" so im just going to 
				//leave this as is, not sure if this ruins it all 
			}
			else if( arg.startsWith("-t")) {
				compareType = arg.charAt(2);
			}
			else if(arg.startsWith("-s")) {
				sortType = arg.charAt(2);
			}
		}
		
		System.out.println("File: " + fileName);
		System.out.println("Comparator: " + compareType);
		System.out.println("Sort: " + sortType);
		System.out.println();
		
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
		
		long startTime = System.nanoTime();
		String sortName;
		
		switch(sortType) {
		case 'b': 
			BubbleSort.sort(products, comparator);
			sortName = "Bubble Sort";
			break;
		case 'm': 
			MergeSort.sort(products, comparator);
			sortName = "Merge Sort";
			break;
		case 'i': 
			InsertionSort.sort(products, comparator);
			sortName = "Insertion Sort";
			break;
		case 's':
			SelectionSort.sort(products, comparator);
			sortName = "Selection Sort";
			break;
		case 'q':
			QuickSort.sort(products, comparator);
			sortName = "Quick sort";
			break;
		case 'z': 
			HeapSort.sort(products, comparator);
			sortName = "Heap sort";
			break;
		
		default: 
			throw new IllegalArgumentException("Invalid sort type");
		}
		
		long endTime = System.nanoTime();
		
		long nanoExecutionTime = endTime - startTime;
		double miliExecutionTime = nanoExecutionTime * 0.000001;
		
		displayProducts(products);
		
		System.out.println(sortName + " run Time: " + miliExecutionTime + " Milliseconds");
		System.out.println();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}
}

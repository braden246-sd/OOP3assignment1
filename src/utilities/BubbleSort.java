package utilities;
import java.util.Comparator;
import products.Product;

//bubble sorting repeatedly compares neighboring values 

public class BubbleSort {
	public static void sort(Product[] products, Comparator<Product> comparator) {
		for(int pass = 0; pass < products.length -1; pass ++) {
			//each pass moves another item into position if there are 10 products we need 9 passes
			for( int index = 0; index < products.length - 1 - pass; index++) {
				//will compare index with index + 1, products[0] & products[1] then products[1] & products[2} and so on
				if(comparator.compare(products[index], products[index + 1]) < 0) {
					//compare(p1,p2) returns negative when p1 < p2 we are trying to go in descending order 
					Product temp = products[index];
					products[index] = products[index +1];
					products[index + 1] = temp;
				}
				
			}
			
			
		}
	}

}

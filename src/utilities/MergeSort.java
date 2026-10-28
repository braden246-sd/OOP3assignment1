package utilities;
import java.util.Comparator;
import products.Product;

//created by Braden Ouellet october 2026
//Merge two already sorted half into one sorted section
public class MergeSort {
	public static void sort(Product[] products, Comparator<Product> comparator) {
		mergeSort(products, 0, products.length -1, comparator);
	}
	
	private static void mergeSort(Product[] products, int left, int  right, Comparator<Product> comparator) {
		//private so it doesnt get called anywhere else
		if( left >= right) {
			return;
		}
		int middle = (left + right) / 2;
		
		mergeSort(products, left, middle, comparator); //sorts the left side
		mergeSort(products, middle +1, right, comparator); //sorts right side middle + 1 is where the right side would start
		merge(products, left, middle, right, comparator);
	}
	
	private static void merge(Product[] products, int left, int middle, int right, Comparator<Product> comparator) {
		//if mergeSort() has already split the array and sorted the halves we need to combine them into descending order
		int leftSize = middle - left + 1;
		int rightSize = right - middle;
		
		//temporary arrays:
		Product[] leftArray = new Product[leftSize];
		Product[] rightArray = new Product[rightSize];
		
		for( int i = 0; i < leftSize; i++) {
			leftArray[i] = products[left + i];
			
		}
		for( int j = 0; j < rightSize; j++) {
			rightArray[j] = products[middle + 1 + j];
		}
		
		int i = 0; //tracks where we are in leftArray
		int j = 0; //tracks where we are in rightArray
		int k = left; //tracks where we are writing into
		
		while(i < leftSize && j < rightSize) {
			//as long as both sides have something left we compare them
			if(comparator.compare(leftArray[i], rightArray[j]) >= 0) {
				//compare (a,b) returns positive if a larger 0 if equal and negative if b larger
				//assignment wants largest to smallest so if leftArray[i] >= rightArray[j] we want the left value first
				
				products[k] = leftArray[i]; //copy value
				i++; //move i
				k++; //move k
				
			}
			else {
				
				products[k] = rightArray[j];
				
				j++;
				k++;
				
			}
		}
		while (i < leftSize ) {
			products[k] = leftArray[i];
			i++;
			k++; //this way if anything remains in left array copy it into proucts one at a time
		}
		while(j < rightSize) {
			products[k] = rightArray[j];
			j++;
			k++;
		}
		
	}
	

}

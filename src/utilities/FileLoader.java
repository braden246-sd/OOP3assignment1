package utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import products.*; //imports all products classes
//created by Braden Ouellet October 2026
public class FileLoader {
	
	public static Product[] loadProducts(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner input = new Scanner(file);
		
		int numberOfProducts = Integer.parseInt(input.nextLine()); 
		// the files all list how many products at the top
		//input.nextLine() will return something like 10 or 1000 depending on the file
		//then it gets turned into an int using Integer.parseint("10")
		//returning 10 as an int so numberOfProducts becomes = 10 in the case of products1.txt
		//now we know the size of the array
		
		Product[] products = new Product[numberOfProducts];
		//if the first line was 10 this creates Product[10]
		
		int index = 0; //to keep track of where in the array we are at
		
		while(input.hasNextLine()) { //keeps reading until the file ends
			String line = input.nextLine(); //something like "Jeans 54.46 63.25" 
			String[] parts = line.split(" "); //now parts[0] shows "Jeans" parts[1] 54.46 and parts[2] 63.25
			String type = parts[0]; // type = jeans
			double originalPrice = Double.parseDouble(parts[1]); //originalPrice = 54.46
			double updatedPrice = Double.parseDouble(parts[2]); //updatedPrice = 63.25
			
			
			switch(type) {
				case "Jeans": products[index] = new Jeans(originalPrice, updatedPrice);
					break;
				case "TShirts": products[index] = new TShirts(originalPrice, updatedPrice);
					break;
				case "Skirts": products[index] = new Skirts(originalPrice, updatedPrice);
					break;
				case "Dresses": products[index] = new Dresses(originalPrice, updatedPrice);
					break;
				case "Shorts": products[index] = new Shorts(originalPrice, updatedPrice);
					break;
				case "Jackets": products[index] = new Jackets(originalPrice, updatedPrice);
				break;
				case "Shoes": products[index] = new Shoes(originalPrice, updatedPrice);
				break;
				
				
				//pretty simple switch(type) just asks what product did we just read 
				//if type = jeans then Java executes products[index] ....
				//which becomes products index new Jeans(54.46, 63.25)
			}
			index++; //without this products[0] would be overwritten over and over again, each product gets its own position
		}
			input.close();
			
			for(int i = 0; i < products.length; i++)
			{
			    if(products[i] == null)
			    {
			        System.out.println(
			            "Null product at index " + i);
			    }
			}
			
			return products;
		
		
	}

}

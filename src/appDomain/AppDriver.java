package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import products.Dresses;
import products.Jackets;
import products.Jeans;
import products.Product;
import products.Shoes;
import products.Shorts;
import products.Skirts;
import products.TShirts;
import utilities.OriginalPriceComparator;
import utilities.Sorts;
import utilities.UpdatedPriceComparator;

/**
 * <p>
 * This application driver runs the Complexity and Sorting assignment for
 * CPRG304. It processes command-line arguments, reads product data, and
 * coordinates the sorting operations.
 * </p>
 */
public class AppDriver {
	/**
	 * The entry point of the application.
	 *
	 * @param args the command-line arguments supplied when the program starts
	 */
	public static void main(String[] args) {

		String[] options = parseArguments(args);

		if (options == null) {
			return;
		}

		String fileName = options[0];
		char compareType = options[1].charAt(0);
		char sortAlgorithm = options[2].charAt(0);

		try {
			Product[] products = loadProducts(fileName);
			Comparator<Product> comparator;

			if (compareType == 'o') {
				comparator = new OriginalPriceComparator();
			} else if (compareType == 'u') {
				comparator = new UpdatedPriceComparator();
			} else {
				comparator = Comparator.naturalOrder();
			}

			System.out.println("Products loaded: " + products.length);

			long startTime = System.nanoTime();

			switch (sortAlgorithm) {
			case 'b':
				Sorts.bubbleSort(products, comparator);
				break;
			case 's':
				Sorts.selectionSort(products, comparator);
				break;
			case 'i':
				Sorts.insertionSort(products, comparator);
				break;
			case 'm':
				Sorts.mergeSort(products, comparator);
				break;
			case 'q':
				Sorts.quickSort(products, comparator);
				break;
			case 'z':
				Sorts.heapSort(products, comparator);
				break;
			}

			long endTime = System.nanoTime();
			String algorithmName;
			double elapsedTime = (endTime - startTime) / 1_000_000.0;
			switch (sortAlgorithm) {
			case 'b': algorithmName = "Bubble Sort"; break;
			case 's': algorithmName = "Selection Sort"; break;
			case 'i': algorithmName = "Insertion Sort"; break;
			case 'm': algorithmName = "Merge Sort"; break;
			case 'q': algorithmName = "Quick Sort"; break;
			case 'z': algorithmName = "Heap Sort"; break;
			default: algorithmName = "Unknown Sort";
			}
			
			System.out.printf("%s run time was: %.0f milliseconds%n",
			        algorithmName, elapsedTime);
			printProducts(products);
		} catch (FileNotFoundException e) {
			System.out.println("Could not open file: " + fileName);
			
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input data: expected a number in the product file.");
        } catch (NoSuchElementException e) {
            System.out.println("Invalid input data: the product file is incomplete.");
		} catch (IllegalArgumentException e) {
		    System.out.println("Invalid product data: " + e.getMessage());
		}
	}

	/**
	 * Displays the sorted products according to the assignment's output rules.
	 *
	 * @param products the sorted array of products
	 */
	private static void printProducts(Product[] products) {
		int count = products.length;

		if (count <= 10) {
			for (int i = 0; i < count; i++) {
				printProduct(products[i]);
			}
		} else {
			int interval;

			if (count <= 1000) {
				interval = 100;
			} else {
				interval = 1000;
			}

			// Print the first product.
			printProduct(products[0]);

			// Print every hundredth or thousandth product.
			for (int i = interval - 1; i < count - 1; i += interval) {
				printProduct(products[i]);
			}

			// Print the last product.
			printProduct(products[count - 1]);
		}
	}

	/**
	 * Displays one product and its price information.
	 *
	 * @param product the product to display
	 */
	private static void printProduct(Product product) {
	    System.out.printf("%s | Original Price: %.2f | Updated Price: %.2f | Real Difference: %.2f%n",
	            product.getClass().getSimpleName(),
	            product.getOriginalPrice(),
	            product.getUpdatedPrice(),
	            product.calcRealDiff());
	}
	/**
	 * Reads and validates the command-line arguments required by the application.
	 * The file, comparison type, and sorting algorithm can be supplied in any
	 * order.
	 *
	 * <p>
	 * The option names are converted to lowercase so that uppercase and lowercase
	 * command-line options are treated equally. Each option is checked for
	 * duplicates and valid values before the parsed information is returned.
	 * </p>
	 *
	 * @param args the command-line arguments supplied when the program starts
     * @return a String array containing the file name, comparison type, and sorting
     *         algorithm in that order, or null if any argument is missing or invalid
	 */
	private static String[] parseArguments(String[] args) {
		String fileName = null;
		char compareType = '\0';
		char sortAlgorithm = '\0';

		for (int i = 0; i < args.length; i++) {
			// Convert the option to lowercase to accept either letter case.
			String argument = args[i].toLowerCase();

			if (argument.startsWith("-f")) {
				// Reject a second file option instead of replacing the first.
				if (fileName != null) {
					System.out.println("Duplicate file option. Use -f only once.");
					return null;
				}

				// Extract the file path while preserving its original case.
				fileName = args[i].substring(2);

				if (fileName.isEmpty()) {
					System.out.println("Missing file path. Use -f followed by a file path.");
					return null;
				}
			} else if (argument.startsWith("-t")) {
				// Reject duplicate comparison options.
				if (compareType != '\0') {
					System.out.println("Duplicate comparison option. Use -t only once.");
					return null;
				}

				String value = argument.substring(2);

				// Only original price, updated price, or calculated difference is allowed.
				if (value.length() != 1
						|| (value.charAt(0) != 'o' && value.charAt(0) != 'u' && value.charAt(0) != 'd')) {
					System.out.println("Invalid comparison type. Use -to, -tu, or -td.");
					return null;
				}

				compareType = value.charAt(0);
			} else if (argument.startsWith("-s")) {
				// Reject duplicate sorting options.
				if (sortAlgorithm != '\0') {
					System.out.println("Duplicate sorting option. Use -s only once.");
					return null;
				}

				String value = argument.substring(2);

				// Check that the selected algorithm is one supported by the assignment.
				if (value.length() != 1 || (value.charAt(0) != 'b' && value.charAt(0) != 's' && value.charAt(0) != 'i'
						&& value.charAt(0) != 'm' && value.charAt(0) != 'q' && value.charAt(0) != 'z')) {
					System.out.println("Invalid sorting algorithm. Use -sb, -ss, -si, -sm, -sq, or -sz.");
					return null;
				}

				sortAlgorithm = value.charAt(0);
			} else {
				// Report an option that the application does not recognize.
				System.out.println("Invalid argument: " + args[i]);
				return null;
			}
		}

		// All three options are required before the application can continue.
		if (fileName == null || compareType == '\0' || sortAlgorithm == '\0') {
			System.out.println("Missing required argument. Please provide -f, -t, and -s.");
			return null;
		}

		// Return the parsed values together so main() can use them.
		return new String[] { fileName, String.valueOf(compareType), String.valueOf(sortAlgorithm) };
	}

	/**
	 * Reads product records from a file and stores them in a fixed-size array. The
	 * first line specifies the number of products to load.
	 *
	 * @param fileName the path of the product data file
	 * @return an array containing the products read from the file
	 * @throws FileNotFoundException if the file cannot be opened
	 * @throws IllegalArgumentException if a product category is not recognized
     * @throws InputMismatchException if the product count or a price is not numeric
     * @throws NoSuchElementException if the file does not contain all expected data
	 */
	private static Product[] loadProducts(String fileName) throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));

		int productCount = input.nextInt();

		if (productCount < 0) {
		    input.close();
		    throw new IllegalArgumentException("Product count cannot be negative.");
		}

		Product[] products = new Product[productCount];

		for (int i = 0; i < productCount; i++) {
			String category = input.next();
			if (!category.equals("Jeans")
			        && !category.equals("TShirts")
			        && !category.equals("Skirts")
			        && !category.equals("Dresses")
			        && !category.equals("Shorts")
			        && !category.equals("Jackets")
			        && !category.equals("Shoes")) {
			    input.close();
			    throw new IllegalArgumentException("Unknown product category: " + category);
			}
			double originalPrice = input.nextDouble();
			double updatedPrice = input.nextDouble();

			switch (category) {
			case "Jeans":
				products[i] = new Jeans(originalPrice, updatedPrice);
				break;
			case "TShirts":
				products[i] = new TShirts(originalPrice, updatedPrice);
				break;
			case "Skirts":
				products[i] = new Skirts(originalPrice, updatedPrice);
				break;
			case "Dresses":
				products[i] = new Dresses(originalPrice, updatedPrice);
				break;
			case "Shorts":
				products[i] = new Shorts(originalPrice, updatedPrice);
				break;
			case "Jackets":
				products[i] = new Jackets(originalPrice, updatedPrice);
				break;
			case "Shoes":
				products[i] = new Shoes(originalPrice, updatedPrice);
				break;
			}
		}

		input.close();

		return products;
	}
}
package appDomain;

import products.Product;
import utilities.BubbleSort;
import utilities.FileLoader;
import utilities.OriginalPriceComparator;

public class AppDriver
{
    public static void main(String[] args)
    {
        try
        {
            // Load all products from the file
            Product[] products =
                    FileLoader.loadProducts(
                            "res/products1.txt");

            // Sort by original price (largest to smallest)
            BubbleSort.sort(
                    products,
                    new OriginalPriceComparator());

            // Display sorted products
            for(Product product : products)
            {
                System.out.println(product);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
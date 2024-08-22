package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program
{
    public static void main( String[] args ) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> productList = new ArrayList<>();

        int numberProducts;
        String name;
        Double price;
        Double customFee;
        Date manufactureDate;
        char op;

        System.out.print( "Enter the number of products: ");
        numberProducts = sc.nextInt();
        for(int i=1;i<=numberProducts;i++){
            System.out.println("Product #"+i+" data:");
            System.out.print( "Common, Used or Imported (c/u/i)? ");
            op = sc.next().charAt(0);
            System.out.print( "Enter the product name: ");
            name = sc.next();
            System.out.print( "Enter the product price: ");
            price = sc.nextDouble();

            if (op == 'c') {
                productList.add(new Product(name, price));
            }
            else if (op == 'i') {
                System.out.print("Customs fee: ");
                customFee = sc.nextDouble();

                productList.add(new ImportedProduct(name, price, customFee));
            }
            else if (op == 'u') {
                System.out.print("Manufactured date (DD/MM/YYYY): ");
                manufactureDate = sdf.parse(sc.next());

                productList.add(new UsedProduct(name, price, manufactureDate));
            }
        }
        System.out.println("PRICE TAGS: ");

        for(Product prd : productList){
            System.out.println(prd.priceTag());
        }
        //ou
        //for(Product prd : productList){
        //  System.out.println(prd);
        //}
    }
}

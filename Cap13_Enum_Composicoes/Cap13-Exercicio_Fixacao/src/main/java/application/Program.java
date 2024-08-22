package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Program
{
    public static void main( String[] args ) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth date (dd/MM/yyyy): ");
        Date birthDate = sdf.parse(sc.nextLine());

        Client client = new Client(clientName, clientEmail, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: " + new ArrayList<OrderStatus>(Arrays.asList(OrderStatus.values()))+": ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), orderStatus, client);

        System.out.print("How many items to this order? ");
        int oI = sc.nextInt();

        for(int i=1; i<=oI; i++){
            System.out.println("Enter #"+i+" item data");
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int orderQuantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(orderQuantity, productPrice, product);

            order.addItem(orderItem);
        }
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);
    }
}

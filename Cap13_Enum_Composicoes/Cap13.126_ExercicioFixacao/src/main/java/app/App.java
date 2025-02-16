/*Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um
        sumário do pedido conforme exemplo (próxima página). Nota: o instante do pedido deve ser
        o instante do sistema: new Date()*/

package app;

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

public class App
{
    public static void main( String[] args ) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println( "Enter client data:" );
        System.out.print( "Name: " );
        String name = sc.nextLine();
        System.out.print( "Email: " );
        String email = sc.nextLine();
        System.out.print( "Birth date (dd/MM/yyyy): " );
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        System.out.println( "Enter order data: ");
        //Exibe a lista de Enums
        System.out.print("Status: " + new ArrayList<OrderStatus>(Arrays.asList(OrderStatus.values()))+": ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.print( "How many items to this order? " );
        int qtdItems = sc.nextInt();

        for (int x = 1; x <= qtdItems; x++) {
            System.out.println( "Enter #"+x+" item data:" );
            System.out.print( "Product name: " );
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print( "Product price: " );

            double productPrice = sc.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print( "Quantity: " );
            int productQtd = sc.nextInt();
            System.out.println();

            OrderItem orderItem = new OrderItem(productQtd, productPrice, product);

            order.addItem(orderItem);
        }

        System.out.println( "ORDER SUMMARY:" );
        System.out.println(order);

        sc.close();
    }
}

package aplicattion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String y = sc.nextLine();
		Date birthDate = sdf.parse(y);

		Client cliente = new Client(nameClient, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		Order order = new Order(new Date(), status, cliente);
		
		for(int i=1; i<=n; i++) {
			System.out.println("Enter #"+ i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(name, price);
			
			OrderItem item = new OrderItem(quantity, price, product);
			
			order.addItem(item);
			
		}
		System.out.println("ORDER SUMMARY:");
		
		System.out.println(order);
		
		

		sc.close();

	}

}

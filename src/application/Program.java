package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String args[]) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		List<Product> listProducts = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int quantityProducts = sc.nextInt();
		
		for (int i = 1; i <= quantityProducts; i++) {
			System.out.println("\nProduct #" + i + " data:");
			
			System.out.print("Commom, used or imported (c/u/i)? ");
			char typeProduct = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			sc.nextLine();
			
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if (typeProduct == 'u') {
				System.out.print("Manufacture date (dd/MM/yyyy): ");
				Date manufactureDate = dateFormat.parse(sc.next());			
				listProducts.add(new UsedProduct(name, price, manufactureDate));
			} else if (typeProduct == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				listProducts.add(new ImportedProduct(name, price, customsFee));
			} else {
				listProducts.add(new Product(name, price));
			}			
		}
		
		System.out.print("\nPRICE TAGS:");
		for (Product product : listProducts) {
			System.out.print("\n" + product.priceTag());
		}
		
		sc.close();
	}
}
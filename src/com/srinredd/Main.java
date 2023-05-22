package com.srinredd;

import java.time.Year;
import java.util.List;
import java.util.Scanner;

import com.srinredd.model.Product;
import com.srinredd.service.ProductService;

public class Main {

	public static boolean closeApplication = false;

	public static void main(String[] args) {

		ProductService service = new ProductService();

//		Add some pre existing products  
		service.addSomeData();

		while (!closeApplication) {
			service.display();

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			String input = scanner.nextLine();

			if (input.equals("0")) {

				service.closeTheProgram();

			} else if (input.equals("1")) {

				System.out.println("Searching for a particular product");
				System.out.println("Please enter product name: ");

				String productName = scanner.nextLine();
				Product getProduct = service.getProduct(productName);

				System.out.println(getProduct);

			} else if (input.equals("2")) {

				System.out.println("Searching for a particular text or keyword");
				System.out.println("Please enter text/keyword: ");

				String text = scanner.nextLine();

				List<Product> products = service.getProductWithText(text);
				for (Product product : products) {
					System.out.println(product);
				}

			} else if (input.equals("3")) {

				System.out.println("Searching a product by place");
				System.out.println("Please enter place to find whatever products are available: ");

				String place = scanner.nextLine();

				List<Product> productsByPlace = service.getAllProductsByPlace(place);
				for (Product product : productsByPlace) {
					System.out.println(product);
				}

			} else if (input.equals("4")) {

				System.out.println("Displaying products that are out of warranty");

				int currentYear = Year.now().getValue();

				List<Product> productsOutOfWarranty = service.getAllProductsOutOfWarranty(currentYear);
				for (Product product : productsOutOfWarranty) {
					System.out.println(product);
				}

			} else if (input.equals("5")) {

				System.out.println("List of products that are available");

				List<Product> products = service.getAllProducts();
				for (Product product : products) {
					System.out.println(product);
				}

			} else if(input.equals("6")) {
				
				System.out.println("Enter product name");
				String productName = scanner.nextLine();
				
				System.out.println("Enter product type");
				String productType = scanner.nextLine();
				
				System.out.println("Enter product place");
				String productPlace = scanner.nextLine();
				
				System.out.println("Enter product warranty");
				int warranty = 0;
				try {
					warranty = scanner.nextInt();
				} catch (Exception e) {
					System.out.println("It should a year in number format");
					System.out.println("Product has not been added. Try again!");
					continue;
				}
				
				Product product = new Product(productName, productType, productPlace, warranty);
				
				service.addProduct(product);
				System.out.println("Product has been added successfully!");
				
			}else {

				System.out.println("Invalid Key");
				System.out.println("Do you want to try again? Yes or No");

				String userInput = scanner.nextLine();

				if (userInput.toLowerCase().equals("yes")) {
					service.display();
				} else {
					service.closeTheProgram();
				}

			}

		}

	}

}
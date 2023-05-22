package com.srinredd.service;

import java.util.ArrayList;
import java.util.List;

import com.srinredd.Main;
import com.srinredd.model.Product;

public class ProductService {

	List<Product> products = new ArrayList<>();

	public void addProduct(Product product) {
		products.add(product);
	}

	public List<Product> getAllProducts() {
		return products;
	}

	public Product getProduct(String nameOfProduct) {
		for (Product product : products) {
			if (product.getName().equals(nameOfProduct)) {
				return product;
			}
		}
		return null;
	}

	public List<Product> getProductWithText(String text) {
		String textLowerCase = text.toLowerCase();
		List<Product> results = new ArrayList<>();
		for (Product product : products) {
			
			String productName = product.getName().toLowerCase();
			String productType = product.getType().toLowerCase();
			String productPlace = product.getPlace().toLowerCase();

			if (productName.contains(textLowerCase) || productType.contains(textLowerCase)
					|| productPlace.contains(textLowerCase)) {
				results.add(product);
			}
		}
		return results;
	}

	public List<Product> getAllProductsByPlace(String productPlace) {
		String productPlaceToLowerCase = productPlace.toLowerCase();
		List<Product> results = new ArrayList<>();
		for(Product product: products) {
			String place = product.getPlace().toLowerCase();
			if(place.equals(productPlaceToLowerCase)) {
				results.add(product);
			}
		}
		return results;
	}

	public List<Product> getAllProductsOutOfWarranty(int year) {
		List<Product> results = new ArrayList<>();
		for(Product product: products) {
			if(product.getWarranty()<year) {
				results.add(product);
			}
		}
		return results;
	}

	public void closeTheProgram() {
		Main.closeApplication = true;
		System.out.println("Terminated successfully");
		System.exit(0);
	}

	public void display() {
		System.out.println("==================================================");
		System.out.println("Welcome to my application - Product Management App");
		System.out.println("1. Search for a particular product");
		System.out.println("2. Search for a particular text/keyword");
		System.out.println("3. Search by a product place");
		System.out.println("4. Search for products that are out of warranty");
		System.out.println("5. Display all the products");
		System.out.println("Please enter a key to proceed or 0 to exit");
	}

	public void addSomeData() {
		addProduct(new Product("Asus Vivobook", "Laptop", "Brown Table", 2022));
		addProduct(new Product("Mac Studio", "Computer", "White Table", 2025));
		addProduct(new Product("Focusrite Mixer", "Audio System", "White Table", 2025));
		addProduct(new Product("Asus Vivobook", "Laptop", "Brown Drawer", 2021));
		addProduct(new Product("Asus Rog", "Laptop", "Black Table", 2021));
		addProduct(new Product("Macbook pro", "Laptop", "Brown Drawer", 2022));
		addProduct(new Product("Wacom Pad", "Writing Pad", "Black Drawer", 2020));
		addProduct(new Product("Apple Keyboard", "Keyboard", "White Table", 2022));
		addProduct(new Product("Logitech Keyboard", "Keyboard", "Black Table", 2024));
		addProduct(new Product("Hdmi cable", "Cable", "Black Drawer", 2024));
		addProduct(new Product("Java Black Book", "Cable", "Shelf", 2024));
		addProduct(new Product("Logi Mouse", "Mouse", "Black Table", 2022));
		addProduct(new Product("Apple Mouse", "Mouse", "White Table", 2022));
		addProduct(new Product("Lenovo Mouse", "Mouse", "Black Drawer", 2022));
		addProduct(new Product("BlackBeast", "Computer", "White Table", 2020));
		
	}

}

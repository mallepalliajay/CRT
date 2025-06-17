import java.util.ArrayList;
import java.util.Scanner;

// Product class to represent each item
class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + " | Name: " + name + " | Price: $" + price;
    }
}

// Main application class
public class EcommerceInventory {

    static ArrayList<Product> productList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int productIdCounter = 1;

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> deleteProduct();
                case 3 -> updatePrice();
                case 4 -> viewProducts();
                case 5 -> System.out.println("Exiting the program. Thank you!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    static void showMenu() {
        System.out.println("\n--- E-commerce Inventory Menu ---");
        System.out.println("1. Add Product");
        System.out.println("2. Delete Product");
        System.out.println("3. Update Product Price");
        System.out.println("4. View Products");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Product newProduct = new Product(productIdCounter++, name, price);
        productList.add(newProduct);
        System.out.println("Product added successfully.");
    }

    static void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        int id = scanner.nextInt();
        boolean removed = productList.removeIf(p -> p.getId() == id);
        if (removed) {
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found.");
        }
    }

    static void updatePrice() {
        System.out.print("Enter product ID to update price: ");
        int id = scanner.nextInt();
        boolean found = false;

        for (Product product : productList) {
            if (product.getId() == id) {
                System.out.print("Enter new price: ");
                double newPrice = scanner.nextDouble();
                product.setPrice(newPrice);
                System.out.println("Price updated.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }

    static void viewProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("\n--- Product List ---");
            for (Product p : productList) {
                System.out.println(p);
            }
        }
    }
}

package ro.fasttrackit.homework6.products.client;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ro.fasttrackit.homework6.products.client.model.Product;
import ro.fasttrackit.homework6.products.client.service.ProductService;

import java.util.Scanner;

import static ro.fasttrackit.homework6.products.client.model.Category.FOOD;

@ShellComponent
@RequiredArgsConstructor
public class ProductCommands {
    private final ProductService service;

    @ShellMethod("Print all")
    void getAll() {
        service.getAll()
                .forEach(System.out::println);
    }

    @ShellMethod("Print by: category")
    void getByCategory() {
        System.out.println("Category: ");
        Scanner scanner = new Scanner(System.in);
        var category = scanner.nextLine();
        service.getProductsByCategory(category)
                .forEach(System.out::println);
    }

    @ShellMethod("Print by: maxPrice")
    void getByMaxPrice() {
        System.out.println("Max price: ");
        Scanner scanner = new Scanner(System.in);
        var maxPrice = scanner.nextDouble();
        service.getProductsByMaxPrice(maxPrice)
                .forEach(System.out::println);
    }

    @ShellMethod("Add product")
    void addProduct() {
        System.out.println(service.addProduct(
                new Product(0L, "Bread", 1, "garlic", FOOD)));
    }

    @ShellMethod("Remove product")
    void removeProduct() {
        System.out.println("ID: ");
        Scanner scanner = new Scanner(System.in);
        var productId = scanner.nextLong();
        System.out.println(service.removeProduct(productId));
    }
}

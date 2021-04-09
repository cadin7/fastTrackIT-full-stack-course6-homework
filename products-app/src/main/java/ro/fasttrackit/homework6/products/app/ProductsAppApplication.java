package ro.fasttrackit.homework6.products.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.homework6.products.app.domain.Category;
import ro.fasttrackit.homework6.products.app.domain.Product;
import ro.fasttrackit.homework6.products.app.repository.ProductRepository;

import java.util.List;

import static ro.fasttrackit.homework6.products.app.domain.Category.*;

@SpringBootApplication
public class ProductsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsAppApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(ProductRepository repository){
        return args ->
                repository.saveAll(List.of(
                        new Product("TV", 532.5, "16K", ELECTRONICS),
                        new Product("PC", 298.5, "average", ELECTRONICS),
                        new Product("Nike", 130, "shoe", CLOTHES),
                        new Product("Apple", 2.5, "16K", FOOD)
                ));
    }
}

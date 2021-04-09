package ro.fasttrackit.homework6.products.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.homework6.products.app.domain.Product;
import ro.fasttrackit.homework6.products.app.repository.ProductRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getProducts(String category, Double maxPrice) {
        return repository.findAll()
                .stream()
                .filter(product -> category == null || product.getCategory().name().equalsIgnoreCase(category))
                .filter(product -> maxPrice == null || product.getPrice() <= maxPrice)
                .collect(toUnmodifiableList());
    }

    public Optional<Product> getProduct(Long productId) {
        return repository.findAll()
                .stream()
                .filter(product -> Objects.equals(product.getId(), productId))
                .findFirst();
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public Optional<Product> deleteProduct(Long productId) {
        var productToDelete = getProduct(productId);
        repository.deleteById(productId);
        return productToDelete;
    }
}

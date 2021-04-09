package ro.fasttrackit.homework6.products.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.homework6.products.app.domain.Product;
import ro.fasttrackit.homework6.products.app.exceptions.ResourceNotFoundException;
import ro.fasttrackit.homework6.products.app.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {
    private final ProductService service;

    @GetMapping
    List<Product> getProducts(@RequestParam(required = false) String category,
                              @RequestParam(required = false) Double maxPrice) {
        return service.getProducts(category, maxPrice);
    }

    @GetMapping("{productId}")
    Product getProduct(@PathVariable Long productId) {
        return service.getProduct(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find product with ID: " + productId));
    }

    @PostMapping
    Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @DeleteMapping("{productId}")
    Product deleteProduct(@PathVariable Long productId) {
        return service.deleteProduct(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find product with ID: " + productId));
    }
}
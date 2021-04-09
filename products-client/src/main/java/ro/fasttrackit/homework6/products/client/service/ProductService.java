package ro.fasttrackit.homework6.products.client.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.fasttrackit.homework6.products.client.model.Product;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class ProductService {
    private final String URL = "http://localhost:8080/products";

    public List<Product> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                URL,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public List<Product> getProductsByCategory(String category) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                URL + "?category=" + category,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public List<Product> getProductsByMaxPrice(Double maxPrice) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                URL + "?maxPrice=" + maxPrice,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public Product addProduct(Product newProduct) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(URL, newProduct, Product.class);
    }

    public Product removeProduct(Long productId) {
        RestTemplate restTemplate = new RestTemplate();
        var oldProduct = restTemplate.getForObject(URL + "/" + productId, Product.class);
        restTemplate.delete(URL + "/" + productId);
        return oldProduct;
    }
}

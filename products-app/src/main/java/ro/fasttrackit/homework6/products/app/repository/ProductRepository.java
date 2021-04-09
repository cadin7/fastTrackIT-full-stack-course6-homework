package ro.fasttrackit.homework6.products.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.homework6.products.app.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

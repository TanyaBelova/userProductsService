package products.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import products.service.model.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByActive(Boolean active);
}

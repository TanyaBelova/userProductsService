package products.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import products.service.model.Product;
import products.service.model.UserProductRelations;
import products.service.service.ProductsService;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    private final ProductsService productService; // что это

    @Autowired
    // говорит спрингу, что в этом месте необходимо внедрить зависимость.
    // В конструктор мы передаем интерфейс.
    // Реализацию данного сервиса пометили аннотацией @Service ранее

    public ProductController(ProductsService productService) {
        this.productService = productService;
    }

    // данный метод обрабатывает POST запросы на адрес /products
    @PostMapping(value = "/products")
    public ResponseEntity<?> create(@RequestParam String name) {
        productService.create(name);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/products")
    // данный метод обрабатывает GET запросы на адрес /products
    public ResponseEntity<List<Product>> readActive() {
        final List<Product> products = productService.readActive();

        return products != null &&  !products.isEmpty()
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/products/{userId}")
    public ResponseEntity<List<Product>> readActive(@PathVariable(name = "userId") UUID userId) {
        final List<Product> products = productService.readActive(userId);

        return products != null &&  !products.isEmpty()
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/userRelations")
    public ResponseEntity<?> createRelation(@RequestBody UserProductRelations userProductRelations) {

        final boolean created = productService.createRelation(userProductRelations);

        return created
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping(value = "/productActivity")
    public ResponseEntity<?> updateActivity(@RequestParam(name = "id") UUID id, @RequestParam(name = "active") boolean active) {
        final boolean updated = productService.updateActivity(id, active);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id) {
        final boolean deleted = productService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/userRelations/{id}")
    public ResponseEntity<?> deleteRelation(@PathVariable(name = "id") UUID id) {
        final boolean deleted = productService.deleteRelation(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

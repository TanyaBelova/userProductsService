package products.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import products.service.model.entity.Product;
import products.service.model.entity.UserProductRelations;
import products.service.repository.ProductRepository;
import products.service.repository.UserProductsRelationsRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService{

    private final ProductRepository productRepository;
    private final UserProductsRelationsRepository userProductsRelationsRepository;

    @Override
    @Transactional
    public void create(String name) {
        Product product = new Product();
        product.setName(name);
        product.setCreationDate(new Date());
        product.setActive(true);
        productRepository.save(product);
    }

    @Override
    public List<Product> readActive() {
        return productRepository.findByActive(true);
    }

    @Override
    public List<Product> readActive(UUID userId) {
        List<UUID> productsId = userProductsRelationsRepository.findAllByUserId(userId);
        List<Product> products = new ArrayList<>();
        for(UUID id: productsId){
            Product product = productRepository.getReferenceById(id);
            if(product.isActive()){
                products.add(product);
            }
        }
        return products;
    }

    @Override
    @Transactional
    public boolean createRelation(UserProductRelations userProductRelations) {
        if(userProductsRelationsRepository.findByUserIdAndProductId(userProductRelations.getUserId(), userProductRelations.getProductId()) == null){
            userProductsRelationsRepository.save(userProductRelations);
            return true;
        };
        return false;
    }

    @Override
    @Transactional
    public boolean updateActivity(UUID id, boolean active) {
/*
        productRepository.findById(id)
                .ifPresent(product -> product.setActive(active));
*/
        if (productRepository.existsById(id)) {
            Product product = productRepository.findById(id).get();
            product.setActive(active);
            productRepository.save(product);
            return true;
        }

        return false;
    }

    @Override
    @Transactional
    public boolean delete(UUID id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteRelation(UUID id) {
        if (userProductsRelationsRepository.existsById(id)) {
            userProductsRelationsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

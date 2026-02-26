package products.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import products.service.model.UserProductRelations;

import java.util.List;
import java.util.UUID;

public interface UserProductsRelationsRepository extends JpaRepository<UserProductRelations, UUID> {

    @Query("SELECT p.productId from UserProductRelations p where p.userId = :userId")
    List<UUID> findAllByUserId(@Param("userId") UUID userId);

    @Query("SELECT p from UserProductRelations p where p.userId = :userId and p.productId = :productId")
    UserProductRelations findByUserIdAndProductId(@Param("userId") UUID userId, @Param("productId") UUID productId);
}

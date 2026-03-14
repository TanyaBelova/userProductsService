package products.service.model.dto;

import java.util.UUID;

public record UserProductRelationsDto(UUID id, UUID userId, UUID productId) {
}

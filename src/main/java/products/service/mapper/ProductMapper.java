package products.service.mapper;

import org.mapstruct.Mapper;
import products.service.model.dto.ProductDto;
import products.service.model.entity.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toProductDto(Product product);
    List<ProductDto> toProductDtoList(List<Product> products);
}

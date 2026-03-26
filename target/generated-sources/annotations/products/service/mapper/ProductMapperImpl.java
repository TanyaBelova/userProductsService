package products.service.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import products.service.model.dto.ProductDto;
import products.service.model.entity.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-26T22:25:35+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        boolean active = false;

        id = product.getId();
        name = product.getName();
        active = product.isActive();

        ProductDto productDto = new ProductDto( id, name, active );

        return productDto;
    }

    @Override
    public List<ProductDto> toProductDtoList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( toProductDto( product ) );
        }

        return list;
    }
}

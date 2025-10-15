package chdtu.Test.Project.mapper;

import chdtu.Test.Project.dto.ProductDTO;
import chdtu.Test.Project.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "category", target = "category")
    Product createProduct(ProductDTO productDTO);

    @Mapping(target = "id", ignore = true)
    void updateProduct(ProductDTO productDTO,
                              @MappingTarget Product product);

    ProductDTO toDto(Product product);

}
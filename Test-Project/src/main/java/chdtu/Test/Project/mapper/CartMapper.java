package chdtu.Test.Project.mapper;

import chdtu.Test.Project.dto.CartDTO;
import chdtu.Test.Project.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CartMapper {
    @Mapping(source = "customer.fullName", target = "customerFullName")
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "id", target = "cartId")
    CartDTO toDto(Cart cart);
}

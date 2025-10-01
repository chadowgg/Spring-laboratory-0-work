package chdtu.Test.Project.mapper;

import chdtu.Test.Project.dto.CustomerDTO;
import chdtu.Test.Project.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    Customer createCustomer(CustomerDTO customerDTO);

    @Mapping(target = "id", ignore = true)
    void updateCustomer(CustomerDTO customerDTO,
                       @MappingTarget Customer customer);

    CustomerDTO toDto(Customer customer);
}

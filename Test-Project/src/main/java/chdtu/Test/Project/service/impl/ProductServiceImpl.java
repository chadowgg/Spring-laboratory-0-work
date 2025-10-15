package chdtu.Test.Project.service.impl;

import chdtu.Test.Project.dto.ProductDTO;
import chdtu.Test.Project.entity.Product;
import chdtu.Test.Project.exception.DataExistException;
import chdtu.Test.Project.exception.NotFoundException;
import chdtu.Test.Project.mapper.ProductMapper;
import chdtu.Test.Project.constants.ApiErrorMessage;
import chdtu.Test.Project.repositories.ProductRepository;
import chdtu.Test.Project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        if (productRepository.existsByProductName(productDTO.getProductName())) {
            throw new DataExistException(ApiErrorMessage.PRODUCT_ALREADY_EXISTS.getMessage(productDTO.getProductName()));
        }

        Product product = productMapper.createProduct(productDTO);
        Product newProduct = productRepository.save(product);
        return productMapper.toDto(newProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ApiErrorMessage.PRODUCT_NOT_FOUND_BY_ID.getMessage(id)));
        productMapper.updateProduct(productDTO, product);
        product = productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.PRODUCT_NOT_FOUND_BY_ID.getMessage(id)));
        productRepository.delete(product);
    }

    @Override
    public ProductDTO getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ApiErrorMessage.PRODUCT_NOT_FOUND_BY_ID.getMessage(id)));
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toDto)
                .toList();
    }
}

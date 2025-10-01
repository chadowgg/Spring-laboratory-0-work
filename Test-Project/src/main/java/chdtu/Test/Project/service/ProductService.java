package chdtu.Test.Project.service;

import chdtu.Test.Project.dto.ProductDTO;
import chdtu.Test.Project.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
    ProductDTO getProduct(Long id);
    List<ProductDTO> getAllProducts();
}

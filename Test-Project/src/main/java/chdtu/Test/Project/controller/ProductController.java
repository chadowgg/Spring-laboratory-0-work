package chdtu.Test.Project.controller;

import chdtu.Test.Project.dto.ProductDTO;
import chdtu.Test.Project.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.SoftDelete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${end.point.product}")
public class ProductController {
    private final ProductService productService;

    @PostMapping("${end.points.create}")
    ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO createdProductDTO = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductDTO);
    }

    @PatchMapping("${end.points.id}")
    ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        ProductDTO updateProductDTO = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok(updateProductDTO);
    }

    @GetMapping("${end.points.id}")
    ResponseEntity<ProductDTO> getProduct(@PathVariable Long id){
        ProductDTO getProductDTO = productService.getProduct(id);
        return ResponseEntity.ok(getProductDTO);
    }

    @DeleteMapping("${end.points.id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("${end.points.all}")
    ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> getAllProducts = productService.getAllProducts();
        return ResponseEntity.ok(getAllProducts);
    }
}

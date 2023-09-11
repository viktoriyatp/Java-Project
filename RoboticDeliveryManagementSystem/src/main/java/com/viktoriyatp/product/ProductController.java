package com.viktoriyatp.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {
  public final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products")
  ResponseEntity<List<ProductDto>> getAllProducts() {
    return ResponseEntity.ok(productService.getAllProducts());
  }

  @GetMapping("/products/{id}")
  ResponseEntity<ProductDto> getProductById(@PathVariable int id) {
    return ResponseEntity.ok(productService.getProductById(id));
  }

  @PostMapping("/products")
  ResponseEntity<ProductDto> addProduct(@RequestBody ProductRequestDto productRequestDto) {
    ProductDto productDto = productService.addProduct(productRequestDto);

    URI location = UriComponentsBuilder.fromUriString("/products/{id}").buildAndExpand(productDto.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @PutMapping("/products/{id}")
  ResponseEntity<ProductDto> updateProduct(@PathVariable int id ,@RequestBody ProductRequestDto productRequestDto) {
    productService.updateProduct(id, productRequestDto);

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/products/{id}")
  ResponseEntity<Void> deleteProduct(@PathVariable int id) {
    productService.deleteProduct(id);

    return ResponseEntity.noContent().build();
  }

  @PatchMapping("/products/{id}")
  ResponseEntity<ProductDto> addMoreProductById(@PathVariable int id, @RequestBody ProductRequestAmount productRequestAmount) {
    productService.addMoreOfProductById(id,productRequestAmount);

    return ResponseEntity.noContent().build();
  }
}

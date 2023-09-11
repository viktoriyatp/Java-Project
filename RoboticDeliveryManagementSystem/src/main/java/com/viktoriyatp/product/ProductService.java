package com.viktoriyatp.product;

import java.util.List;

public interface ProductService {
  List<ProductDto> getAllProducts();
  ProductDto getProductById(int id);
  ProductDto addProduct(ProductRequestDto productRequestDto);
  ProductDto updateProduct(int id, ProductRequestDto productRequestDto);
  void deleteProduct(int id);
  ProductDto addMoreOfProductById(int id, ProductRequestAmount amount);
}

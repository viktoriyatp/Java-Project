package com.viktoriyatp.product;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  ProductDto toProductDto(Product product);
  Product toProduct(ProductRequestDto productRequestDto);
  void updateProduct(@MappingTarget Product product, ProductRequestDto productRequestDto);
}

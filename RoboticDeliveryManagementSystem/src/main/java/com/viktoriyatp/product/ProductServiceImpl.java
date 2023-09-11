package com.viktoriyatp.product;

import com.viktoriyatp.exceptions.ProductNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.viktoriyatp.constants.ProductConstants.PRODUCT_NOT_FOUND;

@Service
public class ProductServiceImpl implements ProductService{
  public final ProductRepository productRepository;
  public final ProductMapper productMapper;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
  }

  @Override
  public List<ProductDto> getAllProducts() {
    return productRepository.findAll().stream().map(productMapper::toProductDto).collect(Collectors.toList());
  }

  @Override
  public ProductDto getProductById(int id) {
    Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFound(String.format(PRODUCT_NOT_FOUND,id)));

    return productMapper.toProductDto(product);
  }

  @Override
  public ProductDto addProduct(ProductRequestDto productRequestDto) {
    Product product = productMapper.toProduct(productRequestDto);

    productRepository.save(product);

    return productMapper.toProductDto(product);
  }

  @Override
  public ProductDto updateProduct(int id, ProductRequestDto productRequestDto) {
    Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFound(String.format(PRODUCT_NOT_FOUND,id)));

    productMapper.updateProduct(product, productRequestDto);
    productRepository.save(product);

    return productMapper.toProductDto(product);
  }

  @Override
  public void deleteProduct(int id) {
    boolean doesExist = productRepository.existsById(id);

    if(!doesExist) {
      throw new ProductNotFound(String.format(PRODUCT_NOT_FOUND,id));
    }

    productRepository.deleteById(id);
  }

  @Override
  public ProductDto addMoreOfProductById(int id, ProductRequestAmount amount) {
    Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFound(String.format(PRODUCT_NOT_FOUND,id)));

    int currentQuantity = product.getCurrentQuantity();
    int amountToAdd = amount.getAmount();
    product.setCurrentQuantity(currentQuantity + amountToAdd);
    productRepository.save(product);

    return productMapper.toProductDto(product);
  }
}

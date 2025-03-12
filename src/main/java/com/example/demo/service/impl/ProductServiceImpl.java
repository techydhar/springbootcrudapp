package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductsEntity;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.ProductsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductsService{
    private ProductsRepository productsRepository;

    @Override
    public ProductsEntity create(ProductsEntity product) {
      return productsRepository.save(product);
    }

    @Override
    public void deleteProductEntity(Long productId) {
        productsRepository.deleteById(productId);
     }

    @Override
    public ProductsEntity gProductsEntityById(Long productId) {
       Optional<ProductsEntity> optionalProductEntity = productsRepository.findById(productId);
        return optionalProductEntity.get();
    }

    @Override
    public List<ProductsEntity> getAllProducts() {
     return productsRepository.findAll();
    }

    @Override
    public ProductsEntity updateProductsEntity(ProductsEntity product) {
        ProductsEntity existingProductsEntity = productsRepository.findById(product.getId()).get();
        existingProductsEntity.setProductName(product.getProductName());
        existingProductsEntity.setProductPrice(product.getProductPrice());
        ProductsEntity updaProductsEntity = productsRepository.save(existingProductsEntity);
        return updaProductsEntity;
    }
    
}

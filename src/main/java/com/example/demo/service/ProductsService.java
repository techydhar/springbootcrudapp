package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProductsEntity;

public interface ProductsService {
  ProductsEntity create(ProductsEntity product);
  ProductsEntity gProductsEntityById(Long productId);
  List<ProductsEntity>getAllProducts();
  ProductsEntity updateProductsEntity(ProductsEntity product);
  void deleteProductEntity(Long productId);
}

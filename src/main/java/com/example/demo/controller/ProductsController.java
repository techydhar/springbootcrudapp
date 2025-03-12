package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductsEntity;
import com.example.demo.service.ProductsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductsController {
 private ProductsService productsService;
 @PostMapping
 public ResponseEntity<ProductsEntity> create(@RequestBody ProductsEntity product){
   ProductsEntity savedProductEntity =  productsService.create(product);
   return new ResponseEntity<>(savedProductEntity, HttpStatus.CREATED);
 }
 @GetMapping("{id}")
 public ResponseEntity<ProductsEntity> getProductByIdEntity(@PathVariable("id") Long productId){
  ProductsEntity productsEntity = productsService.gProductsEntityById(productId);
  return new ResponseEntity<>(productsEntity, HttpStatus.OK);
 }
 @GetMapping
 public ResponseEntity<List<ProductsEntity>>getAllProducts(){
  List<ProductsEntity> productsEntities = productsService.getAllProducts();
  return new ResponseEntity<>(productsEntities, HttpStatus.OK);
}
@PutMapping("{id}")
public ResponseEntity<ProductsEntity> updateProductsEntity(@PathVariable("id") Long productId, @RequestBody ProductsEntity productsEntity){
  productsEntity.setId(productId);
  ProductsEntity updateProductsEntity = productsService.updateProductsEntity(productsEntity);
  return new ResponseEntity<>(updateProductsEntity, HttpStatus.OK);
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteProductEntity(@PathVariable("id") Long productId){
  productsService.deleteProductEntity(productId);
  return new ResponseEntity<>("User successfully deleted!",HttpStatus.OK);
}
}

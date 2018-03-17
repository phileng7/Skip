package com.skip.service;

import java.util.List;

import com.skip.entity.Product;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    boolean addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    List<Product> searchText(String text);
}

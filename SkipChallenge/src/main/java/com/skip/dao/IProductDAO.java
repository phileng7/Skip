package com.skip.dao;

import java.util.List;

import com.skip.entity.Product;

public interface IProductDAO {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    List<Product> searchText(String text);
    public boolean productExists(int id);
}

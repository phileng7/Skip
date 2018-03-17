package com.skip.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skip.dao.IProductDAO;
import com.skip.entity.Product;

@Service
public class ProductService implements IProductService {
	@Autowired
	private IProductDAO productDAO;
	
	@Override
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	@Override
	public Product getProductById(int id) {
		Product obj = productDAO.getProductById(id);
		return obj;
	}

	@Override
	public boolean addProduct(Product product) {
        if (productDAO.productExists(product.getId())) {
            return false;
        } else {
        	productDAO.addProduct(product);
            return true;
        }
	}

	@Override
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}

	@Override
	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);
	}

	@Override
	public List<Product> searchText(String text) {
		List<Product> products = productDAO.searchText(text);
		return products;
	}
}

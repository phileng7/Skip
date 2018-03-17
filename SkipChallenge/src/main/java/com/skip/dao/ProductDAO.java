package com.skip.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skip.entity.Product;

@Transactional
@Repository
public class ProductDAO implements IProductDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<Product> getAllProducts() {
		String hql = "FROM Product as prod ORDER BY prod.id";
		return (List<Product>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Product getProductById(int id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);
	}

	@Override
	public void updateProduct(Product product) {
		Product prod = getProductById(product.getId());
		prod.setStoreId(product.getId());
		prod.setName(product.getName());
		prod.setDescription(product.getDescription());
		prod.setPrice(product.getPrice());
		entityManager.flush();
	}

	@Override
	public void deleteProduct(int id) {
		entityManager.remove(getProductById(id));

	}

	@Override
	public List<Product> searchText(String text) {
		String hql = "FROM Product as prod where prod.name like'" + text + "%'";
		return (List<Product>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public boolean productExists(int id) {
		String hql = "FROM Product as prod WHERE prod.id = ?";
		int count = entityManager.createQuery(hql).setParameter(0, id).getResultList().size();
		return count > 0 ? true : false;
	}
}

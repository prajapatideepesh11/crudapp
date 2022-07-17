package crudapp.dao;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;


import crudapp.model.Product;

@Component
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernatetemplate;
	
	//create
	@Transactional
	public void createProduct(Product product) {
		
		this.hibernatetemplate.save(product);
	}
	
	//get all product
	public List<Product> getProducts(){
		
		List<Product> products = this.hibernatetemplate.loadAll(Product.class);
		return products;
	}
	
	//delete a single product
	@Transactional
	public void deleteProduct(int pid) {
		Product p =this.hibernatetemplate.load(Product.class,pid);
		this.hibernatetemplate.delete(p);
	}
	
	//get the single product
	public Product getProduct(int pid) {
		return this.hibernatetemplate.get(Product.class,pid);
	}

}

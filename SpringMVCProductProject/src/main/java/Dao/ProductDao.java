package Dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import Model.Product;
import antlr.collections.List;

@Component
public class ProductDao {
	
	@Autowired
  private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createProduct(Product product)
	{
		this.hibernateTemplate.save(product);
	}
	
	//get all products
	public List getProducts()
	{
		List products=(List) this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//delete the single product product
	public void deleteProduct(int pid)
	{
		Product p = this.hibernateTemplate.load(Product.class,pid);
		this.hibernateTemplate.delete(p);
	}
	
	
	
}

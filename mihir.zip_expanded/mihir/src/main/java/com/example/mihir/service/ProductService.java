paWckage com.example.mihir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mihir.entity.ProductEntity;
import com.example.mihir.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repo;
	
	public List<ProductEntity> getProducts() {
		return repo.findAll();
	}
	
	public String addProduct(ProductEntity product) {
		repo.save(product);
		return "Added Successfully";
	}
	
	public List<String> updateProduct(int id){
		
		return null;
	}
	
	public String editProduct(int id, ProductEntity updateProduct) {
		
		if(repo.findById(id).isEmpty()) {
			return "Product is not available";
			
		} else {
			ProductEntity p = repo.findById(id).get();
			p.setName(updateProduct.getName());
			p.setPrice(updateProduct.getPrice());
			p.setCategory(updateProduct.getCategory());
			repo.save(p);
			return "Product Updated Successfully";
		}
	}
	
	public String deleteProduct(int id) {
		if(repo.findById(id).isEmpty()) {
			return "Product is not available";
		} else {
			ProductEntity p = repo.findById(id).get();
			repo.delete(p);
			return "Product Deleted Successfully";
		}
	}
}

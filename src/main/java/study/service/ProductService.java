package study.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import study.model.Product;
import study.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void saveProduct(MultipartFile file, String name,
			String description, int price) throws IOException {
		
		Product product = new Product();
		String multipartFile = StringUtils.cleanPath(file.getOriginalFilename());
		if(multipartFile.contains("..")) {
			System.out.println("File selected is not a valid one");
		}
		
		product.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		
		productRepository.save(product);
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
}

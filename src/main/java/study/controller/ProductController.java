package study.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import study.model.Product;
import study.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@PostMapping("/add")
	public String saveRecord(@RequestParam MultipartFile file,
			String name, String description, int price) throws IOException {
		
		productService.saveProduct(file, name, description, price);
		return "Record saved successfully";
	}
	
	@GetMapping("/findAll")
	@ResponseBody
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	
}

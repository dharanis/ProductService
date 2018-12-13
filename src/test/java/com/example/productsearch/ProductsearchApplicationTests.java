package com.example.productsearch;

import com.example.productsearch.Controller.ProductController;
import com.example.productsearch.Entity.Product;
import com.example.productsearch.Service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(value = ProductController.class, secure = false)
public class ProductsearchApplicationTests {


	@Mock
	ProductService productService;
	@Test
	public void contextLoads() {
	}
	@Before
	public void setUp(){
		Product product = Product.builder().brand("Jil Sander").category("dresses").color("orange").price(511).build();
		Product product1 = Product.builder().brand("Jil Sander").category("dresses").color("orange").price(511).build();
		List<Product> listProduct = new ArrayList<Product>();
		listProduct.add(product);
		listProduct.add(product1);
	}

	@Test
	public void getProductByCategoryTest(){
		Product product = Product.builder().brand("Jil Sander").category("dresses").color("orange").price(511).build();
		Product product1 = Product.builder().brand("Jil Sander").category("dresses").color("orange").price(511).build();
		List<Product> listProduct = new ArrayList<Product>();
		listProduct.add(product);
		listProduct.add(product1);
		when(productService.getProductByCategory(anyString())).thenReturn(listProduct);

		List<Product> actual = productService.getProductByCategory("dresses");
		assert(actual.get(0).getCategory().equals(product.getCategory()));
	}

}


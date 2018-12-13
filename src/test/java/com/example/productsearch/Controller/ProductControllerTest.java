package com.example.productsearch.Controller;

import com.example.productsearch.Entity.Product;
import com.example.productsearch.Service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {



    @Mock
    ProductService productService;

    @Before
    public void setUp(){
        Product product = Product.builder().brand("Jil Sander").category("dresses").color("orange").price(511).build();
        Product product1 = Product.builder().brand("Jil Sander").category("dresses").color("orange").price(511).build();
        List<Product> listProduct = new ArrayList<Product>();
        listProduct.add(product);
        listProduct.add(product1);
    }

    @Test
    public void getProductByBranDTest(){
        Product product = Product.builder().brand("Jil Sander").category("dresses").color("orange").price(511).build();
        Product product1 = Product.builder().brand("Jil Sander").category("dresses").color("orange").price(511).build();
        List<Product> listProduct = new ArrayList<Product>();
        listProduct.add(product);
        listProduct.add(product1);
        when(productService.getProductByBrand(anyString())).thenReturn(listProduct);

        List<Product> actual = productService.getProductByBrand("dresses");
        assert(actual.get(0).getBrand().equals(product.getBrand()));
    }

    @Test
    public void getProductByColorTest(){
        Product product = Product.builder().brand("Jil Sander").category("dresses").color("orange").price(511).build();
        Product product1 = Product.builder().brand("Jil Sander").category("dresses").color("orange").price(511).build();
        List<Product> listProduct = new ArrayList<Product>();
        listProduct.add(product);
        listProduct.add(product1);
        when(productService.getProductByColor(anyString())).thenReturn(listProduct);

        List<Product> actual = productService.getProductByColor("orange");
        assert(actual.get(0).getColor().equals(product.getColor()));
    }

    @Test
    public void getProductByPriceRangeTest(){
        Product product = Product.builder().brand("Jil Sander").category("dresses").color("orange").price(511).build();
        Product product1 = Product.builder().brand("Jil Sander").category("dresses").color("orange").price(511).build();
        List<Product> listProduct = new ArrayList<Product>();
        listProduct.add(product);
        listProduct.add(product1);
        when(productService.getProductByPriceRange(anyDouble(),anyDouble())).thenReturn(listProduct);

        List<Product> actual = productService.getProductByPriceRange(400,550);
        assert(actual.get(0).getPrice() == product.getPrice());
    }
}

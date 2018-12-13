package com.example.productsearch.Controller;


import com.example.productsearch.Entity.Product;
import com.example.productsearch.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class ProductController {


public final ProductService productService;

@Autowired
    public ProductController(ProductService productService){
    this.productService = productService;
}

@GetMapping("/filter/brand")
    public List<Product> getProductByCategory(@PathVariable String brand){
    return productService.getProductByCategory(brand);
}


    @GetMapping("/filter/color")
    public List<Product> getProductByColor(@PathVariable String color){
        return productService.getProductByColor(color);
    }

    @GetMapping("/filter/price")
    public List<Product> getProductByPriceRange(@PathVariable double startPrice,@PathVariable double endPrice){
        return productService.getProductByPriceRange(startPrice,endPrice);
    }

    @GetMapping("/price/ascending")
    public List<Product> getProductInAscendingWithPrice()
    {
        return productService.getProductInAscendingWithPrice();
    }

    @GetMapping("/price/descending")
    public List<Product> getProductInDescendingWithPrice()
    {
        return productService.getProductInDescendingWithPrice();
    }

}

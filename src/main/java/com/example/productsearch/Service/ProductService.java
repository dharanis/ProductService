package com.example.productsearch.Service;

import com.example.productsearch.Entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    Product product1 = Product.builder().brand("Gucci").category("dresses").color("yellow").price(2272.00).build();
    Product product2 = Product.builder().brand("Gucci").category("dresses").color("red").price(1966.00).build();
    Product product3 = Product.builder().brand("Marni").category("dresses").color("brown").price(999.00).build();
    Product product4 = Product.builder().brand("Bottega Veneta").category("dresses").color("black").price(2272.00).build();
    Product product5 = Product.builder().brand("Prada").category("dresses").color("black").price(1650.00).build();
    Product product6 = Product.builder().brand("Victoria Beckham").category("dresses").color("blue").price(927.00).build();
    Product product7 = Product.builder().brand("Celine").category("dresses").color("beige").price(1901.00).build();
    Product product8 = Product.builder().brand("Jil Sander").category("dresses").color("orange").price(511).build();
    List<Product> products = new ArrayList<Product>();

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        return products;
    }

    public List<Product> getProductByCategory(String category) {
    List<Product> datas = getAllProducts();
    List<Product> productByCategory = datas.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
        return productByCategory;
    }

    public List<Product> getProductByBrand(String brand) {
        List<Product> datas = getAllProducts();
        List<Product> productByBrand = datas.stream()
                .filter(product -> product.getCategory().equals(brand))
                .collect(Collectors.toList());
        return productByBrand;
    }

    public List<Product> getProductByColor(String color) {
        List<Product> datas = getAllProducts();
        List<Product> productByColor = datas.stream()
                .filter(product -> product.getCategory().equals(color))
                .collect(Collectors.toList());
        return productByColor;
    }

    public List<Product> getProductByPriceRange(double startPrice, double endPrice) {
        List<Product> datas = getAllProducts();
        List<Product> productByPriceRange = datas.stream()
                .filter(product -> (product.getPrice()>=startPrice) || (product.getPrice()<=endPrice))
                .collect(Collectors.toList());
        return productByPriceRange;
    }

    public List<Product> getProductInAscendingWithPrice() {
        List<Product> datas = getAllProducts();
        List<Product> productByPriceRange = datas.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
        return productByPriceRange;
    }

    public List<Product> getProductInDescendingWithPrice() {

        List<Product> datas = getAllProducts();
        List<Product> productByPriceRange = datas.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());
        return datas;
    }
}

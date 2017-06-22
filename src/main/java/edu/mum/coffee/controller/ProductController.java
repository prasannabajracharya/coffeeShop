package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by prasannabajracharya on 6/17/17.
 */
@RestController
@RequestMapping("/rs/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("/create")
    public void create(@RequestBody Product product){
            productService.save(product);
    }

    @GetMapping({"/list"})
    public List<Product> getAllProduct(){
            return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id){
        Product product = productService.getProduct(id);
        productService.delete(product);
    }

    @PutMapping("/update")
    public void update(@RequestBody Product product){
        productService.save(product);
    }
}

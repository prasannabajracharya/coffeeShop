package edu.mum.coffee.ViewController;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

/**
 * Created by prasannabajracharya on 6/20/17.
 */
@Controller
public class ProductViewController {
    @Autowired
    private ProductService productService;

    @GetMapping("/productList")
    public String productList(Model model){

        model.addAttribute("products", productService.getAllProduct());
        return "productList";
    }
}

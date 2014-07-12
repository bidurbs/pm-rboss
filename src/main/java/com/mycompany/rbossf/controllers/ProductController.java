/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rbossf.controllers;

import com.mycompany.rbossf.entity.Product;
import com.mycompany.rbossf.service.ProductService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 * @author ib
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController() {
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAll(Model model) {

        model.addAttribute("products", productService.getAll());
        return "productList";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.get(id));
        return "editProduct";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.POST)
    public String editProduct(@Valid Product product, BindingResult result,
            @PathVariable int id) {
        String view = "redirect:/products";
        if (!result.hasErrors()) {
            productService.update(product);
        } else {
            view = "editProduct";
        }

        return view;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProductGet(@ModelAttribute("product") Product product) {
        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid Product product, BindingResult result, RedirectAttributes re) {
        String view = "redirect:/products";
        if (!result.hasErrors()) {
            productService.add(product);
        } else {
            view = "addProduct";
        }
        return view;
    }

    @RequestMapping(value = "/products/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "productId", required = true) Long prodid) {
        productService.delete(prodid);
        return "redirect:/products";
    }
    
    
    
    @RequestMapping(value="/productResult", method = RequestMethod.GET)
    public String searchProductResult(){
    
        return "productList";
    }
    
    @RequestMapping(value="/searchProduct", method = RequestMethod.POST)
    public String searchProduct(RedirectAttributes re, Model model, String productName){
      List<Product> products =  productService.findProductByName(productName);
        
        if(products.size()>0) {  //searched product found           
          re.addFlashAttribute("products", products); 
          return "redirect:/productResult";
      }
        else{
            re.addFlashAttribute("msg", "Product not found, please try again"); 
            return "redirect:/notFound";
        }
    }
    @RequestMapping(value="/searchProduct", method = RequestMethod.GET)
    public String searchProductByName(){;      
        return "searchProduct";
    }
    
    

}

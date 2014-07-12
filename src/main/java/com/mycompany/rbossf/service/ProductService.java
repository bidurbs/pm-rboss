/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rbossf.service;
import com.mycompany.rbossf.dao.ProductRepository;
import com.mycompany.rbossf.entity.Product;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
    
    @Resource
    private ProductRepository repo;

    public ProductRepository getRepo() {
        return repo;
    }

    public void setRepo(ProductRepository repo) {
        this.repo = repo;
    }
    
    public List<Product> getAll(){
        
        return repo.findAll();
    }
//    
//    public List<Product> getBrandedProducts(String brand){
//    
//        return repo.findBrandedProducts(brand);
//    }
//    
    public Product get(Long id){
        return repo.findOne(id);
    
    }
    
    public void update(Product product){
        repo.save(product);
    }
    
    public void delete(Long id){
        Product product = repo.findOne(id);
        product.setStatus("DELETED");
        repo.save(product);
    }
    
    public List<Product> findProductByName(String name){
        return repo.findByName(name);
    }
    
    public void add(Product product){
        repo.save(product);
    }
    
}

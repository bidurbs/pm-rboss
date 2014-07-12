/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rbossf.service;

import com.mycompany.rbossf.dao.ShoppingCartRepository;
import com.mycompany.rbossf.entity.ShoppingCart;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShoppingCartService {
    
    @Resource
    private ShoppingCartRepository repo;

    public ShoppingCartRepository getRepo() {
        return repo;
    }

    public void setRepo(ShoppingCartRepository repo) {
        this.repo = repo;
    }
    
    public List<ShoppingCart> getAll(){
        return repo.findAll();
    }
    
    public ShoppingCart get(Long id){
        return repo.findOne(id);
    }
    
    public void delete(Long id){
        repo.delete(id);
    }
    
    public void update(ShoppingCart cart){
        repo.save(cart);
    }
    
    public void emptyCart(Long id){
        ShoppingCart cart = repo.findOne(id);
        cart.getItems().clear();
        update(cart);
    }
    
    
}

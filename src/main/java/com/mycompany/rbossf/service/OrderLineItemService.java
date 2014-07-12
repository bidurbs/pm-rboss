/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rbossf.service;

import com.mycompany.rbossf.dao.OrderLineItemRepository;
import com.mycompany.rbossf.entity.OrderLineItem;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderLineItemService {
    
    @Resource
    private OrderLineItemRepository repo;

    public OrderLineItemRepository getRepo() {
        return repo;
    }

    public void setRepo(OrderLineItemRepository repo) {
        this.repo = repo;
    }
    
    public OrderLineItem get(Long id){
      return  repo.findOne(id);
    }
    
    public List<OrderLineItem> getAll(){
        return repo.findAll();
    }
    
    public void delete(Long id){
        repo.delete(id);
    }
    
    public void update(OrderLineItem orderitem){
        repo.save(orderitem);
    }
    
    public void add(OrderLineItem orderitem){
        repo.save(orderitem);
    }
}

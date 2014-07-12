/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rbossf.service;

import com.mycompany.rbossf.dao.OrderRepository;
import com.mycompany.rbossf.entity.MyOrder;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {
    
    @Resource
    private OrderRepository repo;

    public OrderRepository getRepo() {
        return repo;
    }

    public void setRepo(OrderRepository repo) {
        this.repo = repo;
    }
    
    public List<MyOrder> getAll(){
        return repo.findAll();
    }
    
    public MyOrder get(Long id){
        return repo.findOne(id);
    }
    
    public void delete(Long id){
        repo.delete(id);
    }
    
    public void update(MyOrder myorder){
        repo.save(myorder);
    }
    
    public void add(MyOrder order){
        repo.save(order);
    }
    
    
}

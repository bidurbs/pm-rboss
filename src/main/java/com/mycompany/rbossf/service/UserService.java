/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rbossf.service;

import com.mycompany.rbossf.entity.User;
import com.mycompany.rbossf.dao.UserRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Resource
    private UserRepository repo;

    public UserRepository getRepo() {
        return repo;
    }

    public void setRepo(UserRepository repo) {
        this.repo = repo;
    }
    
  
    public List<User> findAllUsers() {
        return repo.findAll();

    }

    public void addUser(User user) {
        repo.save(user);
    }

    public User get(Long id){
        return repo.findOne(id);
    }
    
    public void delete(Long id){
        repo.delete(id);
    }
    
    public void update(User user){
        repo.save(user);
    }
    
    public User searchUsername(String name){
        return repo.findByUsername(name);
    }
    
    public void add(User user){
        repo.save(user);
    }
    
    public List<User> searchFirstName(String name){
        return repo.findByFirstName(name);
    }
    
}

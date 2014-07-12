/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rbossf.service;

import com.mycompany.rbossf.dao.RoleRepository;
import com.mycompany.rbossf.entity.Role;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {
    
    @Resource
    private RoleRepository repo;

    public RoleRepository getRepo() {
        return repo;
    }

    public void setRepo(RoleRepository repo) {
        this.repo = repo;
    }
    
    public List<Role> getAll(){
        return repo.findAll();
                
    }
    
    public Role get(Long id){
        return repo.findOne(id);
    }
    
    public void delete(Long id){
        repo.delete(id);
    }
    
    public void update(Role role){
        repo.save(role);
    }
    
    public List<Role> searchRole(String name){
        return repo.findByName(name);
    }
    
}

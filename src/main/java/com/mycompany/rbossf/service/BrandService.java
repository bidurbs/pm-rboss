/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rbossf.service;

import com.mycompany.rbossf.dao.BrandRepository;
import com.mycompany.rbossf.entity.Brand;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandService {
    
    @Resource
    private BrandRepository repo;

    public BrandRepository getRepo() {
        return repo;
    }

    public void setRepo(BrandRepository repo) {
        this.repo = repo;
    }
    
    public List<Brand> getAll(){
        return repo.findAll();
    }
    
    public Brand get(Long id){
        return repo.findOne(id);
    }
    
    public void delete(Long id){
        repo.delete(id);
    }
    
    public void update(Brand brand){
        repo.save(brand);
    }
    
    public List<Brand> searchBrand(String brand){
        return repo.findByBrandName(brand);
    }
    
}

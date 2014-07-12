/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rbossf.dao;

/**
 *
 * @author ib
 */
import com.mycompany.rbossf.entity.Product;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface ProductRepository extends JpaRepository<Product, Long>{
    
//    @Query("select p from Product p join Brand b where b.brandName = ?1")
//    public List<Product> findBrandedProducts(@Param("brand") String brand);
 
    public List<Product> findByName(String name);
    
}

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
import com.mycompany.rbossf.entity.ShoppingCart;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>{
    
   
    
}

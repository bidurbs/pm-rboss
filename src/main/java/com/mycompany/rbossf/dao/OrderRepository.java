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
import com.mycompany.rbossf.entity.MyOrder;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<MyOrder, Long>{
    
}
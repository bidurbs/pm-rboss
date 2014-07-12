/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rbossf.dao;

import com.mycompany.rbossf.entity.User;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    
    public User findByUsername(String username);
    public User findByEmail(String email);
    public List<User> findByFirstNameOrLastName(String firstName, String lastName);
    public List<User> findByFirstName(String name);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rbossf.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author ib
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String email;
    private boolean enabled = true;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CreditCard> creditcards;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Role> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ShoppingCart cart = new ShoppingCart();

    @OneToMany(cascade = CascadeType.ALL)
    private List<MyOrder> orders;

    public User(String firstName, String lastName, String password, String username, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.username = username;
        this.email = email;
    }

    public User() {
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public List<MyOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<MyOrder> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<CreditCard> getCreditcards() {
        return creditcards;
    }

    public void setCreditcards(List<CreditCard> creditcards) {
        this.creditcards = creditcards;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}

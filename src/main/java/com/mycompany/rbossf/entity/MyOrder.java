/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rbossf.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ib
 */
@Entity
public class MyOrder {
    @Id
    @GeneratedValue
    private int id;
    @OneToMany
    private List<OrderLineItem> orderline;
    @Temporal(TemporalType.DATE)
    private Date date;
    private double totalPrice;


    public MyOrder() {
    }

    public MyOrder(List<OrderLineItem> orderline, Date date, double totalPrice) {
        this.orderline = orderline;
        this.date = date;
        this.totalPrice = totalPrice;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderLineItem> getOrderline() {
        return orderline;
    }

    public void setOrderline(List<OrderLineItem> orderline) {
        this.orderline = orderline;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rbossf.controllers;

import com.mycompany.rbossf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 *
 * @author ib
 */
@Controller
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    public OrderController() {
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    
    
    
}

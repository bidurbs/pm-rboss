/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rbossf.controllers;

import com.mycompany.rbossf.entity.Address;
import com.mycompany.rbossf.entity.CreditCard;
import com.mycompany.rbossf.entity.MyOrder;
import com.mycompany.rbossf.entity.OrderLineItem;
import com.mycompany.rbossf.entity.Product;
import com.mycompany.rbossf.entity.User;
import com.mycompany.rbossf.service.OrderLineItemService;
import com.mycompany.rbossf.service.OrderService;
import com.mycompany.rbossf.service.ProductService;
import com.mycompany.rbossf.service.ShoppingCartService;
import com.mycompany.rbossf.service.UserService;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.xml.crypto.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 * @author ib
 */
@Controller
public class ShoppingCartController {
    
    @Autowired
    private ShoppingCartService cartService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderLineItemService orderLineItemService;
    @Autowired
    private OrderService orderService;

    public ShoppingCartController() {
    }

    public ShoppingCartService getCartService() {
        return cartService;
    }

    public void setCartService(ShoppingCartService cartService) {
        this.cartService = cartService;
    }
    
    @RequestMapping(value="/cart/{id}", method = RequestMethod.POST)
    public String addToCart(@PathVariable long id, Model model, Principal principal, int quantity,final RedirectAttributes re){
        User user = userService.searchUsername(principal.getName());
        Product product = productService.get(id);
        OrderLineItem orderLineItem = new OrderLineItem(quantity, product);
        boolean flag = true;
        for(OrderLineItem items : user.getCart().getItems()){
            if(items.getProduct().equals(product)){
              OrderLineItem item = orderLineItemService.get(items.getId());
              item.setQuantity(quantity);
              orderLineItemService.update(item);
            flag=false;
                break;
            
        }}
       if(flag){
        user.getCart().getItems().add(orderLineItem);
        orderLineItemService.add(orderLineItem);
       }
       
//       ShoppingCart cart = user.getCart();
//       double total=0;
//       for(OrderLineItem oli : cart.getItems()){
//           total += oli.getQuantity() * oli.getProduct().getPrice();
//       }
//       cart.setPrice(total);
//       cartService.update(cart);
         String message = product.getName() +" has been added to shopping cart!";
         
         re.addFlashAttribute("message", message);
        return "redirect:/message";
    }
    
    
    @RequestMapping(value="/viewCart", method = RequestMethod.GET)
    public String getCart(Model model, Principal principal){
        User user = userService.searchUsername(principal.getName());
        model.addAttribute("orderlineItems", user.getCart().getItems()); 
        double total=0;
        for(OrderLineItem item : user.getCart().getItems()){
            
            total += item.getQuantity() * item.getProduct().getPrice();
            
        }
        
        model.addAttribute("totalPrice", total);
        
        return "shoppingCart";
    }
    
    
    @RequestMapping(value="/cart/addOne/{id}", method = RequestMethod.POST)
    public String editOrderLineQuantityplus(@PathVariable Long id,Model model){
        OrderLineItem item = orderLineItemService.get(id);
        item.setQuantity(item.getQuantity()+1);
        orderLineItemService.update(item);
        return "redirect:/viewCart";
    }
    @RequestMapping(value="/cart/subtractOne/{id}", method = RequestMethod.POST)
    public String editOrderLineQuantityminus(@PathVariable Long id,Model model){
        OrderLineItem item = orderLineItemService.get(id);
        item.setQuantity(item.getQuantity()-1);
        orderLineItemService.update(item);
        return "redirect:/viewCart";
    }
    @RequestMapping(value="/cart/delete/{id}", method = RequestMethod.POST)
    public String editCartDeleteItem(@PathVariable Long id,Model model, Principal principal){
        OrderLineItem item = orderLineItemService.get(id);
        User user = userService.searchUsername(principal.getName());
        user.getCart().getItems().remove(item);
        cartService.update(user.getCart());
        return "redirect:/viewCart";
    }
    
    
    @RequestMapping(value="/checkout" , method = RequestMethod.POST)
    public String checkout(Principal principal, Model model,final RedirectAttributes re){
         String message ="";
        double totalPrice=0;
        User user = userService.searchUsername(principal.getName());
//        
//        if(user.getAddress()==null || user.getCreditCard()==null){
//            //model.addAttribute("message", message);
//            re.addFlashAttribute("message", "You don't have a valid address or creditcard, Update your profile");
//            return "redirect:/message";
//    
//    }
        
        for(OrderLineItem item : user.getCart().getItems()){
            
            totalPrice += item.getQuantity() * item.getProduct().getPrice();
            
        }
        String view="redirect:/message";
       
        if(user.getCart().getItems().isEmpty()){
             message="Your shopping cart is Empty";
            re.addFlashAttribute("message", message);
        }else{
            List<OrderLineItem> items = user.getCart().getItems();
            Date now = new Date();
            MyOrder order = new MyOrder(items, now, totalPrice);
            user.getOrders().add(order);
            //orderService.add(order);
            userService.update(user);
            
            cartService.emptyCart(user.getCart().getId());
            message="Your order has been processed and $"+totalPrice+" will be deducted from your creditcard";
            re.addFlashAttribute("message", message);
            view = "redirect:/message";
        }
        
    return view;
    }
    
    @RequestMapping(value="/message", method = RequestMethod.GET)
    public String getMessage(ModelMap model){
        //model.addAttribute("message", model.get("message"));
        return "message";
    }
    
    @RequestMapping(value="/invalidInfo", method = RequestMethod.GET)
    public String invalidInfo(Principal principal, @Valid CreditCard creditcard, @Valid Address address){
        return "purchaseInfo";
    }
    
    @RequestMapping(value="/invalidInfo", method = RequestMethod.POST)
    public String invalidInfoSent(Principal principal, @Valid CreditCard creditcard, @Valid Address address, BindingResult result){
        return "purchaseInfo";
    }
    
    
    
}

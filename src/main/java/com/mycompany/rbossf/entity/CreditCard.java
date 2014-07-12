/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rbossf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author ib
 */
@Entity
public class CreditCard {
    @Id
    @GeneratedValue
    private Long id;
    
    private String nameOnCard;
    private String expirationDate;
    private String creditcardNumber;
    private String ccCode;

    public CreditCard(String nameOnCard, String expirationDate, String creditcardNumber, String ccCode) {
        this.nameOnCard = nameOnCard;
        this.expirationDate = expirationDate;
        this.creditcardNumber = creditcardNumber;
        this.ccCode = ccCode;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCreditcardNumber() {
        return creditcardNumber;
    }

    public void setCreditcardNumber(String creditcardNumber) {
        this.creditcardNumber = creditcardNumber;
    }

    public String getCcCode() {
        return ccCode;
    }

    public void setCcCode(String ccCode) {
        this.ccCode = ccCode;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}

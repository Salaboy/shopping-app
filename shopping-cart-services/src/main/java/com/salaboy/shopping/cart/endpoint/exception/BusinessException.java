/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salaboy.shopping.cart.endpoint.exception;

import java.io.Serializable;

/**
 *
 * @author salaboy
 */
public class BusinessException extends Exception implements Serializable {
    
    public BusinessException(String message) {
        super(message);    
    }
    
    


    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salaboy.shopping.cart.endpoint.api;

import com.salaboy.shopping.cart.endpoint.exception.BusinessException;
import com.salaboy.shopping.cart.model.Item;
import com.salaboy.shopping.cart.model.ShoppingCart;
import com.salaboy.shopping.cart.model.User;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author salaboy
 */
@Path("shopping")
public interface ShoppingCartService {
    @POST
    @Produces("application/json")
    @Path("")
    public ShoppingCart newShoppingCart(@NotNull User user) throws BusinessException;
    
    @PUT
    @Path("/{id}")
    public void addItem(@PathParam("id") @NotEmpty @NotNull String id, @NotNull Item item) throws BusinessException;
    
    @DELETE
    @Path("/{id}/item")
    public void removeItem(@PathParam("id") @NotEmpty @NotNull String id, @NotNull Item item) throws BusinessException;
    
    @DELETE
    @Path("/{id}")
    public void removeShoppingCart(@PathParam("id") @NotEmpty @NotNull String id) throws BusinessException;
    
    @POST
    @Path("/{id}/checkout")
    public void checkout(@PathParam("id") @NotEmpty @NotNull String id) throws BusinessException;
    
    @POST
    @Path("/{id}/empty")
    public void empty(@PathParam("id") @NotEmpty @NotNull String id) throws BusinessException;
    
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public List<Item> getCartItems(@PathParam("id") @NotEmpty @NotNull String id) throws BusinessException;
    
    @GET
    @Produces("application/json")
    @Path("/carts")
    public List<ShoppingCart> getShoppingCarts() throws BusinessException;
    
}

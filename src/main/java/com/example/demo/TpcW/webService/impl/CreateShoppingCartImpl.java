package com.example.demo.TpcW.webService.impl;

import com.example.demo.TpcW.model.Cart;
import com.example.demo.TpcW.model.CreateShoppingCartStatement;
import com.example.demo.TpcW.webService.CreateShoppingCart;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(serviceName = "CreateShoppingCart")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class CreateShoppingCartImpl implements CreateShoppingCart {

    @Override
    public Cart createShoppingCart(Integer SHOPPING_ID) {
        return new CreateShoppingCartStatement().getCart(SHOPPING_ID);
    }
}
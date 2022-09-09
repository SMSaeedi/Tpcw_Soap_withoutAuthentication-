package com.example.demo.TpcW.webService;

import com.example.demo.TpcW.model.Cart;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://impl.webService.createShoppingCart.demo.example.com/")
public interface CreateShoppingCart {

    @WebMethod(operationName = "createShoppingCart")
    public Cart createShoppingCart(@WebParam(name = "I_ID") Integer I_ID);

}
package com.example.demo.TpcW.webService;

import com.example.demo.TpcW.model.Order;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://impl.webService.demo.example.com/")
public interface GetMostRecentOrder {

    @WebMethod(operationName = "getMostRecentOrder")
    Order getMostRecentOrder(@WebParam(name = "c_uname") String c_uname);

    @WebMethod(operationName = "getMostRecentOrderTest")
    Order getMostRecentOrderTest(@WebParam(name = "c_uname") String c_uname);

}
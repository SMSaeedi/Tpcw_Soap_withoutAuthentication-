package com.example.demo.TpcW.webService;

import com.example.demo.TpcW.model.Customer;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://impl.webService.getCustomer.demo.example.com/")
public interface GetCustomer {

    @WebMethod(operationName = "getCustomer")
    public Customer getCustomer(@WebParam(name = "UNAME") String UNAME);

    @WebMethod(operationName = "getCustomerTest")
    public Customer getCustomerTest(@WebParam(name = "UNAME") Customer UNAME);
}
package com.example.demo.TpcW.webService;

import com.example.demo.TpcW.model.Customer;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://impl.webService.demo.example.com/")
public interface CreateNewCustomer {

    @WebMethod(operationName = "createNewCustomer")
    public Customer createNewCustomer(Customer cust);

}
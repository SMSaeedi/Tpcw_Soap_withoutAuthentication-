package com.example.demo.TpcW.webService.impl;

import com.example.demo.TpcW.model.CreateNewCustomerStatement;
import com.example.demo.TpcW.model.Customer;
import com.example.demo.TpcW.webService.CreateNewCustomer;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(serviceName = "CreateNewCustomer")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class CreateNewCustomerImpl implements CreateNewCustomer {

    public Customer createNewCustomer(Customer cust) {
        return new CreateNewCustomerStatement().createNewCustomer(cust);
    }
}
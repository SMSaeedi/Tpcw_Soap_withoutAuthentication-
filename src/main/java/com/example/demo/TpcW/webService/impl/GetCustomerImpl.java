package com.example.demo.TpcW.webService.impl;

import com.example.demo.TpcW.model.Customer;
import com.example.demo.TpcW.model.GetCustomerStatement;
import com.example.demo.TpcW.webService.GetCustomer;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(serviceName = "getCustomerWebService")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class GetCustomerImpl implements GetCustomer {

    @Override
    public Customer getCustomer(String UNAME) {
        return new GetCustomerStatement().getCustomer(UNAME);
    }

    @Override
    public Customer getCustomerTest(Customer uname) {
        return new GetCustomerStatement().getCustomerTest(uname);
    }
}
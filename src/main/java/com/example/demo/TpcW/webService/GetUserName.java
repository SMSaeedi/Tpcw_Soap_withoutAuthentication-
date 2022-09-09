package com.example.demo.TpcW.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://impl.webService.demo.example.com/")
public interface GetUserName {

    @WebMethod(operationName = "getUserName")
    public String getUserName(@WebParam(name = "C_ID") int C_ID);

    @WebMethod(operationName = "getUserNameTest")
    public String getUserNameTest(@WebParam(name = "C_ID") String C_ID);
}
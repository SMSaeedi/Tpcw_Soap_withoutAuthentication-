package com.example.demo.TpcW.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://impl.webService.getPassword.demo.example.com/")
public interface GetPassword {

    @WebMethod(operationName = "getPassword")
    public String getPassword(@WebParam(name = "C_UNAME") String C_UNAME);

    @WebMethod(operationName = "getPasswordTest")
    public String getPasswordTest(@WebParam(name = "C_UNAME") String C_UNAME);

}
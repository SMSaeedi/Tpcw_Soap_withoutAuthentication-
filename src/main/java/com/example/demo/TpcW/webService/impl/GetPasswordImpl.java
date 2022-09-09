package com.example.demo.TpcW.webService.impl;

import com.example.demo.TpcW.model.GetPasswordStatement;
import com.example.demo.TpcW.webService.GetPassword;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(serviceName = "getPasswordWebService")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class GetPasswordImpl implements GetPassword {

    @Override
    public String getPassword(String C_UNAME) {
        return new GetPasswordStatement().getPassword(C_UNAME);
    }

    @Override
    public String getPasswordTest(String C_UNAME) {
        return new GetPasswordStatement().getPasswordHardCode(C_UNAME);
    }
}
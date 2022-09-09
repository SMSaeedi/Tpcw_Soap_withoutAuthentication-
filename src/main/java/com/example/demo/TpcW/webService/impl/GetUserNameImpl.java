package com.example.demo.TpcW.webService.impl;

import com.example.demo.TpcW.model.GetUsernameStatement;
import com.example.demo.TpcW.webService.GetUserName;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(serviceName = "getUserNameWebService")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class GetUserNameImpl implements GetUserName {

    @Override
    public String getUserName(int C_ID) {
        return new GetUsernameStatement().getUserName(C_ID);
    }

    @Override
    public String getUserNameTest(String C_ID) {
        return new GetUsernameStatement().getUserNameTest(C_ID);
    }

}
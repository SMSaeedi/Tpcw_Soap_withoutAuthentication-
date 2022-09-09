package com.example.demo.TpcW.webService.impl;

import com.example.demo.TpcW.model.AdminUpdateInParams;
import com.example.demo.TpcW.model.AdminUpdateOutParams;
import com.example.demo.TpcW.model.AdminUpdateStatement;
import com.example.demo.TpcW.webService.AdminUpdate;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(serviceName = "AdminUpdate")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class AdminUpdateImpl implements AdminUpdate {

    @Override
    public void adminUpdate(AdminUpdateInParams input) {
        new AdminUpdateStatement().adminUpdate(input);
    }

    @Override
    public AdminUpdateOutParams adminUpdateHardCode(AdminUpdateInParams input) {
        return new AdminUpdateStatement().hardCodeData(input);
    }
}
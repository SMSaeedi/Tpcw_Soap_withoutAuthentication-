package com.example.demo.TpcW.webService;

import com.example.demo.TpcW.model.AdminUpdateInParams;
import com.example.demo.TpcW.model.AdminUpdateOutParams;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://impl.webService.demo.example.com/")
public interface AdminUpdate {

    @WebMethod(operationName = "adminUpdate")
    void adminUpdate(@WebParam(name = "input") AdminUpdateInParams input);


    @WebMethod(operationName = "adminUpdateHardCode")
    AdminUpdateOutParams adminUpdateHardCode(@WebParam(name = "input") AdminUpdateInParams input);

}
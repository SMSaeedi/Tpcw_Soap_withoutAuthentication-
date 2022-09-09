package com.example.demo.TpcW.webService;

import com.example.demo.TpcW.model.ShortBook;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://impl.webService.getNewProducts.demo.example.com/")
public interface GetNewProduct {

    @WebMethod(operationName = "getNewProducts")
    public List<ShortBook> getNewProducts(@WebParam(name = "input") String subject);

    @WebMethod(operationName = "getNewProductsTest")
    public List<ShortBook> getNewProductsTest(@WebParam(name = "input") String subject);
}
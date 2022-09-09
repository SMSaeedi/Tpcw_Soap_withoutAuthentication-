package com.example.demo.TpcW.webService.impl;

import com.example.demo.TpcW.model.GetNewProductsStatement;
import com.example.demo.TpcW.model.ShortBook;
import com.example.demo.TpcW.webService.GetNewProduct;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;

@WebService(serviceName = "getNewProductWebService")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class GetNewProductImpl implements GetNewProduct {

    @Override
    public List<ShortBook> getNewProducts(String subject) {
        return new GetNewProductsStatement().getNewProducts(subject);
    }

    @Override
    public List<ShortBook> getNewProductsTest(String subject) {
        return new GetNewProductsStatement().getNewProductsHardCode(subject);
    }
}
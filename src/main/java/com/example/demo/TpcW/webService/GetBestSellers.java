package com.example.demo.TpcW.webService;

import com.example.demo.TpcW.model.ShortBook;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://impl.webService.getBestSellers.demo.example.com/")
public interface GetBestSellers {

    @WebMethod(operationName = "getBestSellers")
    public List<ShortBook> getBestSellers(@WebParam(name = "subject") String subject);

    @WebMethod(operationName = "getBestSellersTest")
    public List<ShortBook> getBestSellersTest(@WebParam(name = "subject") ShortBook subject);
}
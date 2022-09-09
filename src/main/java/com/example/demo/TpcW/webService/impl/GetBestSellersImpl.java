package com.example.demo.TpcW.webService.impl;

import com.example.demo.TpcW.model.GetBestSellersStatement;
import com.example.demo.TpcW.model.ShortBook;
import com.example.demo.TpcW.webService.GetBestSellers;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;

@WebService(serviceName = "getBestSellersWebService")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class GetBestSellersImpl implements GetBestSellers {

    @Override
    public List<ShortBook> getBestSellers(String subject) {
        return new GetBestSellersStatement().getBestSellers(subject);
    }

    @Override
    public List<ShortBook> getBestSellersTest(ShortBook subject) {
        return new GetBestSellersStatement().getBestSellersTest(subject);
    }
}
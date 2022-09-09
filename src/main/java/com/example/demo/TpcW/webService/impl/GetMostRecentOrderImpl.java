package com.example.demo.TpcW.webService.impl;

import com.example.demo.TpcW.model.GetMostRecentOrderStatement;
import com.example.demo.TpcW.model.Order;
import com.example.demo.TpcW.webService.GetMostRecentOrder;

import javax.jws.WebService;

@WebService(serviceName = "mostRecentOrderWebService")
public class GetMostRecentOrderImpl implements GetMostRecentOrder {

    @Override
    public Order getMostRecentOrder(String c_uname) {
        return new GetMostRecentOrderStatement().getMostRecentOrder(c_uname);
    }

    @Override
    public Order getMostRecentOrderTest(String c_uname) {
        return new GetMostRecentOrderStatement().getMostRecentOrderTest(c_uname);
    }
}
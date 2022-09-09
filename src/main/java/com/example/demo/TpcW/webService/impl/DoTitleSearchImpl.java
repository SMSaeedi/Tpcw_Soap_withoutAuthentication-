package com.example.demo.TpcW.webService.impl;

import com.example.demo.TpcW.model.Book;
import com.example.demo.TpcW.model.DoTitleSearchStatement;
import com.example.demo.TpcW.webService.DoTitleSearch;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;

@WebService(serviceName = "DoTitleSearch")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class DoTitleSearchImpl implements DoTitleSearch {


    @Override
    public List<Book> doTitleSearch(String search_key) {
        return new DoTitleSearchStatement().doTitleSearch(search_key);
    }

    @Override
    public List<Book> doTitleSearchTest(Book search_key) {
        return new DoTitleSearchStatement().doTitleSearchTest(search_key);
    }

}
package com.example.demo.TpcW.webService.impl;

import com.example.demo.TpcW.model.Book;
import com.example.demo.TpcW.model.DoAuthorSearchStatement;
import com.example.demo.TpcW.webService.DoAuthorSearch;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;

@WebService(serviceName = "DoAuthorSearch")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class DoAuthorSearchImpl implements DoAuthorSearch {

    @Override
    public List<Book> doAuthorSearch(String search_key) {
        return new DoAuthorSearchStatement().doAuthorSearch(search_key);
    }

    @Override
    public List<Book> doAuthorSearchTest(Book search_key) {
        return new DoAuthorSearchStatement().doAuthorSearchHardCodeTest(search_key);
    }
}
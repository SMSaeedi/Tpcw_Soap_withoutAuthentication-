package com.example.demo.TpcW.webService.impl;

import com.example.demo.TpcW.model.Book;
import com.example.demo.TpcW.model.DoSubjectSearchStatement;
import com.example.demo.TpcW.webService.DoSubjectSearch;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;

@WebService(serviceName = "DoSubjectSearch")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class DoSubjectSearchImpl implements DoSubjectSearch {

    @Override
    public List<Book> doSubjectSearch(String search_key) {
        return new DoSubjectSearchStatement().doSubjectSearch(search_key);
    }

    @Override
    public List<Book> doSubjectSearchTest(Book search_key) {
        return new DoSubjectSearchStatement().doSubjectSearchHardCodeTest(search_key);
    }
}
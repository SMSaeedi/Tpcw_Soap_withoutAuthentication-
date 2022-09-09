package com.example.demo.TpcW.webService;

import com.example.demo.TpcW.model.Book;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://impl.webService.doSubjectSearch.demo.example.com/")
public interface DoSubjectSearch {

    @WebMethod(operationName = "doSubjectSearch")
    public List<Book> doSubjectSearch(@WebParam(name = "search_key") String search_key);

    @WebMethod(operationName = "doSubjectSearchTest")
    public List<Book> doSubjectSearchTest(@WebParam(name = "search_key") Book search_key);
}
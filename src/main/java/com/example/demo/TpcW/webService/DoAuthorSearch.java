package com.example.demo.TpcW.webService;

import com.example.demo.TpcW.model.Book;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://impl.webService.demo.example.com/")
public interface DoAuthorSearch {

    @WebMethod(operationName = "doAuthorSearch")
    public List<Book> doAuthorSearch(@WebParam(name = "search_key") String search_key);

    @WebMethod(operationName = "doAuthorSearchTest")
    public List<Book> doAuthorSearchTest(@WebParam(name = "search_key") Book search_key);
}
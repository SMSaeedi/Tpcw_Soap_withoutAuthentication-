package com.example.demo.TpcW.webService;

import com.example.demo.TpcW.model.Book;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://impl.webService.doTitleSearch.demo.example.com/")
public interface DoTitleSearch {

    @WebMethod(operationName = "doTitleSearch")
    public List<Book> doTitleSearch(@WebParam(name = "search_key") String search_key);

    @WebMethod(operationName = "doTitleSearchTest")
    public List<Book> doTitleSearchTest(@WebParam(name = "search_key") Book search_key);

}
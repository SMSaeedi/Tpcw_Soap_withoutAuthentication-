package com.example.demo.config;

import com.example.demo.TpcW.webService.*;
import com.example.demo.TpcW.webService.impl.*;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Configuration
public class TpcWConfig implements BeanFactoryPostProcessor {

    @Value("${cxf.path}")
    protected String ws;

    @GetMapping("/")
    public RedirectView hello(HttpServletRequest request) {
        return new RedirectView(request.getContextPath() + ws);
    }

    @Autowired
    private Bus bus;

    @Bean
    public AdminUpdate  adminUpdate() {
        return new AdminUpdateImpl();
    }

    @Bean
    public CreateNewCustomer createNewCustomer() {
        return new CreateNewCustomerImpl();
    }

    @Bean
    public CreateShoppingCart createShoppingCart() {
        return new CreateShoppingCartImpl();
    }

    @Bean
    public DoAuthorSearch doAuthorSearch() {
        return new DoAuthorSearchImpl();
    }

    @Bean
    public DoSubjectSearch doSubjectSearch() {
        return new DoSubjectSearchImpl();
    }
    @Bean
    public DoTitleSearch doTitleSearch() {
        return new DoTitleSearchImpl();
    }
    @Bean
    public GetBestSellers getBestSellers() {
        return new GetBestSellersImpl();
    }
    @Bean
    public GetCustomer getCustomer() {
        return new GetCustomerImpl();
    }
    @Bean
    public GetMostRecentOrder getMostRecentOrder() {
        return new GetMostRecentOrderImpl();
    }
    @Bean
    public GetNewProduct getNewProduct() {
        return new GetNewProductImpl();
    }
    @Bean
    public GetPassword getPassword() {
        return new GetPasswordImpl();
    }
    @Bean
    public GetUserName getUserName() {
        return new GetUserNameImpl();
    }
   /* @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, newCustomerService());
        endpoint.publish("/TpcApp");
        return endpoint;
    }*/

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        Arrays.stream(new String[]{"adminUpdate", "createnewCustomer", "createshoppingCart", "doauthorSearch", "dosubjectSearch", "dotitleSearch", "getbestSellers", "getCustomer", "getmostrecentOrder", "getnewProduct", "getPassword", "getUserName"}).forEach(str -> {
            bus = factory.getBean(Bus.class);
            JaxWsServerFactoryBean bean = new JaxWsServerFactoryBean();
            bean.setAddress("/" + str + "/TpcW");
            bean.setBus(bus);
            bean.setServiceClass(TpcWConfig.class);
            factory.registerSingleton(str, bean.create());
        });
    }
}
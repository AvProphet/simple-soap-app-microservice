package com.soap.webservices.soapfirstapp.soap;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.Collections;
import java.util.List;

@EnableWs

@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    //MessageDispatcherServlet
        //AppContext
    //url -> /ws/*

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet =
                new MessageDispatcherServlet();

        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);


        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    @Bean(name="details")
    public DefaultWsdl11Definition defaultWsdl11Definition
            (XsdSchema detailSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();

        definition.setPortTypeName("DetailsPort");
        definition.setTargetNamespace("http://newmicroservice.com/details");
        definition.setLocationUri("/ws");
        definition.setSchema(detailSchema);

        return definition;
    }

    @Bean
    XsdSchema detailsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("details.xsd"));
    }

//XwsSecInterceptor
    //CallBackHandler -> SimplePassVal
    //Security Policy - secPolicy.xml
    //Interceptors.add

    @Bean
    public XwsSecurityInterceptor securityInterceptor() {
        XwsSecurityInterceptor securityInterceptor = new XwsSecurityInterceptor();

        securityInterceptor.setCallbackHandler(callBackHandler());
        securityInterceptor.setPolicyConfiguration(new ClassPathResource("securityPolicy.xml"));

        return securityInterceptor;
    }

    @Bean
    protected SimplePasswordValidationCallbackHandler callBackHandler() {
        SimplePasswordValidationCallbackHandler handler = new SimplePasswordValidationCallbackHandler();
        handler.setUsersMap(Collections.singletonMap("user", "password"));
        return handler;
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(securityInterceptor());
    }

}

package com.soap.webservices.soapfirstapp.soap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class DetailNotFound extends RuntimeException {

    private static final long serialVersionUID = 342435354345L;

    public DetailNotFound(String s) {
        super(s);
    }
}

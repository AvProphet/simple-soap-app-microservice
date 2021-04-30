package com.soap.webservices.soapfirstapp.soap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class DeatailNotFound extends RuntimeException {

    private static final long serialVersionUID = 342435354345L;

    public DeatailNotFound(String s) {
        super(s);
    }
}

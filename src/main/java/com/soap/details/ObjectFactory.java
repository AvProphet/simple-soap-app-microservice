
package com.soap.details;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soap.details package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soap.details
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDetailsRequest }
     * 
     */
    public GetDetailsRequest createGetDetailsRequest() {
        return new GetDetailsRequest();
    }

    /**
     * Create an instance of {@link GetAllDetailsRequest }
     * 
     */
    public GetAllDetailsRequest createGetAllDetailsRequest() {
        return new GetAllDetailsRequest();
    }

    /**
     * Create an instance of {@link GetDetailsResponse }
     * 
     */
    public GetDetailsResponse createGetDetailsResponse() {
        return new GetDetailsResponse();
    }

    /**
     * Create an instance of {@link Details }
     * 
     */
    public Details createDetails() {
        return new Details();
    }

    /**
     * Create an instance of {@link GetAllDetailsResponse }
     * 
     */
    public GetAllDetailsResponse createGetAllDetailsResponse() {
        return new GetAllDetailsResponse();
    }

}

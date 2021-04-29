package com.soap.webservices.soapfirstapp.soap;

import com.soap.details.*;
import com.soap.webservices.soapfirstapp.soap.bean.DetailInstance;
import com.soap.webservices.soapfirstapp.soap.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class DetailsEndPoint {

    @Autowired
    DetailsService service;

    //input - GetDetailsRequest
    //output - GetDetailsResponse
    @PayloadRoot(namespace = "http://newmicroservice.com/details"
            , localPart = "GetDetailsRequest")
    @ResponsePayload
    public GetDetailsResponse processGetDetailsRequest
    (@RequestPayload GetDetailsRequest request) {

        DetailInstance detail = service.findById(request.getId());

        return mapDetailsResponse(detail);
    }

    private GetDetailsResponse mapDetailsResponse(DetailInstance detail) {
        GetDetailsResponse response = new GetDetailsResponse();

        response.setDetails(mapDetails(detail));

        return response;
    }

    private GetAllDetailsResponse mapAllDetailsResponse(List<DetailInstance> details) {
        GetAllDetailsResponse response = new GetAllDetailsResponse();
        for (DetailInstance detail:details) {
            Details mapDetails = mapDetails(detail);
            response.getDetails().add(mapDetails);
        }
        return response;
    }

    private Details mapDetails(DetailInstance detail) {
        Details details = new Details();

        details.setId(detail.getId());
        details.setName(detail.getName());
        details.setDescription(detail.getDescription());
        return details;
    }

    @PayloadRoot(namespace = "http://newmicroservice.com/details"
            , localPart = "GetAllDetailsRequest")
    @ResponsePayload
    public GetAllDetailsResponse processAllGetDetailsRequest
            (@RequestPayload GetAllDetailsRequest request) {

        List<DetailInstance> details = service.findAll();

        return mapAllDetailsResponse(details);
    }

}

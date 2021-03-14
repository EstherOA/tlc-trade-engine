package com.example.soapproducerdemo.endpoint;

import com.example.soapproducerdemo.service.OrderRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import spring.soap_producer_demo.GetOrderRequest;
import spring.soap_producer_demo.GetOrderResponse;

@Endpoint
public class OrderDispatchEndpoint {
    private static final String NAMESPACE_URI =
            "http://spring/soap-producer-demo";

    private OrderRepositoryService orderRepositoryService;

    @Autowired
    public OrderDispatchEndpoint(OrderRepositoryService orderRepositoryService) {
        this.orderRepositoryService = orderRepositoryService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrderRequest")
    @ResponsePayload
    public GetOrderResponse getOrder(@RequestPayload GetOrderRequest request) {
        GetOrderResponse response = new GetOrderResponse();
        response.setOrder(orderRepositoryService.findOrder(request.getOrderId()));
        return response;
    }
}

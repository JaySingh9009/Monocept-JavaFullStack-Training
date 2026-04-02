package com.orderprocessing.model;

public class DispatchRequest {

    private int orderId;

    public DispatchRequest(int orderId){
        this.orderId=orderId;
    }

    public int getOrderId(){
        return orderId;
    }

    @Override
    public String toString(){

        return "Dispatch Request for OrderID:"+orderId;
    }
}
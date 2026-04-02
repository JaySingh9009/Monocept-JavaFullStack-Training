package com.orderprocessing.model;

public class PriorityOrder extends Order{

    public PriorityOrder(int orderId,String customer,double amount){

        super(orderId,customer,amount);
    }

    @Override
    public String getOrderType(){

        return "Priority Order";
    }
}
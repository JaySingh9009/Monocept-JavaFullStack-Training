package com.orderprocessing.model;

public class RegularOrder extends Order{

    public RegularOrder(int orderId,String customer,double amount){

        super(orderId,customer,amount);
    }

    @Override
    public String getOrderType(){

        return "Regular Order";
    }
}
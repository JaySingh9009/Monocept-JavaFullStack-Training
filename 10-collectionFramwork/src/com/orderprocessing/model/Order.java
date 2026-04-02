package com.orderprocessing.model;

import java.util.Objects;

public abstract class Order implements Comparable<Order>{

    private int orderId;
    private String customerName;
    private double totalAmount;
    private OrderStatus status;

    public Order(int orderId,String customerName,double totalAmount){

        this.orderId=orderId;
        this.customerName=customerName;
        this.totalAmount=totalAmount;
        this.status=OrderStatus.PENDING;
    }

    public int getOrderId(){
        return orderId;
    }

    public String getCustomerName(){
        return customerName;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public OrderStatus getStatus(){
        return status;
    }

    public void setStatus(OrderStatus status){
        this.status=status;
    }

    public abstract String getOrderType();

    @Override
    public int compareTo(Order o){

        return Double.compare(this.totalAmount,o.totalAmount);
    }

    @Override
    public boolean equals(Object obj){

        if(this==obj) return true;

        if(obj == null || !(obj instanceof Order)) return false;

        Order order=(Order)obj;

        return orderId==order.orderId;
    }

    @Override
    public int hashCode(){

        return Objects.hash(orderId);
    }

    @Override
    public String toString(){

        return "OrderID:"+orderId+
                " Customer:"+customerName+
                " Amount:"+totalAmount+
                " Type:"+getOrderType()+
                " Status:"+status;
    }
}
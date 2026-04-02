package com.onlineOrderApp.test;

import com.onlineOrderApp.service.OrderServiceManager;

public class OrderSystem {

    public static void main(String[] args) {

        OrderServiceManager manager = new OrderServiceManager();
        manager.startSystem();
    }
}
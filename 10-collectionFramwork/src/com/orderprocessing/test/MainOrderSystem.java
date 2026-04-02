package com.orderprocessing.test;

import com.orderprocessing.model.*;

public class MainOrderSystem {

    public static void main(String[] args){

        OrderManager manager = new OrderManager();

        System.out.println("=====================================");
        System.out.println(" ONLINE ORDER PROCESSING SYSTEM ");
        System.out.println("=====================================");

        int choice;

        do{

            System.out.println("\n1 Add Order");
            System.out.println("2 Show Orders");
            System.out.println("3 Process Dispatch");
            System.out.println("4 Show Sorted Orders");
            System.out.println("5 Customer Orders");
            System.out.println("6 Cancel Order");
            System.out.println("0 Exit");

            choice = InputValidator.readChoice("Enter choice:");

            switch(choice){

                case 1:

                    int id = InputValidator.readOrderId("Enter Order ID:");

                    String name = InputValidator.readName("Enter Customer Name:");

                    double amt = InputValidator.readAmount("Enter Total Amount:");

                    System.out.println("1 Regular Order");
                    System.out.println("2 Priority Order");

                    int type = InputValidator.readChoice("Enter type:");

                    if(type == 1)
                        manager.addOrder(new RegularOrder(id, name, amt));
                    else
                        manager.addOrder(new PriorityOrder(id, name, amt));

                    break;

                case 2:
                    manager.showOrders();
                    break;

                case 3:
                    manager.processDispatch();
                    break;

                case 4:
                    manager.showSortedByAmount();
                    break;

                case 5:

                    String cust = InputValidator.readName("Enter customer name:");
                    manager.showCustomerOrders(cust);

                    break;

                case 6:

                    int cid = InputValidator.readOrderId("Enter order id:");
                    manager.cancelOrder(cid);

                    break;

            }

        } while(choice != 0);
    }
}
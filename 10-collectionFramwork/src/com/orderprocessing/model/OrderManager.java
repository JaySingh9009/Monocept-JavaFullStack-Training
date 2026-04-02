package com.orderprocessing.model;


import java.util.*;

public class OrderManager {

    private Set<Order> orders=new HashSet<>();

    private Queue<DispatchRequest> dispatchQueue=new LinkedList<>();

    private Map<String,List<Order>> customerOrders=new HashMap<>();

    private Set<Integer> processedOrders=new HashSet<>();


    public void addOrder(Order order){

        if(!orders.add(order)){

            System.out.println("Duplicate Order ID not allowed");
            return;
        }

        customerOrders
                .computeIfAbsent(order.getCustomerName(),k->new ArrayList<>())
                .add(order);

        dispatchQueue.add(new DispatchRequest(order.getOrderId()));

        System.out.println("Order stored and added to dispatch queue");
    }


    private Order findOrder(int id){

        for(Order o:orders)
            if(o.getOrderId()==id)
                return o;

        return null;
    }


    public void processDispatch(){

        DispatchRequest req=dispatchQueue.poll();

        if(req==null){

            System.out.println("No orders waiting for dispatch");
            return;
        }

        if(processedOrders.contains(req.getOrderId())){

            System.out.println("Order already dispatched");
            return;
        }

        Order order=findOrder(req.getOrderId());

        if(order!=null && order.getStatus()==OrderStatus.PENDING){

            order.setStatus(OrderStatus.DISPATCHED);

            processedOrders.add(order.getOrderId());

            System.out.println("Order dispatched -> "+order);
        }
    }


    public void showOrders(){

        for(Order o:orders)
            System.out.println(o);
    }


    public void showSortedByAmount(){

        TreeSet<Order> sorted=new TreeSet<>(orders);

        for(Order o:sorted)
            System.out.println(o);
    }


    public void showCustomerOrders(String customer){

        List<Order> list=customerOrders.get(customer);

        if(list==null){

            System.out.println("No orders for this customer");
            return;
        }

        list.forEach(System.out::println);
    }


    public void cancelOrder(int id){

        Iterator<Order> itr=orders.iterator();

        while(itr.hasNext()){

            Order o=itr.next();

            if(o.getOrderId()==id){

                o.setStatus(OrderStatus.CANCELLED);

                itr.remove();

                System.out.println("Order cancelled and removed");

                return;
            }
        }

        System.out.println("Order not found");
    }
}
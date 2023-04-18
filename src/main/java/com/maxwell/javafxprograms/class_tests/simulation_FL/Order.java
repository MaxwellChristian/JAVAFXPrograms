package com.maxwell.javafxprograms.class_tests.simulation_FL;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements Comparable<Order> {
    String firstName;
    String lastName;
    Date orderTime;

    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public Order(String firstName,String lastName)
    {
        this.firstName=firstName;
        this.lastName= lastName;
        this.orderTime=new Date();
    }

    public Order(String str) throws ParseException {
        String [] list = str.split(",");
        this.firstName=list[1];
        this.lastName=list[2];
        this.orderTime=formatter.parse(list[3]);
    }

    @Override
    public String toString() {
        return String.format("ORDER,%s,%s,%s",firstName,lastName,formatter.format(orderTime));
    }

    @Override
    public int compareTo(Order o) {
        return this.orderTime.compareTo(o.orderTime);
    }
}

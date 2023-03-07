package com.maxwell.javafxprograms;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class BindingPropertyDemo {

    public static void main(String []args){

        DoubleProperty dp1 = new SimpleDoubleProperty(1);
        DoubleProperty dp2 = new SimpleDoubleProperty(2);

        // uni-directional binding
        // dp1.bind(dp2);

        System.out.println("dp1 :  " + dp1.getValue() + " -> dp2 : " + dp2.getValue());

        // dp2.setValue(77);
        // System.out.println("dp1 :  " + dp1.getValue() + " -> dp2 : " + dp2.getValue());

        // this generates error because dp1 and dp2 are in uni-direction binding
        // dp1.setValue(55);
        // System.out.println("dp1 :  " + dp1.getValue() + " -> dp2 : " + dp2.getValue());

        // bi-directional binding
        dp1.bindBidirectional(dp2);

        dp1.setValue(55);
        System.out.println("dp1 :  " + dp1.getValue() + " -> dp2 : " + dp2.getValue());

        dp2.setValue(77);
        System.out.println("dp1 :  " + dp1.getValue() + " -> dp2 : " + dp2.getValue());
    }

}

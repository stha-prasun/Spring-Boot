package com.learning.InternalWorking;

import org.springframework.stereotype.Component;

@Component
public class RazorpayPaymentService {
    public String pay(){
        String payment = "Razorpay Payment";
        System.out.println(payment);
        return payment;
    }
}

package com.learning.InternalWorking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalWorkingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InternalWorkingApplication.class, args);
	}

    //    private RazorpayPaymentService paymentService = new RazorpayPaymentService(); <- Old Method To Create Objects
//    @Autowired (Field Dependency Injection)
    private RazorpayPaymentService paymentService;

//    Constructor Dependency Injection (Commonly Used)
    public InternalWorkingApplication(RazorpayPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void run(String... args) throws Exception {
        String payment = paymentService.pay();
        System.out.println(payment);
    }

}

package com.learning.InternalWorking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalWorkingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InternalWorkingApplication.class, args);
	}

    //    private RazorpayPaymentService paymentService = new RazorpayPaymentService();
    private RazorpayPaymentService paymentService;

    public InternalWorkingApplication(RazorpayPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void run(String... args) throws Exception {
        String payment = paymentService.pay();
        System.out.println(payment);
    }

}

package com.Prasun.Project;

import com.Prasun.Project.Entity.Insurance;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("HDCF_123")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build();
    }
}

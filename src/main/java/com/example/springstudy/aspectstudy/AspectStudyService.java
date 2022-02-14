package com.example.springstudy.aspectstudy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AspectStudyService {

    @PerfLogging
    public void testAround() {
        System.out.println("AspectStudyService.testAround start");
        System.out.println("sleep 1000");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("AspectStudyService.testAround end");
    }

    public void testBefore() {
        System.out.println("AspectStudyService.testBefore start");
        System.out.println("sleep 2000");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("AspectStudyService.testBefore end");
    }

    public void testAfterReturning() {
        System.out.println("AspectStudyService.testAfterReturning start");
        System.out.println("sleep 1500");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("AspectStudyService.testAfterReturning end");
    }

    public void testAfterThrowing() {
        System.out.println("AspectStudyService.testAfterThrowing start");
        System.out.println("sleep 1300");

        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("throw new RuntimeException for test");
    }
}

package com.dipanshu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//Make the student class part of the IOC
public class Student {

    @Autowired
    Study study;            //WRING
    public void code(){
        study.sutdy();
        System.out.println("Student is coding!");
    }
}

package com.dipanshu;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary        //primary computer (desktop vs laptop)
public class Laptop implements Computer {
    public Laptop(){
        System.out.println("Laptop Object Created");            
    }
    @Override
    public void compile(){
        System.out.println("Compiling...");
    }
}

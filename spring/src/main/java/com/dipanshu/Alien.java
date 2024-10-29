package com.dipanshu;

import java.beans.ConstructorProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    private int age;

    @Autowired   //Injection (field, constructor, setter) three levels of injection
    // @Qualifier("laptop") // use Laptop if two computer classes found
    @Qualifier("desktop")
    private Computer lappy;

    // Necessary when using name to map the constructor injection
    @ConstructorProperties({"age","lappy"})
    Alien(int age,Computer lappy){
        this.age = age;
        this.lappy = lappy;
    }

    
    public Computer getLappy() {
        return lappy;
    }
    public void setLappy(Computer lappy) {
        this.lappy = lappy;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Alien(){
        System.out.println("Alien landed!");
    }
    public void code(){
        System.out.println("Alien is coding..");
    }
}

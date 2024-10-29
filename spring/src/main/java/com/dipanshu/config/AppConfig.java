package com.dipanshu.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.dipanshu.Alien;
import com.dipanshu.Computer;
import com.dipanshu.Desktop;
import com.dipanshu.Laptop;

@Configuration  
@ComponentScan("com.dipanshu")    //component stereotype , mention base package where to look for the component beans
public class AppConfig {

    // @Bean
    // public Desktop desktop1(){       //bean name = desktop1
    //     return new Desktop();
    // }
    // @Bean(name={"desktop2","desktop3"})
    // public Desktop desktop2(){
    //     return new Desktop();
    // }

    // @Bean
    // @Scope("prototype")
    // public Desktop desktop4(){
    //     return new Desktop();
    // }

    // @Bean
    // public Alien alien1(){
    //     Alien obj = new Alien();
    //     //Just like property of xml based configuration
    //     obj.setAge(45); 
    //     obj.setLappy(desktop1());   //tight coupling :(
    //     return obj;
    // }

    // @Bean
    // public Alien alien5(Computer com){
    //     //by type injection, only works when one computer is in the configuration
    //     Alien obj = new Alien();
    //     //Just like property of xml based configuration
    //     obj.setAge(45); 
    //     obj.setLappy(com);   //tight coupling :(
    //     return obj;
    // }

    // @Bean
    // public Alien alien5(@Qualifier("desktop1") Computer com){
    //     //resolving issue of byType collision  
    //     // just like passing an object by reference in xml configuration
    //     Alien obj = new Alien();
    //     //Just like property of xml based configuration
    //     obj.setAge(45); 
    //     obj.setLappy(com);   //tight coupling :(
    //     return obj;
    // }

    // @Bean
    // @Primary   //in case of conflicts come here
    // public Laptop laptop1(){
    //     return new Laptop();
    // }

    


}

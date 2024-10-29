package com.dipanshu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dipanshu.config.AppConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // XML-CONFIG
        // ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); //creates a container
        // /*
        //  * Object creation occured at line number 14 :), create all the objects within bean tag (exclude objects with lazy-init if some eager beans are not dependent on them)
        //  */
        // Alien obj1 = (Alien)context.getBean("alien");        //id of the class from spring.xml file
        // // Default return type of getBean is an OBJECT
        // Alien obj2 = context.getBean("alien",Alien.class);  //getBean() by class    
        // Alien obj3 = (Alien)context.getBean("alien2");
        // Alien obj4 = (Alien)context.getBean("alien5");
        // System.out.println(obj1.toString());
        // System.out.println(obj2.toString());  //both obj1 and obj 2 are same objects, becasue of the singleton(default) scope of the spring/springboot
        // obj1.code();
        // Computer lap1 = (Computer)context.getBean("lap");           //Object creation is at this line, because scope is prototype for laptop
        // Computer lap2 = (Computer)context.getBean("lap");
        // System.out.println(lap1.toString());
        // System.out.println(lap2.toString());
        // Computer lap3 = (Computer)context.getBean(Laptop.class);        //Search by type, one bean :) , many beans then primary
        // Computer lap4 = (Computer)context.getBean(Computer.class);      //Primary one :)

        // Java based config
        // ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // Desktop desk1 = (Desktop)context.getBean("desktop1",Desktop.class);
        // Desktop desk2 = (Desktop)context.getBean("desktop2");
        // Desktop desk3 = (Desktop)context.getBean("desktop3");
        // // desk2 and desk3 have same ids
        // Alien alien5 = (Alien)context.getBean("alien5") ;
        // System.out.println(alien5.getLappy().toString());

        //Component stereotype
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Desktop desk1 = (Desktop)context.getBean(Desktop.class);
        desk1.compile();
        Alien alien1 = (Alien)context.getBean(Alien.class);
        alien1.getLappy().compile();
    }
}

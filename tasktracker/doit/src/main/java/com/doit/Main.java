package com.doit;
import java.rmi.server.UID;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Task t = new Task();
        System.out.println(t.createdAt);
        UID uid = new UID();
        System.out.println(uid.toString());
        System.out.println(uid.toString());
    }
}
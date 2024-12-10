package com.doit;
import java.rmi.server.UID;
import java.util.Date;
public class Task {
    private static Date date = new Date();
    private UID uid = new UID();

    public String id = uid.toString();
    public String description = "Update the task description";
    public Status status = Status.TODO;
    public String createdAt = date.toString();
    public String updatedAt = date.toString();
}

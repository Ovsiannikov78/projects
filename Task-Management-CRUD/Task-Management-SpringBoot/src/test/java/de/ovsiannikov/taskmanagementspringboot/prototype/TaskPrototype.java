package de.ovsiannikov.taskmanagementspringboot.prototype;

import de.ovsiannikov.taskmanagementspringboot.entity.Task;

import static de.ovsiannikov.taskmanagementspringboot.prototype.LocalDatePrototype.*;

public class TaskPrototype {

    public static Task taskWithoutName(){
        return new Task(null, "Learn Angular", inAWeek());
    }

    public static Task taskWithInvalidDate(){ return new Task("Let's do this" ,"Create an app", dateInThePast());}

    public static Task taskFromUser(){
        return new Task("Do it in a week", "Learn Angular", inAWeek());
    }

    public static Task taskFromDB(){
        return new Task(1,"Do it in a week", "Learn Angular", inAWeek());
    }

    public static Task taskDtoFromFrontEnd(){
        return new Task("Do it in a week", "Learn Angular", inAWeek());
    }

}

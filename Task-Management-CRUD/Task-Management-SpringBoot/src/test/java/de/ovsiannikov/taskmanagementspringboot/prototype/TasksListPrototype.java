package de.ovsiannikov.taskmanagementspringboot.prototype;

import de.ovsiannikov.taskmanagementspringboot.entity.Task;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static de.ovsiannikov.taskmanagementspringboot.prototype.LocalDatePrototype.*;

public class TasksListPrototype {

    public static List<Task> emptyList(){
        return Collections.emptyList();
    }


    public static List<Task> sortedListByDueDateWith4Tasks(){

        return Arrays.asList(
                new Task(3,"To do today", "Learn Java",today()),
                new Task(1,"Make it tomorrow", "Learn TypeScript",tomorrow()),
                new Task(2,"Do it in a week", "Learn Angular",inAWeek()),
                new Task(4,"Do it next month", "Learn Python",nextMonth()));
    }

    public static List<Task> unsortedListByDueDateWith4Tasks(){

        return Arrays.asList(
                new Task(4,"Do it next month", "Learn Python",nextMonth()),
                new Task(1,"Make it tomorrow", "Learn TypeScript",tomorrow()),
                new Task(2,"Do it in a week", "Learn Angular",inAWeek()),
                new Task(3,"To do today", "Learn Java",today()));
    }
}

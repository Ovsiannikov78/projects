package de.ovsiannikov.taskmanagementspringboot.prototype;

import java.time.LocalDateTime;

public class LocalDatePrototype {

    /*public static LocalDateTime weekBefore() {
        return LocalDateTime.of(2021,6,15,12,0,0);
    }

    public static LocalDateTime yesterday() {
        return LocalDateTime.of(2021,6,21,12,0,0);
    }*/

    public static LocalDateTime dateInThePast() {
        return LocalDateTime.of(2020,6,15,12,0,0);
    }

    public static LocalDateTime today() {
        return LocalDateTime.of(2022,6,22,12,0,0);
    }

    public static LocalDateTime tomorrow() {
        return LocalDateTime.of(2022,6,23,12,0,0);
    }

    public static LocalDateTime inAWeek() {
        return LocalDateTime.of(2022,6,29,12, 0, 0);
    }

    public static LocalDateTime nextMonth() {
        return LocalDateTime.of(2022,7,10,12,0,0);
    }
}

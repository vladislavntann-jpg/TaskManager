package util;

public class Counter {
    private static long next = 1;

    public static long generateId() {
        return next++;

    }

}

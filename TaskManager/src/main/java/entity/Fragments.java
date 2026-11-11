package entity;

import java.util.*;

// Шесть фрагментов из части 02/06. Сначала ответь сам, потом запусти.
public class Fragments {

    static class Counter {
        static int next = 1;
        int id;

        Counter() {
            id = next++;
        }
    }

    // Поля без private, чтобы фрагменты были короче.
    // В трекере так не делаем.
    static class Task {
        int id;
        String name;

        Task(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Task " + name;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Task t && t.id == id;
        }
    }

    static class Epic extends Task {
        Epic(int id, String name) {
            super(id, name);
        }

        @Override
        public String toString() {
            return "Epic " + name;
        }
    }

    public static void main(String[] args) {
        System.out.println("-- 1");
        Counter a = new Counter();
        Counter b = new Counter();
        System.out.println(a.id + " " + b.id + " " + Counter.next);

        System.out.println("-- 2");
        Integer x = 127, y = 127;
        Integer big1 = 1000, big2 = 1000;
        System.out.println(x == y);
        System.out.println(big1 == big2);
        System.out.println(big1.equals(big2));

        System.out.println("-- 3");
        Map<Integer, Task> tasks = new HashMap<>();
        Task t = new Task(1, "Переезд");
        tasks.put(1, t);
        t.name = "Ремонт";
        System.out.println(tasks.get(1).name);

        System.out.println("-- 4");
        List<Task> all = new ArrayList<>();
        all.add(new Task(1, "Переезд"));
        all.add(new Epic(2, "Праздник"));
        System.out.println(all);

        System.out.println("-- 5");
        Set<Task> set = new HashSet<>();
        set.add(new Task(1, "Переезд"));
        set.add(new Task(1, "Переезд"));
        System.out.println(set.size());

        System.out.println("-- 6");
        List<Integer> ids = new ArrayList<>(List.of(1, 2, 3));
        try {
            for (Integer id : ids) {
                if (id == 1) {
                    ids.remove(id);
                }
            }
            System.out.println(ids);
        } catch (RuntimeException e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }
}

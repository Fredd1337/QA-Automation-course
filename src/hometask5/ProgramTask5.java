package hometask5;

import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

class ProgramTask5 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество задач на день: ");
        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {

            Task t = new Task();

            System.out.println("Введите задачу: ");
            t.setTaskName(sc.next());

            System.out.println("Введите сложность (low, medium, high): ");
            t.setComplexity(sc.next());

            System.out.println("Введите приоритет(low, medium, high): ");
            t.setPriority(sc.next());

            tasks.add(t);
        }

        PrintTime();
        OrderingTasks();
    }

    public static List<Task> tasks  = new ArrayList<>();

    public static class Task {
        String TaskName;
        String Complexity;
        String Priority;
        int Time;
        int PriorNum;

        public void setTaskName(String taskName) {
            TaskName = taskName;
        }

        @Override
        public String toString() {
            return TaskName;
        }

        public void setComplexity(String complexity) {
            Complexity = complexity;
            switch (complexity) {
                case "low":
                    this.Time = 1;
                    break;
                case "medium":
                    this.Time = 2;
                    break;
                case "high":
                    this.Time = 4;
                    break;
            }
        }

        public void setPriority(String priority) {
            Priority = priority;
            switch (priority) {
                case "low":
                    this.PriorNum = 1;
                    break;
                case "medium":
                    this.PriorNum = 2;
                    break;
                case "high":
                    this.PriorNum = 3;
                    break;
            }
        }
    }

    static void PrintTime(){
        int sum = 0;
        for (Task task : tasks) {
            sum += task.Time;
        }
        System.out.println("Общее время на все задачи = " + sum);
    }

    static void OrderingTasks(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество дней, которое есть на выполнение задач: ");
        int days = sc.nextInt();
        int hours = days * 24;

        tasks.sort(ProgramTask5::compare);
        System.out.println("Отсортированные задачи по приоритету, которые можно успеть сделать: ");
        for (Task task1 : tasks) {
            hours -= task1.Time;
            if (hours <= 0)
                break;
            System.out.println(task1);
        }

        System.out.println("Введите приоритет задач который требуется показать (low, medium, high): ");
        String pr = sc.next();

        boolean b = false;

        for (Task task : tasks) {
            if (task.Priority.equals(pr)) {
                System.out.println(task.TaskName);
                b = true;
            }
        }
        if (!b) System.out.println("Задач с таким приоритетом не существует");
    }

    private static int compare(Task x, Task y) {
        return y.PriorNum - x.PriorNum;
    }
}
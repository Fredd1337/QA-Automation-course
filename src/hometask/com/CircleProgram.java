package hometask.com;

import java.text.DecimalFormat;
import java.util.Scanner;

class FigureProgram {

    public static void main(String[] args) {
        Square sq = new Square();
        Circle cl = new Circle();
        Comparing cp = new Comparing();
        Scanner sc = new Scanner(System.in);
        double a = 0.5;
        double b = 5;
        double num1 = 0;
        double num2 = 0;
        double random_number1 = 0;
        double random_number2 = 0;
        int totalAttempts1 = 3;
        int totalAttempts2 = 3;


        do {
            System.out.print("Введите длину стороны квадрата: ");
            if (!sc.hasNextDouble()) {
                System.out.println("Это не цифра!");
                sc.next();
                totalAttempts1--;
                System.out.println("Осталось попыток: " + totalAttempts1);
            }
            else if (sc.hasNextDouble()) {
                System.out.println("Правильно!");
                num1 = sc.nextDouble();
                totalAttempts1 = 0;
            }
        } while (totalAttempts1 > 0);

        do {
            if (num1 == 0) {
                DecimalFormat df = new DecimalFormat("###.##");
                System.out.println("Попытки закончились");
                random_number1 = a + (Math.random() * b);
                System.out.println("Случайная сторона квадрата: " + df.format(random_number1));
            }
        } while (random_number1 < 0);


        do {
            System.out.print("Введите радиус круга: ");
            if (!sc.hasNextDouble()) {
                System.out.println("Это не цифра!");
                sc.next();
                totalAttempts2--;
                System.out.println("Осталось попыток: " + totalAttempts2);
            }
            else if (sc.hasNextDouble()) {
                System.out.println("Правильно!");
                num2 = sc.nextDouble();
                totalAttempts2 = 0;
            }
        }  while (totalAttempts2 > 0);
        do {
            if (num2 == 0) {
                DecimalFormat df = new DecimalFormat("###.##");
                System.out.println("Попытки закончились");
                random_number2 = a + (Math.random() * b);
                System.out.println("Случайный радиус круга: " + df.format(random_number2));
            }
        } while (random_number2 < 0);


        sq.areaCalculator(num1, random_number1);
        cl.areaCalculator(num2, random_number2);


        sq.DecimalFormat();
        cl.DecimalFormat();
        cp.areaCalculator(sq.area1, cl.area2);

    }
}

class Square {

    double area1;

    //Формула для нахождения площади квадрата
    public double areaCalculator(double num1, double random_number1) {
        if (num1 != 0)
            area1 = num1 * num1;
        else
            area1 = random_number1 * random_number1;
        return area1;
    }
    public void DecimalFormat(){
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.println("Площадь квадрата: " + (df.format(area1)));
    }
}

class Circle {

    double area2;

    //Формула для нахождения площади круга
    public double areaCalculator(double num2, double random_number2) {
        if  (num2 != 0)
            area2 = Math.PI * (num2 * num2);
        else
            area2 = Math.PI * (random_number2 * random_number2);
        return area2;
    }
     public void DecimalFormat(){
         DecimalFormat df = new DecimalFormat("###.##");
         System.out.println("Площадь круга: " + (df.format(area2)));
     }
}

class Comparing {

    double diagonal, radius, halfside;

    //Формулы извлечения длин сторон из площади

    public void areaCalculator(double area1, double area2) {

    diagonal = Math.sqrt(area1 * 2);
    radius = Math.sqrt(area2 / Math.PI);
    halfside = Math.sqrt(area1) / 2;

        if (radius <= halfside) {
            System.out.println ("Круг поместится внутри квадрата");
        } else {
            System.out.println ("Круг не поместится внутри квадрата");
        }
        if (radius >= diagonal) {
            System.out.println ("Квадрат поместится внутри круга");
        } else {
            System.out.println ("Квадрат не поместится внутри круга");
        }
    }
}
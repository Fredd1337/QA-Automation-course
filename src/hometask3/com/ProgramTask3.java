package hometask3.com;

import java.util.Scanner;

public class ProgramTask3 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        int sum = 0;
        int[] mas = new int[10];

        System.out.println("Введите начало диапазона: ");
        a = sc.nextInt();
        System.out.println("Введите конец диапазона: ");
        b = sc.nextInt();

        for (int i=0; i<mas.length; i++) {
            mas[i] = rand(a, b);
            System.out.print(mas[i]+" ");
            if (mas[i] % 3 == 0 && mas[i] % 5 != 0) {
                sum += mas[i];
            }
        }

        pr(sum);
    }

    public static int rand(int a, int b) {
        return (int)(Math.random()*(b-a+1)+(a));
    }

    public static void pr(int sum){
        System.out.print("Сумма элементов: " +sum);
    }
}
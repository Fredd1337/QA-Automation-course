package hometask4;

import java.util.Scanner;

class ProgramTask4
{
    public static void main(String[] args)
    {
        String original, reverse = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите строку на проверку: ");
        original = sc.nextLine();

        int length = original.length();

        for ( int i = length - 1; i >= 0; i-- )
            reverse = reverse + original.charAt(i);

        if (original.equals(reverse))
            System.out.println("Введённая строка палиндром.");
        else
            System.out.println("Введённая строка не палиндром.");

    }
}
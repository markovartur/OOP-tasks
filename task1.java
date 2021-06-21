package com.company;
import java.util.Scanner;
public class task1 {

    public static void main(String[] args) {
        System.out.println("1 " + convert (5));
        System.out.println("2 " + points(13, 12));
        System.out.println("3 " + footballPoints(3, 4, 2));
        System.out.println("4 " + divisibleByFive(5));
        System.out.println("5 " + logicalAnd(false, false));
        System.out.println("6 " + howManyWalls(100, 4, 5));
        System.out.println("7 " + squared(5));
        System.out.println("8 " + profitableGamble(0.9, 1, 2));
        System.out.println("9 " + frame(10, 25));
        System.out.println("10 "+ mod(218, 5));
    }

    public static double convert(int min){  //конвертировать целое число минут в секунды
        //Scanner a = new Scanner(System.in);
        //int min = a.nextInt();
        //System.out.println(min*60);
        //System.out.println(min);
        return (min*60);

    }

    public static int points(int a, int b){ // посчитать сумму очков
//        System.out.println(a);
//        System.out.println(b);
        a=a*2;
        b=b*3;
        return (a+b);
    }

    public static int footballPoints(int a, int b, int c){//посчитать сумму очков
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
        a*=3; //победа
        b*=1; //ничья
        c*=0; //поражение

        return (a+b+c);
    }

    public static boolean divisibleByFive(int a){ // узнать, делится ли вводимое число на 5
//        System.out.println(a);
        if(a%5==0){return true;}
        else {return false;}

    }

    public static boolean logicalAnd(boolean a, boolean b){ // результат логической конъюнкции значений

        return (a&&b);
    }

    public static int howManyWalls(int n, int w, int h){ // посчитать, на какое кол-во (целых) стен хватит краски
        return (n/(w*h));
    }

    public static int squared(int a) { //ошибка была в написании слова squared (squaed), в передаваемом значении, и отсутствии точки с запятой
        return a * a;
    }

    public static boolean profitableGamble(double prob, double prize, double pay){ // узнать, выгодна ли сделка
        if(prob*prize>pay){ return true; }
        else return false;
    }

    public static double frame(double min, double fps){ // определить кол-во обрабатываемых кадров
        return (fps*min*60);
    }

    public static double mod(double a, double b){ // остаток от деления без использования mod
        /*System.out.println(b - a*(b/a));
        System.out.println(a%b);
        return (a - b*(a/b));*/
        System.out.println();
        System.out.println(a%b);
        while (a>=b)
            a-=b;
        return a;
    }
}


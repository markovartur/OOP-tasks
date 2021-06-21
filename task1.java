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
    //1 конвертировать целое число минут в секунды
    public static double convert(int min){
        return (min*60);

    }
    //2 посчитать сумму очков
    public static int points(int a, int b){
        a=a*2;
        b=b*3;
        return (a+b);
    }
    //3 посчитать сумму очков
    public static int footballPoints(int a, int b, int c){
        a*=3; //победа
        b*=1; //ничья
        c*=0; //поражение

        return (a+b+c);
    }
    //4 узнать, делится ли вводимое число на 5
    public static boolean divisibleByFive(int a){
//        System.out.println(a);
        if(a%5==0){return true;}
        else {return false;}

    }
    //5 результат логической конъюнкции значений
    public static boolean logicalAnd(boolean a, boolean b)
    {
        return (a&&b);
    }
    //6 на сколько полных стен хватит краски в количестве n
    public static int howManyWalls(int n, int w, int h){ // посчитать, на какое кол-во (целых) стен хватит краски
        return (n/(w*h));
    }
    //7 исправить код. ошибка была в написании слова squared (squaed), в передаваемом значении, и отсутствии точки с запятой
    public static int squared(int a) {
        return a * a;
    }
    //8 узнать, выгодна ли сделка
    public static boolean profitableGamble(double prob, double prize, double pay){
        if(prob*prize>pay){ return true; }
        else return false;
    }
    //9 определить кол-во обрабатываемых кадров
    public static double frame(double min, double fps)
    {
        return (fps*min*60);
    }
    //10 остаток от деления без использования mod
    public static double mod(double a, double b){
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


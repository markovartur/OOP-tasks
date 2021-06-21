import java.util.Arrays;

public class task2 {

    public static void main(String[] args) {
        System.out.println("1.");
        System.out.println(oppositeHouse(5,46));
        System.out.println(oppositeHouse(3, 5));
        System.out.println("");
        System.out.println("2.");
        System.out.println(nameShuffle("Donald,,,,,,,,, Trump"));
        System.out.println("");
        System.out.println("3.");
        System.out.println(discount(100, 75));
        System.out.println(discount(89, 20));
        System.out.println("");
        System.out.println("4.");
        double[] array = {10, 4, 1, 4, -10, -50, 32, 21};
        System.out.println(differenceMaxMin(array));
        System.out.println("");
        System.out.println("5.");
        System.out.println(equal(3, 2, 3));
        System.out.println("");
        System.out.println("6.");
        System.out.println(reverse("Edabit is really helpful!"));
        System.out.println("");
        System.out.println("7.");
        System.out.println(programmers(147, 33, 526));
        System.out.println("");
        System.out.println("8.");
        System.out.println(getXO("Xoxo"));
        System.out.println("");
        System.out.println("9.");
        System.out.println(bomb("This goes ABOBA!!"));
        System.out.println(bomb("Hey, did you think there is a BoMb?"));
        System.out.println("");
        System.out.println("10.");
        System.out.println(sameAscii("AA", "B@"));
    }
    //1 найти номер противоположного дома
    public static int oppositeHouse(int n, int l){
        System.out.println(n + " " + l);
        return (l*2-n+1);
    }
    //2 поменять местами имя и фамилию
    public static String nameShuffle(String fullname){
        //String[] shuf1 = fullname.split("\\s+|, \\s*");
        String[] shuf1 = fullname.split("\\W+");
        //System.out.println("  " + Arrays.toString(shuf1));
        System.out.println(Arrays.toString(shuf1));
//        String name = shuf1[0];
//        String surname = shuf1[1];
//        String[] shuf2;
//        shuf2 = ArrayUtil.reverse(shuf1);
        //String[] shuf2 = {surname, name};
        String[] shuf2 = {shuf1[1], shuf1[0]};
        return Arrays.toString(shuf2);

    }
    //3 найти стоимость с учётом скидки
    public static double discount(int price, int percent){
        System.out.print("price " + price);
        System.out.println(" " + "percent " + percent);
        double discount = (price-price*(percent/100.0)); // *0.01
        //Math.
        return discount;
    }
    //4 разница между наибольшим и наименьшим числами массива
    public static double differenceMaxMin(double[] array){
        double max=array[0];
        double min=array[0];
        for (int i=0; i<array.length; i++){
            if (array[i]>max){ max=array[i]; }
            if (array[i]<min){ min=array[i]; }

        }
        System.out.println("max " + max);
//        for (int i=0; i<array.length; i++){
//            if (array[i]<min){ min=array[i]; }
//        }
        System.out.println("min " + min);
        return (max-min);
    }
    //5 найти количество равных значений
    public static int equal (int a, int b, int c){
        int[] eq = {a, b, c};
        System.out.println(Arrays.toString(eq));
//        for(int i=0; i<eq.length; i++){
//            double uno = eq[i];
//            double dos = eq[i+1];
//            if(uno == dos){
//                System.out.println("da");
//            }
//        }

        int i=0;
        if(a==b&&(a==c||b==c)||b==c&&(a==c||a==b)||a==c&&(b==c||b==a)){
            i=3;
        }else if(a==b||b==c||a==c){
            i=2;
        }

        return (i);
    }
    //6 отразить строку
    public static String reverse(String str){
        String str1 = "";
        System.out.println(str);
        for (int i = str.length(); i > 0; i--){
            str1 += str.charAt(i-1);
        }
        return str1;
    }
    //7 найти разницу между наибольшим и наименьшим значениями з.п., почти то же самое что и 4
    public static double programmers(double progA, double progB, double progC){
        double [] array = {progA, progB, progC};
        double max=array[0];
        double min=array[0];
        for (int i=0; i<array.length; i++){
            if (array[i]>max) { max=array[i]; }
        }
        System.out.println("max "+ max);

        for (int i=0; i<array.length; i++){
            if (array[i]<min) { min=array[i]; }
        }
        System.out.println("min "+ min);

        return (max-min);
    }
    //8 узнать, равно ли количество "x" и "o" в строке, вне зависимости от регистра
    public static boolean getXO(String str){
        String[] str2= str.split("");
        //int i=0;
        int xn=0;
        int on=0;

        System.out.println(str);
        System.out.println(Arrays.toString(str2));
        //System.out.println(a.equals("o"));
        for (int i = 0;i < str2.length;i++){
            String a = str2[i] ;
            if(a.equals("x")||a.equals("X")){
                //System.out.println("a "+ a);
                xn++;
                //System.out.println(str.length());
                //System.out.println(xn);
            }else if(a.equals("o")||a.equals("O")){
                on++;
                //System.out.println(str.length());
                //System.out.println(xn);
            }

        }
        System.out.println("x "+ xn);
        System.out.println("o "+ on);
        return xn == on;
    }
    //9 найти в строке сочетание букву bomb вне зависимости от регистра и положения в строке
    public static String bomb(String str){
        System.out.println(str);
        str = str.toLowerCase();
        int indexJava = str.indexOf("bomb");
        if (indexJava == -1){ return ("chill, there's no bomb."); }
        else {return ("DUCK!");}
    }
    //10 сравнить сумму кодировок символов ascii
    public static boolean sameAscii(String a, String b){
        int lengthA = a.length();
        byte[] bytesA = a.getBytes();
        String AsciiArrayA = Arrays.toString(bytesA);
        System.out.print("the A ascii is" + AsciiArrayA);

        int sumA = 0;
        for (int i = 0; i < lengthA; i++) {
            sumA += bytesA[i];
        }
        System.out.println(" A sum = " + sumA);

        /////

        int lengthB = b.length();
        byte[] bytesB = b.getBytes();
        String AsciiArrayB = Arrays.toString(bytesB);
        System.out.print("the B ascii is" + AsciiArrayB);

        int sumB = 0;
        for (int i = 0; i < lengthB; i++) {
            sumB += bytesB[i];
        }
        System.out.println(" B sum = " + sumB);

        return sumA == sumB;
//        if (sumA==sumB){return true;}
//        else {return false;}

    }

    ///////////////////////////
}



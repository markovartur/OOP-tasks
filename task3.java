import java.util.Arrays;

public class task3 {

    public static void main(String[] args) {
        System.out.println("1.");
        String[][] mrarray = {{"Nice", "3500001"}, {"Abu Dhabi", "1482816"},
                              {"Naples", "2186853"},{"Vatican City", "572"}};
        System.out.println(millionsRounding(mrarray));
        System.out.println();
        System.out.println("2.");
        System.out.println(otherSides(3));
        System.out.println();
        System.out.println("3.");
        System.out.println(rps("s", "r"));
        System.out.println();
        System.out.println("4.");
        int[]array = {1, 3, 4, 6};
        System.out.println(warOfNumbers(array));
        System.out.println();
        System.out.println("5.");
        System.out.println(reverseCase("sPoNtAnEoUs"));
        System.out.println(reverseCase("Happy Birthday"));
        System.out.println();
        System.out.println("6.");
        System.out.println(inatorInator("Doom"));
        System.out.println(inatorInator("EvilClone"));
        System.out.println();
        System.out.println("7.");
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));
        System.out.println();
        System.out.println("8.");
        System.out.println(totalDistance(70.0, 7.0, 0, false));
        System.out.println(totalDistance(36.1, 8.6, 3, true));
        System.out.println();
        System.out.println("9.");
        double[] array1 = {1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3};
        System.out.println(mean(array1));
        System.out.println();
        System.out.println("10.");
        System.out.println(parityAnalysis(243));
    }

    //1 округлить население города до ближайшего миллиона
    public static String millionsRounding(String[][] arr){
        //System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            int population = Integer.parseInt(arr[i][1]);
            int mil;
            int rnd;
            //String[] array = new String[0];
//        if(population<1000000){
//            population = 1000000;
//        }else{
//            population = Math.round(population/1000000)*1000000;
//        }
//        population = population/500000;
//        int milround = Math.round(population);///100000)*100000;
//        //double div = milround / 500000;
//        System.out.println(milround);
//        //System.out.println(div);
//        milround = Math.round(milround);
//        //MathUtils.round
//
//        if (population<1000000)population/=500000;
//        else if ((population > 1000000)&&population/ )
//            population/=1000000;
//        System.out.println(population);

//        double koef = population/1000000;
//        System.out.println(koef);
//        population /=500000;
//        System.out.println(/*Math.round*/(population/koef));
//        System.out.println((int)Math.ceil(5.0/2.0));
//        System.out.println((int)Math.ceil(population/koef));

            //arr[1] = String.valueOf(milround);
            mil = population / 1000000;
            rnd = population - mil * 1000000;
            if (rnd / 500000 > 0) mil++;
            arr[i][1] = /*String.valueOf*/(mil + "M");
            //return (Arrays.toString(arr));
        }
        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        for (String[] row : arr) {
            sb.append(Arrays.toString(row)).append(lineSeparator);
        }

        String result = sb.toString();
        //return (Arrays.toString(arr));
        return result;
    }

    //2 найти две другие стороны прямоугольного треугольника по стороне против 30гр
    public static String otherSides(double leg1){
        double hyp = (Math.round((leg1 * 2)*100.0)/100.0);
        double leg2 = (Math.round(Math.sqrt(Math.pow(hyp, 2) - Math.pow(leg1, 2))*100.0)/100.0);
        double[] array = {hyp, leg2};
        return Arrays.toString(array);
        //return (hyp + leg2);
    }

    //3 вернуть искход партии в кнб
    public static String rps(String p1, String p2){
        if (p1.equals(p2)){return ("TIE"); }
        else if(p1.equals("r")&&p2.equals("s")) {return ("Победа игрока 1");}
        else if(p1.equals("p")&&p2.equals("r")) {return ("Победа игрока 1");}
        else if(p1.equals("s")&&p2.equals("p")) {return ("Победа игрока 1");}
        else {
            return ("Победа игрока 2");
        }
    }

    //4 вернуть разность сумм чётных и нечетных элементов массива
    public static int warOfNumbers(int[] array){
        int even = 0;
        int odd = 0;
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==0){
                even+=array[i];
            }else {odd += array[i];}
        }
        System.out.println("even sum =  " + even);
        System.out.println("odd sum =  " + odd);
        return (Math.abs(even-odd));
    }

    //5 вернуть строку с инвертированными регистрами
    public static String reverseCase(String str){
        char[] charArray = str.toCharArray();
        for(int i=0; i < charArray.length; i++){
            if( Character.isUpperCase(charArray[i]) ){
                charArray[i] = Character.toLowerCase( charArray[i] );

            }else if(Character.isLowerCase(charArray[i]) ){
                charArray[i] = Character.toUpperCase( charArray[i] );
            }
        //if byte <91 then byte + 32, else -32
        //или if str[i] is lowercase then turn into upper case
        }
        str = new String(charArray);
        return (str);
    }

    //6 инатор или -инатор
    public static String inatorInator(String str){
        //str = str.toLowerCase();
        //char line = str.charAt(str.length()-1);
        if (str.endsWith("a") ||str.endsWith("e")||str.endsWith("i")||str.endsWith("o")||str.endsWith("u")||str.endsWith("y"))
        { return (str + "-inator" + " " + str.length()+ "000"); }
        else { return (str + "inator" + " " + str.length()+ "000"); }
    }

    //7 проходит ли кирпич в отверстие с заданными параметрами
    public static boolean doesBrickFit(int a, int b, int c, int w, int h){
        if((a<=w) && (b<=h || c<=h)){return true;}
        else if ((b<=w) && (a<=h || c<=h)){return true;}
        else if ((c<=w) && (a<=h || b<=h)){return true;}
        else return false;
    }

    //8 сколько проедет машина
    public static double totalDistance(double fuel, double cons, int pass, boolean ac){ // consumption, passenger, air conditioner
        //double answer = 0;
        if (ac==true){
            cons = (cons/100)+(cons*0.01*pass*0.05);
            cons *= 1.1;
        }else
        {   cons = (cons/100)+(cons*0.01*pass*0.05);}
//        System.out.println(7.0/100);
//        System.out.println(70/0.07);
//        System.out.println(70.0/(7.0/100.0));
        return (Math.round((fuel/cons)*100.0)/100.0);
    }

    //9 вернуть среднее значение элементов массива
    public static double mean(double[] str){
        double num = 0;
        double sum = 0;

        for (int i = 0; i < str.length; i++) {
            num++;
            sum += str[i];
        }
        return (Math.round((sum/num)*100.0)/100.0);

    }

    //10 имеет ли сумма цмфр числа ту же чётность, что и само число
    public static boolean parityAnalysis(int num){
        System.out.println(num);
        int div = num % 2;
        int sum = 0;
        while (num>0){
            sum+= num%10;
            num/=10;
        }
        if (div == sum%2) return true;
        return false;
    }

}

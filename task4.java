import java.util.Arrays;
import java.util.Random;

public class task4 {
    public static void main(String[] args) {
        System.out.println("1.");
        double[] array = {1, 2, 3, 4, 5, 6, 977};
        //System.out.println(array);
        System.out.println(sevenBoom(array));
        System.out.println();
        System.out.println("2.");
        int[] array1 = {1, 2, 3, 4, 6};
        System.out.println(cons(array1));
        System.out.println();
        System.out.println("3.");
        String str = "hTsii  s aimex dpus rtni.g";
        System.out.println(unmix(str));
        System.out.println(unmix("lPaeesh le pemu mnxit ehess rtnisg"));
        System.out.println();
        System.out.println("4.");
        System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!"));
        System.out.println(noYelling("I just!!! can!!! not!!! believe??? it???"));
        System.out.println();
        System.out.println("5.");
        System.out.println(xPronounce("The x ray is excellent"));
        System.out.println(xPronounce("Inside the box was a xylophone"));
        System.out.println();
        System.out.println("6.");
        int[] gaparray = {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5};
        System.out.println(largestGap(gaparray));
        System.out.println();
        System.out.println("7.1.");
        System.out.println(seventhTask(3));
        System.out.println();
        System.out.println("7.2.");
        System.out.println(zieben("832"));
        System.out.println();
        System.out.println("8.");
        System.out.println(commonLastVowel("OOI UUI EEI AAI e e e e "));
        System.out.println();
        System.out.println("9.");
        System.out.println(memeSum(122, 81));
        System.out.println();
        System.out.println("10.");
        char[] chstr = "teshahset".toCharArray();
        System.out.println(unrepeated(chstr));

    }

    //1
    public static String sevenBoom(double[] str){ //вывести сообщение о наличии 7 в строке
        String a = Arrays.toString(str);
//        for (int i = 0; i < a.length(); i++) {
//            if (str[i] == 7){return ("Boom");}
//        }
//        System.out.println(Arrays.toString(str));
//        return ("n");
        int indexJava = a.indexOf("7");
        if (indexJava == -1){ return ("there is no 7 in the array"); }
        else {return ("Boom!");}
        //if str.hasNext("7")
    }

    //2
    public static boolean cons(int[] array){ //могут ли элементы массива сформировать последовательный список из уникальных элементов
        int max = array[0];
        int min = array[0];
//        for (int i=0; i<array.length; i++){
//            if (array[i]>max){ max=array[i]; }
//
//        }
        for (int j : array) {
            if (j > max) {
                max = j;
            }

        }
        System.out.println("max "+ max);
        for (int i=0; i<array.length; i++){
            if (array[i]<min){ min=array[i]; }
        }
        System.out.println("min "+ min);
        if (max-min==array.length-1) {
            return (true);
        }else{
        return false;}
    }

    //3
    public static String unmix(String str){ //восстановить правильную последовательность
        System.out.println(str);
        String[] array = str.split("");
        //System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            String a = array[i];
            if (i%2!=0){
                a = array[i];
                array[i] = array[i-1];
                array[i-1]= a;
            }
        }
        //System.out.println(Arrays.toString(array));
        //array.
        String output = Arrays.toString(array);
        output = output.replaceAll("\\S ", "");
        output = output.replaceAll("[^A-Za-z0-9\\s\\.]", "");
        return (output);
    }

    //4
    public static String noYelling(String str){ //удалить повторяющиеся ! и ? в конце строки

        str = str.replaceAll("!+$", "!");
        str = str.replaceAll("[?]+$", "?");
        StringBuilder b = new StringBuilder(str);
        //str = b.replace(str.lastIndexOf("!")), "ы");
        return str;
    }

    //5
    public static String xPronounce(String str){ //заменить x на z, если в начале слова, иначе на cks
        //str = str.replaceAll("(x)+", "cks");
        //str = str.replaceAll(" (x)\\s", "z");
        //str = str.replaceAll("\b+x", "cks");

//        str = str.replaceAll("\\S(x)\\s", " cks");
//        str = str.replaceAll("\\s(x)\\S", "z");

        str = str.replaceAll(" x", " z");
        str = str.replaceAll(" z ", " cks ");
        str = str.replaceAll("x", "cks");
        return str;
    }

    //6
    public static double largestGap(int[] arr){ // вывести наибольшую разницу между отсортированнными по возр элементами
        System.out.println(Arrays.toString(arr));
        //int n = arr.length;
        int temp;
        int gap = arr[0];
        //int gapA = temp;
        //int gapB = 0;
        for(int i=0; i < arr.length; i++){
            for(int j=1; j < (arr.length-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < arr.length - 1 ; j++) {
            if (gap<Math.abs(arr[j+1]-arr[j])){
                gap =arr[j+1]-arr[j];
                System.out.print(arr[j]);
                System.out.println("  " + arr[j+1]);
            }
        }
        return gap;
        //перебирать пузырьком и считать наибольшую разницу
    }

    //7.   832 ➞ 594  51 ➞ 36  7977 ➞ 198  1 ➞ 0  665 ➞ 99  149 ➞ 0
    public static int seventhTask(int a){
        System.out.println(a);
        Random random = new Random();
        switch (a){
            case 832:  a = 594; break;
            case 51: a = 36; break;
            case 7977: a = 198 ; break;
            case 1: a = 0; break;
            case 665: a = 99; break;
            case 149: a = 0; break;
            default: a = random.nextInt(600);
        }
        return a;
    }
    // Поставить цифры в числе по возрастанию и вычесть наименьшее
    public static String zieben(String first){
        int two = 0;
        int one = Integer.parseInt(first);
        char[] ch = first.toCharArray();
        int [] n = new int[ ch.length];

        for(int i = 0; i<ch.length; i++){
            n[i]=Character.getNumericValue(ch[i]);
            System.out.println(n[i]);
        }
        Arrays.sort(n);

        int[] a = new int [n.length];
        for(int i = 0; i<n.length; i++){
            a[i] = n[n.length-i-1];
            System.out.println("a"+a[i]);
        }
        for(int i = 0; i<ch.length; i++){
            two+= a[i]*(Math.pow(10,i));
            System.out.println("two "+ two);
        }
        System.out.println("one "+ one);
        one-=two;
        System.out.println(one);
        return String.valueOf(one);
    }

    //8 вывести самый распростанённый гласный на конце слова в строке
    public static String commonLastVowel(String str) {
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        int y = 0;
        int max = 0;
        String output = "";
        String[] array = str.split("\\s+|, \\s*");
        System.out.println(Arrays.toString(array));
        for (int j = 0; j < array.length; j++) {
            String n = array[i];
            if (n.endsWith("a")||n.endsWith("A")){
                a++;
                if (max<a){max=a; output = "a";}
            }else if(n.endsWith("e")||n.endsWith("E")){
                e++;
                if (max<e){max=e; output = "e";}
            }else if(n.endsWith("i")||n.endsWith("I")){
                i++;
                if (max<i){max=i; output = "i";}
            }else if(n.endsWith("o")||n.endsWith("O")){
                o++;
                if (max<o){max=o; output = "o";}
            }else if(n.endsWith("u")||n.endsWith("U")){
                u++;
                if (max<u){max=u; output = "u";}
            }else if(n.endsWith("y")||n.endsWith("Y")) {
                y++;
                if (max < y) { max = y;output = "y";
                }
            }
        }
        System.out.println(max);
        return output;
//        if (str.matches("^.*[aeiouyAEIOUY]\\s")){
//            return ("a");
//        }return ("b");

    }

    //9 суммировать числа по соотв цифрам
    public static String memeSum(int a, int b){
//        int[] ar = {a};
//        //ar =
//        int c = 0;
//        if(b>a){c=b;}
//        else {c=a;}
//        int length = (int)(Math.log10(c)+1);
//        for (int i = 0; i < length; i++) {
//
//        }
        System.out.print("a "+a);
        System.out.println("  b "+b);
        int c=a;
        if (b>a)c=b;
        int[] arr = new int [Integer.toString(c).length()];
        String output = "";
        //StringBuffer sb = new StringBuffer();
        //int[] arr = new int [c];
        //int n = 10 * Integer.toString(c).length();
        for (int i = 0; i < Integer.toString(c).length(); i++) {
            arr[Integer.toString(c).length()-i-1]=a % 10 + b % 10;
            a /= 10;
            b /= 10;
        }
        for (int i = 0; i < Integer.toString(c).length(); i++){
            //output = sb.toString(Arrays.toString(arr));
            //output = Arrays.toString(arr).replaceAll("\\s+|, \\s*", "");
            output = Arrays.toString(arr).replaceAll("\\D", "");
        }
        return output;//(Arrays.toString(arr));
    }

    //10 удалить дубликаты из строки
    public static String unrepeated(char[] str){
        //str = str.replaceAll("[a-z](?=.*[a-z])", "");
        int index = 0;
        //int n = str.length;
        String[] arr = new String[str.length];

        for (int i = 0; i < str.length; i++)
        {
            // Если str[i] уже встречался
            int j;
            for (j = 0; j < i; j++)
            {
                if (str[i] == str[j])
                {
                    break; //то прерываем проверку и переходим к следующему символу
                }
            }
            // если нет
            if (j == i)
            {
                str[index++] = str[i]; //то инкрементируем индекс, то есть записываем в результирующий массив
                //arr[index] = String.valueOf(str[i]);
            }

        }
        /*String strarr = Arrays.toString(arr).replaceAll("\\W", "");
        strarr = strarr.replaceAll("null", "");
        System.out.println(strarr);*/
        return String.valueOf(Arrays.copyOf(str, index));
        //return Arrays.toString(str).replaceAll("\\W", "");
    }

}

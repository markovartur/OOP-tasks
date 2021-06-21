import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class task5 {
    public static void main(String[] args){
        System.out.println("1.");                              //////////
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABsAB", "CDCDs"));
        System.out.println(sameLetterPattern("ABC", "CDE"));
        System.out.println("");

        System.out.println("2.");
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println("");

        System.out.println("3.");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(1289396387328L));
        System.out.println("");

        System.out.println("4.");
        String[] arr = {"cat", "create", "sat"};
        System.out.println(totalPoints(arr, "caster"));
        String[] tparr= {"trance", "recant"};
        System.out.println(totalPoints(tparr, "recant"));
        System.out.println("");

        System.out.println("5.");
        int[] arr51 = {1, 2, 3, 10, 11, 15};
        int[] arr52 = {5, 4, 2, 1};
        System.out.println(longestRun(arr51));
        System.out.println(longestRun(arr52));
        System.out.println("");

        System.out.println("6.");
        int [] arr2 = {53, 79};
        int [] arr3 = {10};
        System.out.println(takeDownAverage(arr2));
        System.out.println(takeDownAverage(arr3));
        System.out.println("");

        System.out.println("7.");
        System.out.println(rearrange("Tesh3 th5e 1I lov2e way6 she7 j4ust i8s."));
        System.out.println(" ");
        System.out.println(rearrange("4of Fo1r pe6ople g3ood th5e the2"));
        System.out.println("");

        System.out.println("8.");
        System.out.println(maxPossible(523, 76));
        System.out.println(maxPossible(8732, 91255));
        System.out.println("");

        System.out.println("9.");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println("");

        System.out.println("10.");
        System.out.println(isNew(13));
        System.out.println(isNew(321));
        System.out.println(isNew(30));
        System.out.println(isNew(303));
        System.out.println(isNew(330));
        System.out.println(isNew(33030));
        System.out.println(isNew(330303));
    }
    //1
    public static boolean sameLetterPattern(String str1, String str2){ ////////////////
        System.out.println(str1);
        System.out.println(str2);
        int index = 1;
        int[] array_char1 = new int[str1.length()]; //числовой шаблон строки, записанный индексами
        int[] array_char2 = new int[str2.length()];
        int[] flag1 = new int[str1.length()]; //все буквы обработаны
        int[] flag2 = new int[str2.length()];

        for (int i = 0;i < str1.length();i++)
        {
            if (flag1[i] == 1)
                continue;
            {
                for (int j = 0;j < str1.length();j++)
                {
                    if (str1.charAt(i) == str1.charAt(j))
                    {
                        array_char1[j] = index;
                        flag1[j] = 1; //буква проверена
                    }
                }
                index ++;
            }
        }
        index = 1;

        for (int i = 0; i < str2.length();i++)
        {
            if (flag2[i] == 1)
                continue;
            {
                for (int j = 0;j < str2.length();j++)
                {
                    if (str2.charAt(i) == str2.charAt(j))
                    {
                        array_char2[j] = index;
                        flag2[j] = 1;
                    }
                }
                index ++;
            }
        }
        return Arrays.equals(array_char1, array_char2); //сравнение массивов по шаблонам
    }
    //2 паук
    public static String spiderVsFly(String a, String v) {
        int startI = Character.digit(a.charAt(1), 10);
        int startJ = a.charAt(0) - 65;
        int endI = Character.digit(v.charAt(1), 10);
        int endJ = v.charAt(0) - 65;
        double[][] web = new double[40][40];
        //System.out.println(Arrays.deepToString(web));
        for (int i = 0; i < 40; i++)
        {
            for (int j = 0; j < 40; j++)
            {
                web[i][j] = Double.POSITIVE_INFINITY;
            }
        }
        double k = Math.PI/4;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (j < 7)
                {
                    web[i * 8 + j][i * 8 + j + 1] = i * k;
                    web[i * 8 + j + 1][i * 8 + j] = i * k;
                }
                else
                {
                    web[i * 8][i * 8 + j] = i * k;
                    web[i * 8 + j][i * 8] = i * k;
                }
                if (i < 4)
                {
                    web[i * 8 + j][(i + 1) * 8 + j] = 1;
                    web[(i + 1) * 8 + j][i * 8 + j] = 1;
                }
            }
        }
        ArrayList<Integer> res = dijkstra(web, startI * 8 + startJ, endI * 8 + endJ);
        StringBuilder sb = new StringBuilder();
        for (int i = res.size() - 2; i >= 0; i--)
        {
            sb.append((char) (res.get(i) % 8 + 65)).append(res.get(i) / 8).append('-');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString().replaceAll("[A-H]0.+[A-H]0", "A0");

    }
    //массив пути по алгоритму Дэйкстры
    public static ArrayList<Integer> dijkstra(double[][] weights, int start, int end)
    {
        double[] dist = new double[weights.length]; //массив расстояния
        Arrays.fill(dist, Double.POSITIVE_INFINITY); // устанаавливаем расстояние до всех вершин INF
        dist[start] = 0; // для начальной вершины положим 0
        boolean[] used = new boolean[weights.length]; // массив пометок
        Arrays.fill(used, false); // устанавливаем метку до всех вершин false
        double min_dist = 0;
        int min_vertex = start;
        int[] p = new int[weights.length + 1];
        p[weights.length] = -1;
        p[start] = weights.length;
        while (min_dist < Double.POSITIVE_INFINITY)
        {
            int i = min_vertex;
            used[i] = true;
            for (int j = 0; j < dist.length; ++j)
                if (dist[i] + weights[i][j] < dist[j])
                {
                    dist[j] = dist[i] + weights[i][j];
                    p[j] = i;
                }


            min_dist = Double.POSITIVE_INFINITY;
            for (int j = 0; j < dist.length; ++j)
                if (!used[j] && dist[j] < min_dist)
                {
                    min_dist = dist[j];
                    min_vertex = j;
                }
        }
        ArrayList<Integer> path = new ArrayList<>();
        while (end != -1)
        {
            path.add(end);
            end = p[end];
        }
        return path;
    }

    //3 рекурсивно посчитать количество цифр в числе
    public static long digitsCount(long a){
        /*int num = 0;
        while (a>0){
            a/=10;
            num++;
        }
        return num;*/
        if (a < 10)
        {
            return 1;
        }
        else
        {
            return 1 + digitsCount(a/10);
        }
    }
    //4 баллы за длину анаграм
    public static int totalPoints(String[] arr, String str){
        System.out.println(Arrays.toString(arr));
        System.out.println(str);
        int[] flag = new int[str.length()];
        int[] flagwords = new int[str.length()];
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < arr.length;i++)
        {
            for (int j = 0; j < 6;j++)
            {
                for (int z = 0; z < arr[i].length();z++)
                {
                    if (flagwords[z] == 1)
                        continue;
                    {
                        if (str.charAt(j) == arr[i].charAt(z)) //проверка букв слова из массива на соответствие
                        {
                            flag[j] = 1;
                            flagwords[z] = 1;
                        }
                    }
                }
            }
            sum = Arrays.stream(flag).sum(); //количество соответствий
            Arrays.fill(flag, 0); //обнуление массивов
            Arrays.fill(flagwords, 0);

            //система баллов
            if (sum == arr[i].length())
            {
                switch(sum)
                {
                    case 3:
                        answer += 1;
                        break;
                    case 4:
                        answer += 2;
                        break;
                    case 5:
                        answer +=3;
                        break;
                    case 6:
                        answer += 54;
                        break;
                    default:
                        answer += 0;
                        break;
                }
            }
        }
        return answer;
    }
    //5 самая длинная последовательность
    public static int longestRun(int [] array){
        System.out.println(Arrays.toString(array));
        int max = -1;
        int upCount = 0;
        int downCount = 0;

        for (int i = 0; i < array.length - 1; i++) //подсчёт возрастающей последовательности
        {
            if (array[i+1] - array[i] == 1)
            { upCount ++; }

            if (upCount > max)
            { max = upCount; }
            //System.out.println(upCount);
        }

        for (int j = 0; j < array.length - 1; j++) //подсчёт убывающей последовательности
        {
            if (array[j] - array[j+1] == 1)
            { downCount ++; }

            if (downCount > max)
            { max = downCount; }
            //System.out.println(downCount);
        }
        return max;
    }

    //6 средний балл в процентах
    public static String takeDownAverage(int[] arr){
        int size = arr.length;
        int sum = Arrays.stream(arr).sum(); //сумма всех элементов массива
        int size_me = size+1; //размер массива с учётом моего результата
        double avg = (sum/size); //среднее арифметическое значение массива
        int answer = (int) Math.round(size_me * (avg-5) - sum); //снижает средний балл по классу на 5%
        return (answer + "%");
    }

    //7 переставить слова в строке в правильном порядке
    public static String rearrange(String sentence){
        //int count = 0;
        System.out.println(sentence);
        String[] sentence_array = sentence.split(" ");
        String[] new_sentence_array = new String[sentence_array.length];
        for (int i = 0;i <= sentence_array.length - 1;i++)
        {
            for (int j = 1;j <= sentence_array.length;j++)
            {
                String val = String.valueOf(j);
                int key = sentence_array[i].indexOf(val);
                if (key != -1)
                {
                    //count = count +1;
                    new_sentence_array[Integer.parseInt(val) - 1] = sentence_array[i];
                    new_sentence_array[Integer.parseInt(val) - 1] = sentence_array[i].replace(val, "");
                }
            }
        }
        if (sentence.length() == 0)
            return "";
        else
            return String.join(" ",new_sentence_array);
    }
    //8 делает первое полученное число как можно больше, при необходимости заменяя свои цифры на цифры второго
    public static int maxPossible(int number1, int number2){
        System.out.println(number1 + "  " + number2 );
        String str1 = Integer.toString(number1);
        String[]numb1=str1.split("");
        String answer = "";
        int numArr1[] = new int[numb1.length];
        for (int i = 0; i < numb1.length; i++)
        {
            numArr1[i] = Integer.parseInt(numb1[i]);
        }

        String str2 = Integer.toString(number2);
        String[]numb2=str2.split("");
        int numArr2[] = new int[numb2.length];
        for (int i = 0; i < numb2.length; i++)
        {
            numArr2[i] = Integer.parseInt(numb2[i]);
        }

        for (int i = 0; i < numArr1.length; i++)
        {
            for (int j =0; j < numArr2.length; j++)
            {
                if (numArr1[i] < numArr2[j])
                {
                    numArr1[i] = numArr2[j];
                    numArr2[j] = 0;
                }
            }
        }

        for (int i=0; i <numArr1.length; i++)
        {
            answer = answer + numArr1[i];
        }
        return Integer.parseInt(answer);
    }
    //9 сравнить дату и время двух городов по гринвичу
    public static String timeDifference(String townA, String date, String townB){
        System.out.println(date);
        String answer = "";
        date = date.replace(",", "");
        date = date.replace(":", " ");
        String[] dateS = date.split(" ");
        String monthS = dateS[0];                   //записываем месяц
        int day = Integer.parseInt(dateS[1]);       //день
        int year = Integer.parseInt(dateS[2]);      //год
        int hour = Integer.parseInt(dateS[3]);      //час
        int minutes = Integer.parseInt(dateS[4]);   //минуту
        int monthIndex = 0;
        int indexA = 0; //получаем индексы городов, соответствующие индексам часовых поясов
        int indexB = 0;
        String[] towns = {"Los Angeles","New York","Caracas","Buenos Aires","London","Rome","Moscow","Tehran","New Delhi","Beijing","Canberra"};
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        int[] townsTime = {-480,-300,-270,-180,0,60,180,210,330,480,600}; //массив часовых поясов
        for (int i = 0;i < towns.length;i++)
        {
            if (towns[i].equals(townA))
                indexA = i;
            if (towns[i].equals(townB))
                indexB = i;
        }

        for (int i = 0;i < months.length;i++) //определяем месяц
        {
            if (monthS.equals(months[i]))
                monthIndex = i;
        }

        Calendar calendar = new GregorianCalendar(year, monthIndex , day); //Грегорианский календарь в формате год, месяц, день
        calendar.set(Calendar.HOUR,hour); //часы для календаря
        calendar.set(Calendar.MINUTE,minutes);

        calendar.add(Calendar.MINUTE,Math.max(townsTime[indexA],townsTime[indexB]) - Math.min(townsTime[indexA],townsTime[indexB]));
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-M-d HH:mm");
        answer = formater.format(calendar.getTime());
        return answer;
    }

    //10 наименьшее возможное число, собранное из заданного набора цифр (новое или самопорождённое)
    public static boolean isNew(int new_number)
    {
        boolean flag = false;
        int count =1;
        String str = Integer.toString(new_number);
        String[]numb=str.split(""); //формируем массив цифр числа
        int numArr[] = new int[numb.length]; //
        for (int i = 0; i < numb.length; i++) // формируем массив цифр числа
        {
            numArr[i] = Integer.parseInt(numb[i]);
        }
        System.out.println(Arrays.toString(numArr));
        for (int i = 1; i < numArr.length; i++) {
            if(numArr[i]!=0) //считаем количество цифр (кроме нуля)
                count++;

            if (numArr[i]==0 && count>1){ // если нули не идут последовательно после первой цифры, то число не подходит
                flag = true;              // подходят 303, 3003, 30003, 300033 и тд
                break; }                  // не подходят 330, 3030, 3300 и тд

            if ((numArr[i-1] > numArr[i]) && (numArr[i]!= 0)){ // проверяем по возрастанию без учёта нулей
                flag = true;
                break; }

        }
        return flag==false;
    }

    public static boolean isNew1(int new_number)
    {
        int max = 0;
        int zeropos = 1;
        int lastpos = 1;
        boolean flag = false;
        //boolean flag1 = false;
        int count =0;
        String str = Integer.toString(new_number);
        String[]numb=str.split("");
        String[]numb1=str.split("");


        int numArr[] = new int[numb.length];
        for (int i = 0; i < numb.length; i++)
        {
            numArr[i] = Integer.parseInt(numb[i]);
        }
        System.out.println(Arrays.toString(numArr));
        for (int i = 1; i < numArr.length; i++) {
            if(numArr[i]!=0){
                count++;
            }
            if (numArr[i]==0 && count>0){
                flag = true;
            }
            /*if (numArr[i]==0 && flag1 == true){
                flag = true;
            }*/
            if ((numArr[i-1] >numArr[i]) && (numArr[i]!= 0))
            {
                flag = true;
            }
            /*if (numArr[i-1] == 0 && numArr[i]!=0 )
            {
                flag1 = true;
            }*/
        }
        return flag==false;
    }
}

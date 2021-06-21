import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class task6 {
    public static void main(String[] args)
    {
        //Scanner scn = new Scanner(System.in);
        System.out.println("1.");
        String str1 = "My world evolves in a beautiful space called Tesh.";
        String str2 = "sworn love lived";
        System.out.println(hiddenAnagram(str1, str2));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println();

        System.out.println("2.");
        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println();

        System.out.println("3.");
        System.out.println(Nico("myworldevolvesinhers", "tesh"));
        System.out.println(Nico("iloveher", "612345"));
        System.out.println();

        System.out.println("4.");
        int[] arr41 = {1, 2, 3, 9, 4, 5, 15, 3};
        System.out.println(twoProduct(arr41, 45));
        System.out.println();

        System.out.println("5.");
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println();

        System.out.println("6.");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println();

        System.out.println("7.");
        System.out.println(pilish_string("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println();

        System.out.println("8.");
        System.out.println(generateNonconsecutive(2));
        System.out.println(generateNonconsecutive(4));
        System.out.println();

        System.out.println("9.");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println();

        System.out.println("10.");
        int[] arr1 = {1, 6, 5, 4, 8, 2, 3, 7};
        int[] arr2 = {10, 9, 7, 2, 8};
        int[] arr3 = {1, 2, 3, 7, 9};
        System.out.println(sumsUp(arr1));
        System.out.println(sumsUp(arr2));
        System.out.println(sumsUp(arr3));

        //scn.close();
    }

    //1 найти анаграму второй строки, вложенную в первую (удаляя лишние символы независимо от регистра)
    public static String hiddenAnagram(String str1, String str2)
    {
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";
        String clStr = "";
        String clAnagram = "";
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int maxLen = Math.max(str1.length(), str2.length());
        for (int i=0; i < maxLen; i++)
        {
            if ((str1.length() > i) && (alphabet.contains(str1.substring(i, i+1))))
            { clStr += str1.substring(i, i+1); }

            if ((str2.length() > i) && (alphabet.contains(str2.substring(i, i+1))))
            { clAnagram += str2.substring(i, i+1); }
        }

        for (int startPosition = 0; startPosition < clStr.length(); startPosition++)
        {
            if (!clAnagram.contains(clStr.substring(startPosition, startPosition+1)))
            {
                continue;
            }
            String anagramCopy = clAnagram;
            int letterIndex = startPosition;
            String ans = "";

            while (letterIndex < clStr.length())
            {
                String letter = clStr.substring(letterIndex, letterIndex + 1);
                if (anagramCopy.contains(letter))
                {
                    ans += letter;
                    anagramCopy = anagramCopy.replaceFirst(letter, "");
                }
                else
                {
                    break;
                }
                if (anagramCopy.length() == 0)
                {
                    return ans;
                }
                letterIndex++;
            }
        }
        return "noutfond";
    }

    //2 расположить в лексикографическом порядке (по алфавиту) слова-срезы
    public static String[] collect(String str, int razrez)
    {
        //System.out.println(str);
        String[] arr;
        if (str.length() < razrez)
        {
            arr = new String[1];
        }
        else
        {
            arr = new String[str.length() / razrez];
            arr[0] = str.substring(0, razrez);
            String[] otherArr = collect(str.substring(razrez), razrez);
            for (int i=1; i< arr.length; i++)
            {
                if (otherArr.length > i-1)
                {
                    arr[i] = otherArr[i-1];
                }
            }
            Arrays.sort(arr);
            //System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    //3 кодирует сообщение шифром Nico
    public static String Nico(String message, String key)
    {
        key = key.toLowerCase();
        int[] keyArr = new int[key.length()];


        String [] keyStrArr = new String[key.length()];
        for (int i=0; i < key.length(); i++)
        {
            keyStrArr[i] = key.substring(i, i+1);
        }
        Arrays.sort(keyStrArr); // amtt from matt - 1234 to 2134
        String keyStr = "";
        for (int i=0; i < keyStrArr.length; i++)
        {
            keyStr += keyStrArr[i];
        }
        for (int i=0; i < key.length(); i++)
        {
            String s = key.substring(i, i+1);
            int ind = keyStr.indexOf(key.substring(i, i+1));
            keyStr = keyStr.replaceFirst(s, " ");
            keyArr[ind] = i;
        }

        Map<Integer, String> encodeMessage = new HashMap<Integer, String>();
        int steps = 0;
        if ( message.length() % key.length() == 0)
        {
            steps = message.length() / key.length();
        }
        else
        {
            steps = message.length() / key.length() + 1;
        }
        steps *= key.length();

        for (int i=0; i < steps; i++)
        {
            String letter = " ";
            if (i < message.length())
            {
                letter = message.substring(i, i+1);
            }
            int index = i % keyArr.length;
            if (encodeMessage.get(index) != null)
            {
                encodeMessage.put(index, encodeMessage.get(index) + letter);
            }
            else
            {
                encodeMessage.put(index, letter);
            }
        }
        String ans = "";
        steps /=  key.length();
        for (int j=0; j < steps; j++)
        {
            for (int i=0; i < keyArr.length; i++)
            {
                String symbol = encodeMessage.get(keyArr[i]);
                ans += symbol.substring(j, j+1);
            }
        }
        return ans;
    }

    //4 принимает массив arr и число n и возвращает массив из двух целых чисел из arr, произведение которых равно числу n
    public static String twoProduct(int[] array, int n)
    {
        String result ="[]";
        int first=0, second=0;
        int[] answer = new int[2];
        for(int i=array.length-1;i>0;--i)
        {
            second=array[i];
            for(int j=i-1;j>=0;--j)
            {
                first=array[j];
                if(first*second==n)
                {
                    answer[0]=first;
                    answer[1]=second;
                }
            }
        }
        if ((answer[0] == 0) && (answer[1]==0))
        {
            return result;
        }
        else
        {
            return Arrays.toString(answer);
        }
    }

    //5 выясняет, верхней граицей факториала какого числа является введённое число
    public static int[] isExact(int number)
    {
        int[] answer = new int[0];
        int val = isFact(number,2);
        if(val!=-1)
        {
            answer=new int[] {number,val};
        }
        return answer;
    }

    public static int isFact(int val, int k)
    {
        if(val==1)
        {
            return k-1;
        }
        if(val%k!=0)
        {
            return -1;
        }
        return isFact(val/k,k+1);
    }

    //6 приведение периодической дроби к начальному виду
    public static String fractions(String number)
    {
        int dotIndex = number.indexOf(".");
        int bracketIndex = number.indexOf("(");
        int wholePart = Integer.parseInt(number.substring(0, dotIndex));
        String unrepeatPart = number.substring(dotIndex + 1, bracketIndex);
        String repeatPart = number.substring(bracketIndex + 1, number.length() - 1);
        int firstBit = 0;
        if (unrepeatPart.length() > 0)
        {
            firstBit = Integer.parseInt(unrepeatPart);
        }
        int chisl = Integer.parseInt(unrepeatPart+repeatPart) - firstBit;
        String znam_str = "";
        for (int i=0; i < repeatPart.length(); i++)
        {
            znam_str += "9";
        }
        for (int i=0; i < unrepeatPart.length(); i++)
        {
            znam_str += "0";
        }
        int znam = Integer.parseInt(znam_str);
        int k = 2;
        int t = Math.max(chisl, znam);
        while (k < t)
        {
            if (chisl % k == 0 && znam % k == 0)
            {
                chisl /= k;
                znam /= k;
            }
            else
            {
                k++;
            }

        }
        return (wholePart * znam + chisl) + "/" + znam;
    }

    //7 разделять строку в соответствии с числом пи
    public static String pilish_string(String s)
    {
        String  Pi = "314159265358979";
        String ans = "";
        if (s.length() == 0)
        {
            return ans;
        }
        int currentIndex = 0;
        for(int i=0; i<Pi.length(); i++)
        {
            int bitSize = Integer.parseInt(Pi.substring(i, i+1));
            int sLostLen = s.substring(currentIndex).length();
            if (sLostLen == 0)
            {
                break;
            }
            if (sLostLen < bitSize)
            {
                String repeat = s.substring(s.length()-1);
                String dop = repeat;
                ans += s.substring(currentIndex);
                for (int j=1; j < bitSize - sLostLen ; j++ )
                {
                    dop += repeat;
                }
                ans += dop;
                break;
            }
            else
            {
                ans += s.substring(currentIndex, currentIndex + bitSize) + " ";
            }
            currentIndex += bitSize;
        }
        return ans;
    }

    //8 число непоследовательных (без повторяющихся подряд единиц) строк длиной n
    public static String generateNonconsecutive(int n)
    {
        System.out.println(n);
        return recurse(n,false,"");
    }

    public static String recurse(int bin, boolean isOne, String s)
    {
        if(bin == 1)
        {
            if(isOne)
            {
                return s + "0 ";
            }
            else
            {
                return s + "0" + " " + s + "1 ";
            }
        }
        if (isOne)
        {
            return recurse(bin - 1, false, s + "0");
        }
        else
        {
            return recurse(bin - 1, false, s + "0") + recurse(bin - 1, true, s + "1");
        }
    }

    //9 если все символы встречаются одинаковое число раз
    public static String isValid(String str)
    {
        System.out.println(str);
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for (int i=0; i< str.length(); i++)
        {
            String sym = str.substring(i, i+1);
            if (dictionary.containsKey(sym))
            {
                int old = dictionary.get(sym);
                dictionary.replace(sym, old, old+1);
            }
            else
            {
                dictionary.put(sym, 1);
            }
        }
        int count = 0;
        int sum = 0;
        int mis = 0;
        String ans = "YES";
        for (int value: dictionary.values())
        {
            if (count != 0 && Math.abs(sum / count - value) > 1 )
            {
                ans = "NO";
                break;
            }
            sum+= value;
            count++;
            if ( (double) sum/ count != sum / count)
            {
                mis++;
                sum -= value;
                count--;
                if (mis > 1)
                {
                    ans = "NO";
                    break;
                }
            }
        }
        return ans;
    }

    //10 массив пар чисел из массива, в сумме дающих 8
    public static String sumsUp(int[] arr)
    {
        String ans = "";
        List<int[]> newA = new ArrayList<int[]>();
        for (int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]+arr[j]==8)
                {
                    int[] pair = {Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j])};
                    newA.add(pair);
                }
            }
        }
        for(int[] el: newA)
        {
            ans += Arrays.toString(el) ;
        }
        if (ans.length()==0){
            ans = "[]";
        }
        //ans += "]";
        return ans;
    }
}

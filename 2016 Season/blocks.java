/*
10/31/2019
*/
import java.util.*;
import java.io.*;
public class blocks
{
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    public static int[] boardLetters(String x, String y)
    {
        int[] returnArr = new int[26];
        
        int[] xLetters = new int[26];
        int[] yLetters = new int[26];
        int holder;
        for (int i = 0; i < 26; i++)
        {
            xLetters[i] = 0;
            yLetters[i] = 0;
        }
        
        for (int i = 0; i < x.length(); i++)
        {
            holder = alphabet.indexOf(x.substring(i, i + 1));
            xLetters[holder] += 1;
        }
        
        for (int i = 0; i < y.length(); i++)
        {
            holder = alphabet.indexOf(y.substring(i, i + 1));
            yLetters[holder] += 1;
        }
        
        for (int i = 0; i < 26; i++)
        {
            if (xLetters[i] > yLetters[i])
                returnArr[i] = xLetters[i];
            else
                returnArr[i] = yLetters[i];
        }
        return returnArr;
    }
    
    public static int[] addArrays(int[] a, int[] b)
    {
        int[] returnArray = new int[a.length];
        
        for (int i = 0; i < returnArray.length; i++)
        {
            returnArray[i] = a[i] + b[i];
        }
        
        return returnArray;
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("blocks.out"));
        
        int[] toPrint = new int[26];
        for (int i = 0; i < 26; i++)
            toPrint[i] = 0;
        String st = br.readLine();
        int n = Integer.parseInt(st);
        
        for (int i = 0; i < n; i++)
        {
            st = br.readLine();
            String[] words = st.split(" ");
            
            toPrint = addArrays(toPrint, boardLetters(words[0], words[1]));
        }
        
        for (int i: toPrint)
        {
            pw.println(i);
        }
        
        br.close();
        pw.close();
    }
}

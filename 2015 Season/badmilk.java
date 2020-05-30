
/**
 * 12/11/2019
 */
import java.util.*;
import java.io.*;
public class badmilk
{
    static int[] milkEffect = new int[51]; // count how many people consumed each milk (D loop)
    static int[] sick       = new int[51]; // add to find out anything with value S may be poison (SD nested loop)
    
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("badmilk.in"));
        String st = br.readLine();
        String[] nmds = st.split(" ");
        
        int N = Integer.parseInt(nmds[0]);
        int M = Integer.parseInt(nmds[1]);
        int D = Integer.parseInt(nmds[2]);
        int S = Integer.parseInt(nmds[3]);
        
        int[][] milkTimings = new int[3][D];
        
        Arrays.fill(milkEffect, 0);
        Arrays.fill(sick, 0);
        for (int i = 0; i < D; i++)
        {
            st = br.readLine();
            String[] pmt = st.split(" ");
            
            milkTimings[0][i] = Integer.parseInt(pmt[0]);
            milkTimings[1][i] = Integer.parseInt(pmt[1]);
            milkTimings[2][i] = Integer.parseInt(pmt[2]);
            
            int milk = milkTimings[1][i];
            milkEffect[milk]++;
        }
        
        for (int i = 0; i < S; i++)
        {
            st = br.readLine();
            String[] pt = st.split(" ");
            
            int person = Integer.parseInt(pt[0]);
            int time = Integer.parseInt(pt[1]);
            
            for (int j = 0; j < D; j++)
            {
                if ((milkTimings[0][j]) == person && (milkTimings[2][j] < time))
                    sick[milkTimings[1][j]]++;
            }
        }
        br.close();
        
        int max = 0; 
        for (int i = 1; i <= M; i++)
        {
            if (sick[i] == S)
            {
                if (milkEffect[i] > max)
                    max = milkEffect[i];
            }
            
        }
        
        PrintWriter pw = new PrintWriter(new FileWriter("badmilk.out"));
        pw.println(max);
        pw.close();
    }
}

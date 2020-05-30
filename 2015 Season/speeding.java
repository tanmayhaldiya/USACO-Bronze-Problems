
/**
 * 12/13/2019
 */
import java.util.*;
import java.io.*;
public class speeding
{
    public static void main (String[] args) throws IOException
    {
        
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("speeding.out"));
        
        int[] limit = new int[101];
        int[] speed = new int[101];
        limit[0] = 0;
        speed[0] = 0;
        
        String st = br.readLine();
        String[] nm = st.split(" ");
        
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        
        int counter = 1;
        for (int i = 0; i < N; i++)
        {
            st = br.readLine();
            String[] ds = st.split(" ");
            int dist = Integer.parseInt(ds[0]);
            int lim  = Integer.parseInt(ds[1]);
            
            Arrays.fill(limit, counter, (counter + dist), lim);
            counter += dist;
        }
        
        counter = 1;
        for (int i = 0; i < M; i++)
        {
            st = br.readLine();
            String[] ds = st.split(" ");
            int dist = Integer.parseInt(ds[0]);
            int speedTraveled = Integer.parseInt(ds[1]);
            
            Arrays.fill(speed, counter, (counter + dist), speedTraveled);
            counter += dist;
        }
        br.close();
        //System.out.println(Arrays.toString(limit));
        //System.out.println(Arrays.toString(speed));
        
        int max = 0;
        for (int i = 1; i < 101; i++)
        {
            if ((speed[i] - limit[i]) > max) {
                max = speed[i] - limit[i];
                //System.out.println(i + ": " + speed[i] + " " + limit[i]);
            }
        }
        
        pw.println(max);
        pw.close();
        
    }
}

/*      
10/18/19
*/
import java.util.*;
import java.io.*;
public class cowsignal
{
    /*
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowsignal.out"));
        
        int m, n, k;
        String st = br.readLine();
        String[] specs = st.split(" ");
        m = Integer.parseInt(specs[0]);
        n = Integer.parseInt(specs[1]);
        k = Integer.parseInt(specs[factor]);
        String currentChar;
        
        for (int i = 0; i < m; i++)
        {
            st = br.readLine();
            for (int a = 0; a < k; a++)
            {
                for (int j = 0; j < n; j++)
                {
                    currentChar = st.substring(j, j + 1);
                    for (int q = 0; q < k; q++)
                    {
                        pw.print(currentChar);
                    }
                
                }
                pw.print("\n");
            }
        }
        
        pw.close();
        br.close();
    }
    */
    
    public static void main (String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
        StringTokenizer str = new StringTokenizer(in.readLine());
        
        int m = Integer.parseInt(str.nextToken());
        int n = Integer.parseInt(str.nextToken());
        int factor = Integer.parseInt(str.nextToken());
        String[][] inArray = new String[m][n];
        String[][] outArray = new String[factor*m][factor*n];
        str = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (str.nextToken() == "X")
                {
                    outArray[factor * i][factor * j] = "X";
                    outArray[factor * i][factor * j + 1] = "X";
                    outArray[factor * i + 1][factor * j] = "X";
                    outArray[factor * i + 1][factor * j + 1] = "X";
                    
                }
                if (str.nextToken() == ".")
                {
                    outArray[factor * i][factor * j] = ".";
                    outArray[factor * i][factor * j + 1] = ".";
                    outArray[factor * i + 1][factor * j] = ".";
                    outArray[factor * i + 1][factor * j + 1] = ".";
                    
                }
            }
            str = new StringTokenizer(in.readLine());
            
        }
        
        for (String[] i : outArray)
        {
            
            for (String j : i)
            {
                out.print(j);
            }
            out.println();
            
        }
        
        out.close();
        in.close();
    }
}

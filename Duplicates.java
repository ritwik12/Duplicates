import java.io.*;
import java.util.HashSet;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

@SuppressWarnings({"unchecked","deprecation","cast"})
public class Duplicates
{
    
    public Duplicates() throws IOException {

        ArrayList<String> al = new ArrayList<String>();
        Hashtable<String,Integer> ht = new Hashtable<String,Integer>();
        try {
            DataInputStream in = new DataInputStream(new FileInputStream("master_as.txt"));

            String buff;
            while((buff=in.readLine()) != null) {

                StringTokenizer t = new StringTokenizer(buff,"\n"); 
                    while(t.hasMoreTokens()) {
                        String s = t.nextToken().trim();
                        if(!al.contains(s))al.add(s);
                            if(ht.get(s) != null) {
                                Integer n = (Integer)ht.get(s);
                                ht.put(s, new Integer(n.intValue() +1));
                            }  
                            else {
                                ht.put(s, new Integer(1));
                            }

                    }

            }   
            
            in.close();
        }   
        
        catch(Exception ex) {
        	System.out.println("Error");
        }
        
        for(int j=0; j<al.size(); j++) {
            String s = (String) al.get(j);
            Integer n = (Integer) ht.get(s);
            if(n>1) {
            	try (PrintStream out = new PrintStream(new FileOutputStream("duplicates.txt",true))) {
                out.println(s + "  " + n.intValue()); 
        		}
            }
            System.out.println(s + " " + n.intValue());  
        }       
    }

    public static void main(String[] args) throws IOException 
    {
        new Duplicates();
   
        // PrintWriter object for output.txt
        PrintWriter pw = new PrintWriter("output.txt");
        // BufferedReader object for input.txt
        BufferedReader br = new BufferedReader(new FileReader("master_as.txt"));
         
        String line = br.readLine();
        // set store unique values
        HashSet<String> hs = new HashSet<String>();
         
        // loop for each line of input.txt
        while(line != null)
        {
             
            //if present in hashset
            if(hs.add(line))
                pw.println(line);
           
            line = br.readLine();
           
             
        }
         
        pw.flush();
         
        // closing resources
        br.close();
        pw.close();
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("File operation performed successfully with new Files");
        System.out.println("duplicate.txt containing duplicate lines with duplicate count and output.txt containing all unique lines.");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }
}
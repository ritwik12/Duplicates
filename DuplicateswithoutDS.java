import java.io.*;
import java.util.*;
import java.nio.file.*;
 
public class DuplicateswithoutDS
{
    
    public DuplicateswithoutDS(String input, String output) throws IOException {
        // PrintWriter object for output file
        PrintWriter pw = new PrintWriter(output);        
        // BufferedReader object for input file
        BufferedReader br1 = new BufferedReader(new FileReader(input));         
        String line1 = br1.readLine();         
        // loop for each line of input file
        while(line1 != null)
        {
            boolean flag = false;           
            // BufferedReader object for output file
            BufferedReader br2 = new BufferedReader(new FileReader(output));            
            String line2 = br2.readLine();            
            // loop for each line of output file
            while(line2 != null)
            {                 
                if(line1.equals(line2))
                {
                    flag = true;
                    break;
                }                 
                line2 = br2.readLine();             
            }             
            // if flag = false
            // write line of input file to output file
            if(!flag){
                pw.println(line1);                  
                pw.flush();
            }             
            line1 = br1.readLine();             
        }         
        // closing resources
        br1.close();        
        pw.close();         
    }
    public static void main(String[] args) throws IOException 
    {
    
        new DuplicateswithoutDS("master_as.txt", "temp.txt"); // reading input from master_as.txt file and creating temporary file (temp.txt) 
        new DuplicateswithoutDS("temp.txt", "output.txt"); // reading input from temp.txt file and creating new output.txt file
 
        // List data structure is used only to get values from input file
        List<String> lines = Files.readAllLines(Paths.get("master_as.txt"));
        String[] arr = lines.toArray(new String[lines.size()]);
        String[] result = new String[1000];
        int counter = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isDistinct = false;
            for (int j = 0; j < i; j++) {
                if (arr[i].contains(arr[j])) {
                    isDistinct = true;
                    break;
                }
            }
            if (!isDistinct) {
                result[counter++] = arr[i];
            }
        }
        for (int i = 0; i < counter; i++) {
            count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (result[i].contains(arr[j])) {
                    count++;
                }
            }
            if(count>1) {
               try (PrintStream out = new PrintStream(new FileOutputStream("duplicate.txt",true))) {
                    System.out.println(result[i] + " = " + count);
                    out.println(result[i] + " = " + count); 
                }
            }
        }
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("File operation performed successfully with new Files");
        System.out.println("duplicate.txt containing duplicate lines with duplicate count and output.txt containing all unique lines.");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }
}
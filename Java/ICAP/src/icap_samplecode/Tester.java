package icap_samplecode;

import java.io.IOException;

public class Tester {
    public static void main(String[] args)
    {
        try{
            ICAP icap = new ICAP("192.168.1.5",1344,"avscan");
            //ICAP icap = new ICAP("10.255.220.6",1344,"virus_scan");
            //ICAP icap = new ICAP("::1", 1344, "avscanner");
            
            /*
            String[] files = new String[]{
                 "C:\\Users\\Mads\\Downloads\\eicar.com.txt"
                ,"C:\\Users\\Mads\\Downloads\\eicar.com2.txt"
                ,"C:\\Users\\Mads\\Downloads\\eicar.com.txt"
                ,"C:\\Users\\Mads\\Downloads\\eicar.com2.txt"
                ,"C:\\Users\\Mads\\Downloads\\Git-1.8.4-preview20130916.exe"
                ,"C:\\Users\\Mads\\Downloads\\ndesk-options-0.2.1.bin.zip"
            };
                    */
            String[] files = new String[]{ "/not.virus", "/virus.exe" };
            
            for(String file : files) {
                try {
                    System.out.print(file + ": ");
                    boolean result = icap.scanFile(file);
                    System.out.println(result == true ? "Clean" : "Infected");
                } catch (ICAPException ex) {
                    System.err.println("Could not scan file " + file + ": " + ex.getMessage());
                } catch (IOException ex) {
                    System.err.println("IO error occurred when scanning file " + file + ": " + ex.getMessage());
                }
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(ICAPException e){
            System.out.println(e.getMessage());
        }
        
   }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projekt.barborakrejci;

/**
 *
 * @author User
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 
import java.util.Random;

public class ProjektBarboraKrejci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Otazky[] arr = new Otazky[10];
        String pomT = null;
        int pomB = 0;
        String pomW[]= new String[10];
        String pomR = null;
        int poc=0;
        int poc2=0;
        int poc3=0;
        boolean first=true;
        
       
        try {
            BufferedReader reader = new BufferedReader(new FileReader("projekt-BarboraKrejci.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitline = line.split(":");
                switch (splitline[0]) {
    case "Otázka 1zN":
       // System.out.println("\n"+"\n");
        if (first!= true)
        //{ for (int i=0;i<poc2;i++)
       // { System.out.println("Spatne:"+pomW[i]);}
      //  System.out.println("\n"+"\n");
        {   arr[poc]=new Otazky(pomT,pomB,pomW,pomR);
          //  for (int i=0;i<poc2;i++)
      //  { System.out.println("Spatne:"+arr[poc].Wodpovedi[i]);}
        poc+=1;
        poc2=0;}
        
        else
        { first=false; }
        pomT=splitline[1];
        
        
        break;
    case "Hodnota":
        pomB=Integer.parseInt(splitline[1]);
        break;
    // Další případy case podle potřeby
    case "Správně":
        pomR=splitline[1];
    case "Špatně":
        pomW[poc2]=splitline[1];
        poc2+=1;
        break;
}
                //System.out.println(line);
            }
            arr[poc]=new Otazky(pomT,pomB,pomW,pomR);
            poc+=1;
        for (int j=0;j<poc;j++) {
            Random rand=new Random();
             int spravne=rand.nextInt(3);
            
        System.out.println("Otazka "+poc3+" z 10:"+arr[j].text+"\n"+"body:"+arr[j].body);
        for (int i=0;i<4;i++) {
            
           
            if (i==spravne) {
                System.out.print("Spravne:");
                System.out.print(arr[j].Rodpoved+"\n");
            }
            else
            { System.out.print("Spatne:");
            System.out.print(arr[j].Wodpovedi[i]+"\n"); }
            
        }
        } reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}




    
    


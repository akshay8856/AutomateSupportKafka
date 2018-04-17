import java.util.HashMap;
import java.io.FileInputStream;
import java.util.Scanner;


public class LogProcessor {

        public static void main(String[] args)
        {
           try{
               FileInputStream fin = new FileInputStream("/Users/amankumbare/Desktop/auto.txt");

               // Using delimiter to separate the fileds
               Scanner sc = new Scanner(fin).useDelimiter(",");
               String splits = null;

               while(sc.hasNext()){


                    //Replacing "
                   splits = sc.next().replaceAll("\"", "") ;


                   // Print value of splits
                   //System.out.println(splits);

                  String[] parts = splits.split(":",2);
                  if(parts.length >=2){
                      String key = parts[0];
                      String value = parts[1];

                      HashMap hmap = new HashMap();
                      hmap.put(key,value);

                      System.out.println(hmap);


                  }else{
                      System.out.println("ignoring line: " + splits);
                  }


                   }


               /*int i = 0;
               // Reading entire file
               while ((i=fin.read()) != -1) {

                   // Printing the contents of the file.
                   System.out.print((char) i);
               }

               fin.close();*/
        }
        catch (Exception e){
            System.out.println(e);
           }


        }
}



import java.io.FileInputStream;
import java.util.Map;
import java.io.*;
import java.util.Scanner;



public class Errorhandler implements Handler {

    Errorhandler(){

    }

    public Map process(Map mp , File file) {
        System.out.println("Inside Process");
        try{
        FileInputStream fin = new FileInputStream(file);
        Scanner sc = new Scanner(fin);
            String lines = null ;
            while (sc.hasNextLine()) {
                lines = sc.nextLine();

//                System.out.println(lines);

                String[] split = lines.split(",");

//                System.out.println("HAHAH" + split[0]);
//                System.out.println("HAHAH" + split[2]);
                mp.put("errortime",split[0]);
                mp.put("errordata",split[2]);

            }

        }
    catch (FileNotFoundException e){
        System.out.println(e);
        }

        return mp ;
        }

}



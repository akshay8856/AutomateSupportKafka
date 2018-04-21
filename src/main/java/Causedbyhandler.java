import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Causedbyhandler implements Handler {
    public Map process(Map mp, File file) {
        System.out.println("Inside Process");
        try {
            FileInputStream fin = new FileInputStream(file);
            Scanner sc = new Scanner(fin);
            String lines = null;
            while (sc.hasNextLine()) {
                lines = sc.nextLine();

//                System.out.println(lines);

                String[] split = lines.split(",");

//                System.out.println("HAHAH" + split[0]);
//                System.out.println("HAHAH" + split[1]);
                mp.put("causedbyclass", split[0]);
                mp.put("causedbydata", split[1]);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return mp;
    }
}

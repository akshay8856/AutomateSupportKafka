import java.util.HashMap;
import java.util.Map;
import java.io.*;


public class LogProcessor {

    public static void main(String[] args) {
        File f1 = new File("/Users/amankumbare/Desktop/errortg.csv");
        File f2 = new File("/Users/amankumbare/Desktop/exceptiontg.csv");
        File f3 = new File("/Users/amankumbare/Desktop/causedbytg.csv");

        Map m1 = new HashMap();
        Map m2 = new HashMap();
        Map m3 = new HashMap();

        System.out.println(f1);

        Errorhandler e1 = new Errorhandler();
        e1.process(m1, f1);
        System.out.println(m1);

        Exceptionhandler e2 = new Exceptionhandler();
        e2.process(m2, f2);
        System.out.println(m2);

        Causedbyhandler c1 = new Causedbyhandler();
        c1.process(m3,f3);
        System.out.println(m3);


    }

}


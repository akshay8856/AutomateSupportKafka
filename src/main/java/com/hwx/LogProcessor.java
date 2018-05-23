package com.hwx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;


public class LogProcessor {

    public static void main(String[] args) {

        File f1 = new File(args[0]);
        Map<String, List<Recommendation>> recommendationMap = readRecommendationFromCsv(f1);
        //®System.out.println(recommendationMap);

        File f2 = new File(args[1]);
        try {
            FileInputStream logstashoutput = new FileInputStream(f2);
            Scanner sc = new Scanner(logstashoutput);

            Set<Tuple> recSet = new HashSet<Tuple>();

            while (sc.hasNextLine()) {

                String logstashlines = sc.nextLine();
                //          System.out.println(logstashlines);

                String[] splitlog = logstashlines.split("\\|");
                //           System.out.println(splitlog.length);
                if (splitlog.length < 8) {
                    continue;
                }

                String pl = splitlog[0];
                String ll = splitlog[1];
                String etl = splitlog[2];
                String ecl = splitlog[3];
                String edl = splitlog[4];
                String ccl = splitlog[5];
                String cdl = splitlog[6];
                String erdl = splitlog[7];


                LogData ld = new LogData(pl, etl, ll, ecl, edl, ccl, cdl, edl);

                if (recommendationMap.containsKey(ld.getKey())) {
                    recSet.add(new Tuple(recommendationMap.get(ld.getKey()), ld));

                }


            }
            if (recSet.size() == 0) {
                System.out.println("There are no Recommendations");

            } else {
                for (Tuple tpl : recSet) {
                    List<Recommendation> lst = tpl.getRecList();
                    LogData ld = tpl.getLd();
                    System.out.println(lst.size());
                    int index = 1;
                    for (Recommendation rec : lst) {

                        System.out.println("Time : " + ld.getErrortime());
                        System.out.println("ErrorLevel : " + ld.getLevel());
                        System.out.println("ErrorData : " + ld.getErrordata());
                        System.out.println("ExceptionData : " + ld.getExceptiondata());
                        System.out.println("ExceptionClass : " + ld.getExceptionclass());
                        System.out.println("CausedByClass : " + ld.getCausedbyclass());
                        System.out.println("CausedByData : " + ld.getCausedbydata());

                        System.out.println("Recommendation " + index++ + " -> " + rec.getResolution());
                    }

                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


    }

    private static Map<String, List<Recommendation>> readRecommendationFromCsv(File f1) {
        Map<String, List<Recommendation>> rmap = new HashMap<String, List<Recommendation>>();

        try {
            FileInputStream fin = new FileInputStream(f1);
            Scanner sc = new Scanner(fin);

            while (sc.hasNextLine()) {

                String lines = sc.nextLine();

                String[] split = lines.split("\\|");
//                    System.out.println(split.length);
                if (split.length < 8) {
                    continue;
                }
                String k = split[0];
//                    System.out.println(k);
                String l = split[1];
//                    System.out.println(l);
                String ec = split[2];
//                    System.out.println(ec);
                String ed = split[3];
//                    System.out.println(ed);
                String cc = split[4];
//                    System.out.println(cc);
                String cd = split[5];
//                    System.out.println(cd);
                String erd = split[6];
                //                   System.out.println(erd);
                String rr = split[7];
//                    System.out.println(rr);

   /*              String line = r.getLine();
                 String[] fields = line.split(",");*/

                Recommendation rec = new Recommendation(k, l, ec, ed, cc, cd, rr);
                List<Recommendation> listRec = rmap.get(rec.getKey());
                if (listRec == null) {

                    listRec = new ArrayList<Recommendation>();
                    rmap.put(rec.getKey(), listRec);

                }

                listRec.add(rec);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return rmap;

    }
}






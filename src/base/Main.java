package base;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        for (int len : new int[]{100000, 1000000, 100000000, 685154321}
        ) {

            System.out.printf("Array Size: %d\n", len);

            var iRay = SortTools.createSequenceInc(len);

            for (int inside = 0; inside < 2; inside++) {

                if (inside == 0) System.out.printf("Searching for number inside Array...\n");
                else System.out.printf("Searching for number outside Array...\n");

                for (int func = 0; func < 3; func++) {

                    System.out.printf("Algorithm: %s\n", func == 0 ? "linear" : func == 1 ? "bin" : "binNew");


                    long t_start_dec = System.nanoTime();

                    for (int i = 0; i < 1000; i++) {

                        int searchFor = inside == 0
                                ? new Random().nextInt((len - 1) + 1) + 1
                                : -5;

                        if (func == 0) SortTools.linSearch(iRay, searchFor);
                        else if (func == 1) SortTools.binSearch(iRay, searchFor, 0, iRay.length - 1);
                        else SortTools.binSearchNew(iRay, searchFor, 0, iRay.length - 1);

                    }

                    long t_stop_dec = System.nanoTime();

                    long t = t_stop_dec - t_start_dec;

                    System.out.printf("Time: %d ns (%3.2e s)\n\n", t, (double) t / 1000000000);
                }
            }
        }


    }
}

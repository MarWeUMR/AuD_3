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
/*
*
* Array Size: 100000
Searching for number inside Array...
Algorithm: linear
Time: 37194300 ns (3,72e-02 s)

Algorithm: bin
Time: 899300 ns (8,99e-04 s)

Algorithm: binNew
Time: 872700 ns (8,73e-04 s)

Searching for number outside Array...
Algorithm: linear
Time: 42170500 ns (4,22e-02 s)

Algorithm: bin
Time: 880800 ns (8,81e-04 s)

Algorithm: binNew
Time: 516800 ns (5,17e-04 s)

Array Size: 1000000
Searching for number inside Array...
Algorithm: linear
Time: 197240000 ns (1,97e-01 s)

Algorithm: bin
Time: 630800 ns (6,31e-04 s)

Algorithm: binNew
Time: 759000 ns (7,59e-04 s)

Searching for number outside Array...
Algorithm: linear
Time: 345578100 ns (3,46e-01 s)

Algorithm: bin
Time: 98600 ns (9,86e-05 s)

Algorithm: binNew
Time: 111300 ns (1,11e-04 s)

Array Size: 100000000
Searching for number inside Array...
Algorithm: linear
Time: 21218806200 ns (2,12e+01 s)

Algorithm: bin
Time: 1327500 ns (1,33e-03 s)

Algorithm: binNew
Time: 1144500 ns (1,14e-03 s)

Searching for number outside Array...
Algorithm: linear
Time: 44677472100 ns (4,47e+01 s)

Algorithm: bin
Time: 239500 ns (2,40e-04 s)

Algorithm: binNew
Time: 205700 ns (2,06e-04 s)

Array Size: 685154321
Searching for number inside Array...
Algorithm: linear
Time: 187932996900 ns (1,88e+02 s)

Algorithm: bin
Time: 2509800 ns (2,51e-03 s)

Algorithm: binNew
Time: 2231300 ns (2,23e-03 s)

Searching for number outside Array...
Algorithm: linear
Time: 346991543800 ns (3,47e+02 s)

Algorithm: bin
Time: 157300 ns (1,57e-04 s)

Algorithm: binNew
Time: 139000 ns (1,39e-04 s)*/

    }
}

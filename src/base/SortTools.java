package base;

import java.util.Random;
import java.util.stream.IntStream;

public class SortTools {
    public static Integer[] createSequenceInc(int n) {
        return IntStream.range(1, n + 1).boxed().toArray(Integer[]::new);
    }

    public static Integer[] createSequenceDec(int n) {
        return IntStream.range(0, n).map(i -> n - i + 1 - 1).boxed().toArray(Integer[]::new);
    }

    public static Integer[] createSequenceRand(int n) {
        return new Random().ints(n, 1, n).boxed().toArray(Integer[]::new);
    }

    public static Integer[] createSequenceAlt(int n) {
        return IntStream.range(1, n + 1).map(i -> i % 2 != 0 ? 1 : 2).boxed().toArray(Integer[]::new);
    }

    public static int linSearch(int[] A, int x) {

        for (int i = 0; i < A.length; i++) {
            // Suche
            if (A[i] == x) return i;
        }

        // Terminierung ohne Erfolg
        return -1;
    }

    public static int binSearch(int[] A, int x, int l, int r) {

        int q = (r - l + 1) / 2 + l; // mitte

        // Treffer
        if (A[q] == x) {
            return q;
        }

        if (x < A[q] && q > 0) {
            return binSearch(A, x, l, q - 1); // linke hälfte
        }

        if (x > A[q] && q < A.length - 1) {
            return binSearch(A, x, q + 1, r); // rechte hälfte
        }

        return -1;
    }

    public static int binSearchNew(int[] A, int x, int l, int r) {

        if (l > r)
            return -1;

        // linke grenze definieren
        int left = l + (r - l) / 3;

        // mittlere grenze definieren
        int middle = l + 2 * (r - l) / 3;

        // treffer
        if (A[left] == x)
            return left;

        // treffer
        else if (A[middle] == x)
            return middle;

        // gehe in erstes drittel
        else if (x < A[left])
            return binSearchNew(A, x, l, left - 1);

        // gehe in rechtes drittel
        else if (x > A[middle])
            return binSearchNew(A, x, middle + 1, r);

        // gehe in mittleres drittel
        else
            return binSearchNew(A, x, left, middle);
    }

}

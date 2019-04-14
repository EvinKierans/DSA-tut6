package dsaii.patterns;

import java.util.Map;
import java.util.TreeMap;

public class BoyerMoore {
    private static int comparisons = 0;

    public static void main(String[] args) {
        String T = "a pattern matching algorithm";
        comparisons = 0;
        System.out.println("index: " + match(T, "rithm"));
        System.out.println("comparisons: " + comparisons);

        T = "abacaabadcabacabaabb";
        comparisons = 0;
        System.out.println("index: " + match(T, "abacab"));
        System.out.println("comparisons: " + comparisons);
    }

    public static int match(String T, String P) {
        int n = T.length();
        int m = P.length();

        Map<Character, Integer> L = lastOccurrenceMap(P);
        int i = m-1;
        int j = m-1;

        do {
            if (T.charAt(i) == P.charAt(j)) {
                if (j == 0) {
                    comparisons++;
                    return i;
                } else {
                    i--;
                    j--;
                }
            } else {
                int l = lastOccurrence(L, T.charAt(i));
                i = i + m - Math.min(j, 1+l);
                j = m-1;
            }
            comparisons++;
        } while (i < n);

        return -1;
    }

    public static Map<Character, Integer> lastOccurrenceMap(String P) {
        return null;
    }

    public static int lastOccurrence(Map<Character, Integer> L, Character c) {
        return -1;
    }
}

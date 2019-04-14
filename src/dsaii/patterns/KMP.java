package dsaii.patterns;

public class KMP {
    private static int comparisons = 0;

    public static void main(String[] args) {
        String T = "a pattern matching algorithm";
        comparisons = 0;
        System.out.println("index: " + match(T, "rithm"));
        System.out.println("comparisons: " + comparisons);

        T = "abacaabaccabacabaabb";
        comparisons = 0;
        System.out.println("index: " + match(T, "abacab"));
        System.out.println("comparisons: " + comparisons);
    }

    public static int match(String T, String P) {
        int n = T.length();
        int m = P.length();

        int[] F = failureFunction(P);
        int i = 0;
        int j = 0;
        while (i < n) {
            if (T.charAt(i) == P.charAt(j)) {
                if (j == m-1) {
                    comparisons++;
                    return i - j;
                } else {
                    i++;
                    j++;
                }
            } else {
                if (j > 0) {
                    j = F[j - 1];
                } else {
                    i++;
                }
            }
            comparisons++;
        }
        return -1;
    }

    public static int[] failureFunction(String P) {
        int[] F = new int[P.length()];
        return F;
    }
}

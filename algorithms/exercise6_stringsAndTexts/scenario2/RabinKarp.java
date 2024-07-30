package algorithms.exercise6_stringsAndTexts.scenario2;

public class RabinKarp {
    public final static int d = 256; // number of characters in the input alphabet

    static void search(String pattern, String text, int q) {
        int M = pattern.length();
        int N = text.length();
        int i;
        int j;
        int patternHash = 0;
        int textHash = 0;
        int h = 1;

        for (i = 0; i < M-1; i++) {
            h = (h*d)%q;
        }

        for (i = 0; i < M; i++) {
            patternHash = (d*patternHash + pattern.charAt(i))%q;
            textHash = (d*textHash + text.charAt(i))%q;
        }

        for (i = 0; i < N - M; i++) {
            if (patternHash == textHash) {
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))   
                        break;
                }

                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }

            if (i < N-M) {
                textHash = (d*(textHash - text.charAt(i)*h) + text.charAt(i + M))%q;

                if (textHash < 0)
                    textHash = (textHash + q);
            }
        }
    }
}

public class LPS {
    public void computeLPSArray(String pattern, int patternLength, int longestPreSuf[]) {
        int prevLPSlen = 0;
        int i = 1;
        longestPreSuf[0] = 0;

        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(prevLPSlen)) {
                prevLPSlen++;
                longestPreSuf[i] = prevLPSlen;
                i++;
            } else {
                if (prevLPSlen == 0) {
                    longestPreSuf[i] = prevLPSlen;
                    i++;
                } else {
                    prevLPSlen = longestPreSuf[prevLPSlen - 1];
                }
            }
        }
    }
}

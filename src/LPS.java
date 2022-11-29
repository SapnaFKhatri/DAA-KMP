public class LPS {
    public void computeLPSArray(String pattern, int patternLength, int longestPreSuf[]) {
        int prevLPSlength = 0;
        int i = 1;
        longestPreSuf[0] = 0;

        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(prevLPSlength)) {
                prevLPSlength++;
                longestPreSuf[i] = prevLPSlength;
                i++;
            } else {
                if (prevLPSlength == 0) {
                    longestPreSuf[i] = prevLPSlength;
                    i++;
                } else {
                    prevLPSlength = longestPreSuf[prevLPSlength - 1];
                }
            }
        }
    }
}

public class SearchPlag {
    int plag_count = 0;

    public void KMPSearch(String pattern, String test) {
        int patternLength = pattern.length();
        int testLength = test.length();

        LPS longestPreSuf = new LPS();

        int lps[] = new int[patternLength];
        int patternIndex = 0;
        int testIndex = 0;

        longestPreSuf.computeLPSArray(pattern, patternLength, lps);

        while ((testLength - testIndex) >= (patternLength - patternIndex)) {
            if (pattern.charAt(patternIndex) == test.charAt(testIndex)) {
                patternIndex++;
                testIndex++;
                plag_count++;
            }
            if (patternIndex == patternLength) {
                System.out.println("Index " + (testIndex - patternIndex));
                patternIndex = lps[patternIndex - 1];

            }

            else if (testIndex < testLength && pattern.charAt(patternIndex) != test.charAt(testIndex)) {
                if (patternIndex != 0)
                    patternIndex = lps[patternIndex - 1];
                else
                    testIndex = testIndex + 1;
            }
        }
    }

    public void calculateThresholdValue(int lengthOfTest) {
        int value = ((plag_count * 100) / lengthOfTest);
        System.out.println("Threshold value : " + value);
    }

}

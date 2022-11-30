public class SearchPlag {
    int plagCount = 0;

    public void KMPSearch(String pattern, String test) {
        int patternLen = pattern.length();
        int testLength = test.length();

        LPS longestPreSuf = new LPS();

        int lps[] = new int[patternLen];
        int patternIndex = 0;
        int testIndex = 0;

        longestPreSuf.computeLPSArray(pattern, patternLen, lps);

        while ((testLength - testIndex) >= (patternLen - patternIndex)) {
            if (pattern.charAt(patternIndex) == test.charAt(testIndex)) {
                patternIndex++;
                testIndex++;
                plagCount++;
            }
            if (patternIndex == patternLen) {
                System.out.println(
                        "Pattern match at Index "
                                + (testIndex - patternIndex));
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
        int value = ((plagCount * 100) / lengthOfTest);
        if (value >= 50) {
            System.out.println("The text file is " + value + "% plagarised!!");
        } else {
            System.out.println("File match by " + value + "%");

            System.out.println("NO plagarism found\n/////////////////////////////////////////");
        }
    }

}

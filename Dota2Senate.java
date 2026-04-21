class Solution {
    public String predictPartyVictory(String senate) {
        char[] s = senate.toCharArray();
        int n = s.length;

        int banR = 0, banD = 0;
        int rCount = 0, dCount = 0;

        for (char c : s) {
            if (c == 'R') rCount++;
            else dCount++;
        }

        while (rCount > 0 && dCount > 0) {

            for (int i = 0; i < n; i++) {

                if (s[i] == 'R') {
                    if (banR > 0) {
                        banR--;
                        s[i] = '#';
                        rCount--;
                    } else {
                        banD++;
                    }

                } else if (s[i] == 'D') {
                    if (banD > 0) {
                        banD--;
                        s[i] = '#';
                        dCount--;
                    } else {
                        banR++;
                    }
                }
            }
        }

        return rCount > 0 ? "Radiant" : "Dire";
    }
}

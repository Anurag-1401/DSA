class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)return "";

        int start = 0,end=0;

        for(int i=0;i<s.length();i++){
            int len1 = check(s,i,i);
            int len2 = check(s,i,i+1);
            int len = Math.max(len1,len2);

            if(len>end - start) {
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    private int check(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;j++;
        }
        return j-i-1;
    }
}



// class Solution {
//     public String longestPalindrome(String s) {
//         int n = s.length();
//         boolean[][] dp = new boolean[n][n];

//         int start = 0, maxLen = 1;

//         // Every single character is palindrome
//         for (int i = 0; i < n; i++) {
//             dp[i][i] = true;
//         }

//         // Check substrings of length 2
//         for (int i = 0; i < n - 1; i++) {
//             if (s.charAt(i) == s.charAt(i + 1)) {
//                 dp[i][i + 1] = true;
//                 start = i;
//                 maxLen = 2;
//             }
//         }

//         // Check length >= 3
//         for (int len = 3; len <= n; len++) {
//             for (int i = 0; i <= n - len; i++) {
//                 int j = i + len - 1;

//                 if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
//                     dp[i][j] = true;

//                     if (len > maxLen) {
//                         start = i;
//                         maxLen = len;
//                     }
//                 }
//             }
//         }

//         return s.substring(start, start + maxLen);
//     }
// }

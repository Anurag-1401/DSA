// class Solution {
//     public int repeatedStringMatch(String a, String b) {
//         StringBuilder sb = new StringBuilder();
//         int  c = 0;
        
//         while(sb.length()<b.length()){
//             sb.append(a);
//             c++;
//         }

//         if(sb.indexOf(b) != -1) return c;

//         sb.append(a);
//         c++;

//         if(sb.indexOf(b) != -1) return c;

//         return -1;
//     }
// }

class Solution {

    boolean kmp(String text, String pat) {
        String s = pat + "#" + text;
        int[] lps = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            int len = lps[i - 1];

            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len - 1];
            }

            if (s.charAt(i) == s.charAt(len)) {
                len++;
            }

            lps[i] = len;
        }

        int n = pat.length();
        for (int i = n + 1; i < s.length(); i++) {
            if (lps[i] == n)
                return true;
        }

        return false;
    }

    public int repeatedStringMatch(String a, String b) {
        int cnt = 1;
        String t = a;
        while(a.length()<b.length()){
            a+=t;
            cnt++;
        }
        if(a.equals(b)) return cnt;

        if(kmp(a,b)) return cnt;

        cnt+=1;
        if(kmp(a+t,b)) return cnt;
        return -1; 

    }
}
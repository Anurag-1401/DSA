// class Solution {
//     public int numberOfSubstrings(String s) {
//         int[] freq = new int[3];
//         int left = 0;
//         int result = 0;

//         for (int right = 0; right < s.length(); right++) {
//             freq[s.charAt(right) - 'a']++;

//             while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
//                 result += s.length() - right;
//                 freq[s.charAt(left) - 'a']--;
//                 left++;
//             }
//         }
//         return result;
//     }
// }


class Solution {
    public int numberOfSubstrings(String s) {
        char[] ch = s.toCharArray();
        int[] abc = new int[3];
        for(int i = 0; i < abc.length; i++){
            abc[i] = -1;
        }
        int count = 0, right = 0;
        while(right < ch.length){
            abc[ch[right] - 'a'] = right;
            int minIndex = Integer.MAX_VALUE;
            for(int i = 0; i < 3; i++){
                minIndex = Math.min(minIndex, abc[i]);
            }
            count += (minIndex + 1);
            right++;
        }
        return count;
    }
}
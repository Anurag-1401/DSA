class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length-1].length();

        //  int length = 0;
        // int i = s.length() - 1;
        // while (i >= 0 && s.charAt(i) == ' ') {
        //     i--;
        // }
        // while (i >= 0 && s.charAt(i) != ' ') {
        //     length++;
        //     i--;
        // }

        // return length;

    }
}
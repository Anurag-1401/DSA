class Solution {
    public String countAndSay(int n) {
        String result = "1";
        if(n==1) return result;
        for(int i=2; i<=n; i++){
            result = compress(result);
        }
        return result;
    }

    public String compress(String s){
        int len = s.length();
        int i=0;
        StringBuilder str = new StringBuilder();
        while(i<len){
            int count = 0;
            char c = s.charAt(i);
            while(i<len && s.charAt(i)==c){
                i++;
                count++;
            }
            str.append(count).append(c);
        }
        return str.toString();
    }
}
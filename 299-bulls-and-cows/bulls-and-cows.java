class Solution {
    public String getHint(String secret, String guess) {
       char arr[]=secret.toCharArray();
        char brr[]=guess.toCharArray();
        int freq[]=new int[10];
        int bulls=0;
        int cows=0;
        for(char ch:arr){
            freq[ch-'0']++;
        }
        for(int i=0;i<brr.length;i++){
            if(arr[i]==brr[i]) bulls++;
            if(freq[brr[i]-'0']>0){
                cows++;
                freq[brr[i]-'0']--;
            }
        }
        cows-=bulls;

        return bulls + "A" + cows  + "B";
    }
}
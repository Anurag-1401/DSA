class Solution {
    public int beautySum(String s) {
        int result=0;
       
        for(int j=0;j<s.length();j++){
            int store[]=new int[26];
            int track[]=new int[s.length()+1];
        
            int max=0;
            int min=0;
        
            for(int i=j;i<s.length();i++){
            int index=s.charAt(i)-'a';
            int old=store[index];
            int up=store[index]+1;
            store[index]++;
            
            if(track[old]>0) track[old]--;
            track[up]++;

            if(max<up)max=up;
            if(min==0 || up<min) min=up;
            else if(min==old && track[old]==0) min=up;
                result+=(max-min);
            }
        }
        return result;
    }
}
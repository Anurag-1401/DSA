class Solution {
    public int compress(char[] chars) {
        int n = chars.length,write = 0,count = 1;
        String num ="";

        for(int i =1;i<=n;i++){
            if(i == n || chars[i] != chars[i-1]){
                chars[write++] = chars[i-1];

                if(count>1){
                    num = String.valueOf(count);

                    for(char c:num.toCharArray()){
                        chars[write++] = c;
                    }
                }
                count = 1;
            } else{
                count++;
            }

        }
        return write;
    }
}
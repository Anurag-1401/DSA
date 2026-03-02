class Solution {
    public String largestOddNumber(String num) {
        for(int i=num.length()-1;i>=0;i--){
            // int digit = num.charAt(i)-'0';
            // if(digit%2!=0){
            //     return num.substring(0,i+1);
            // }

            char ch = num.charAt(i);
            switch(ch){
            case '1','3','5','7','9' :
            return num.substring(0,i+1);
            }
        }
        return "";
    }
}
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n+m];
        for(int i = n-1;i >= 0;i--){
            int digit1 = num1.charAt(i) - '0';
            for(int j = m-1;j >= 0;j--){
                int digit2 = num2.charAt(j) - '0';
                int product = digit1*digit2;
                int position = i + j +1;
                result[position] += product;
            }
        }
        for(int i = result.length-1;i > 0;i--){
            result[i -1] += result[i]/10;
            result[i] = result[i] % 10;
        }
        StringBuilder sb = new StringBuilder();
        int i =0;
        while(i < result.length && result[i] == 0){
            i++;
        }
        while(i < result.length){
            sb.append((char) ('0'+result[i]));
            i++;
        }
        return sb.toString();

    }
}
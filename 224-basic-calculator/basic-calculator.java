class Solution {
    public int calculate(String s) {
        return dfs(s.toCharArray(),0)[0];
    }

    private int[] dfs(char[] arr,int index){
        int num=0;
        int sign=1;
        int result=0;
        int n = arr.length;
        while(index<n){
            if(arr[index]>='0' && arr[index]<='9'){
                num = num * 10 + (arr[index]-'0');
            }
            else if(arr[index]=='+'){
                result += num*sign;
                sign=1;
                num=0;
            }
            else if(arr[index]=='-'){
                result += num*sign;
                sign=-1;
                num=0;
            }
            else if(arr[index]=='('){
                int[] news = dfs(arr,index+1);
                num = news[0];
                index = news[1];
            }
            else if(arr[index]==')'){
                result += num*sign;
                return new int[]{result,index};
            }
            index++;
        }
        result += num*sign;
        return new int[]{result,index};
    }
}
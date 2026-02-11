class Solution {
    public int longestPalindromeSubseq(String text) {
    char[] travel=text.toCharArray();
    int size =travel.length;
    int diag=0,temp=0;

    int[] grid = new int [size];

    for(int index=size-1;index>=0;index--){
        diag=0;
        grid[index]=1;
        for(int comp=index+1;comp<size;comp++){
            temp =grid[comp];
            if(travel[index]==travel[comp])
              grid[comp]=diag+2;
            else grid[comp]=Math.max(grid[comp],grid[comp-1]);
             diag=temp;  
        }
    }    
    return grid[size-1];
    }
}
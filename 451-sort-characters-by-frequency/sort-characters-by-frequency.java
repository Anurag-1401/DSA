class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[256];

        for(char c:s.toCharArray()) freq[c]++;

        Character[] arr = new Character[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i] = s.charAt(i);
        }

        Arrays.sort(arr,(a,b)->{
            if(freq[b]!=freq[a]) return freq[b]-freq[a];
            return a-b;
            });

        StringBuilder sb = new StringBuilder();
        for(char c:arr){
            sb.append(c);
        }

        return sb.toString();
    }
}
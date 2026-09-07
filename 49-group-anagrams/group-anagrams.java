class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] freq = new int[26];
            for(char c:str.toCharArray()) freq[c-'a']++;

            StringBuilder sb = new StringBuilder();
            for(int f:freq) sb.append(f).append("#");

            map.computeIfAbsent(sb.toString(),k->new ArrayList()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
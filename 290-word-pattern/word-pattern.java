class Solution {
    public boolean wordPattern(String pattern, String s) {

        
        
        Map<Character, String> mapPS = new HashMap<>();
        Map<String, Character> mapSP = new HashMap<>();

        String[] sep = s.split(" ");
         if (pattern.length() != sep.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s1 = sep[i];

            if (mapPS.containsKey(c) && !mapPS.get(c).equals(s1)) return false;
            if (mapSP.containsKey(s1) && mapSP.get(s1) != c) return false;

            mapPS.put(c, s1);
            mapSP.put(s1, c);
        }
        return true;
    }
}
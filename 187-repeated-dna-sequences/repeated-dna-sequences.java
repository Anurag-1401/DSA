class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }

        Set<String> occurance = new HashSet<>();
        Set<String> seen = new HashSet<>();

        for(int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i+10);
            
            if (occurance.contains(str)) {
                seen.add(str);
            } 
            
            occurance.add(str);

        }

        return new ArrayList<>(seen);
        
    }
}
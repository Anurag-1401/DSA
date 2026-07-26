class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> acc : accounts) {
            String name = acc.get(0);

            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                parent.putIfAbsent(email, email);
                emailToName.put(email, name);
            }
        }

        for (List<String> acc : accounts) {
            String firstEmail = acc.get(1);

            for (int i = 2; i < acc.size(); i++) {
                union(parent, firstEmail, acc.get(i));
            }
        }

        Map<String, List<String>> groups = new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(parent, email);
            groups.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (String root : groups.keySet()) {
            List<String> emails = groups.get(root);
            Collections.sort(emails);

            List<String> temp = new ArrayList<>();
            temp.add(emailToName.get(root));
            temp.addAll(emails);

            result.add(temp);
        }

        return result;
    }

    private static String find(Map<String, String> parent, String x) {
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent, parent.get(x)));
        }
        return parent.get(x);
    }

    private static void union(Map<String, String> parent, String x, String y) {
        String px = find(parent, x);
        String py = find(parent, y);

        if (!px.equals(py)) {
            parent.put(px, py);
        }
    }
}

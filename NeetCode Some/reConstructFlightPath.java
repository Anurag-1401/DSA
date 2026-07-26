class Solution {

    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        dfs("JFK");

        return result;
    }

    private void dfs(String airport) {

        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next);
        }

        result.addFirst(airport);
    }
}

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] adjList = new ArrayList[n];
        Integer[] ranks = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            adjList[i] = new ArrayList<Integer>();
            ranks[i] = null;
        }
        for(List<Integer> connection : connections){
            Integer one = connection.get(0),two = connection.get(1);
            adjList[one].add(two);
            adjList[two].add(one);
        }
        List<List<Integer>> criticalConnections = new ArrayList<>();
        checkAllEdges(adjList,ranks,0,0,criticalConnections);
        return criticalConnections;
    }
    private Integer checkAllEdges(List<Integer>[] adjList,Integer[] ranks,Integer currentNode,Integer currentRank,List<List<Integer>> criticalConnections){
        if(ranks[currentNode] != null){
            return ranks[currentNode];
        }
        ranks[currentNode] = currentRank;
        int min = currentRank;
        for(Integer next : adjList[currentNode]){
            if(ranks[next] != null && ranks[next] == currentRank-1){
                continue;
            }
            int minRank = checkAllEdges(adjList,ranks,next,currentRank+1,criticalConnections);
            if(minRank == currentRank+1){
                criticalConnections.add(List.of(currentNode,next));
            } else if (min > minRank){
                min = minRank;
            }
        }
        return min;
    }
}
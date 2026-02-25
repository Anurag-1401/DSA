class UnionFind {
    class Node {
        Node parent;
        int size;

        Node() {
            parent = this;
            size = 1;
        }
    }

    Node[][] nodes;
    int n;

    UnionFind(int n) {
        this.nodes = new Node[n][n];
        this.n = n;
    }

    Node find(Node x) {
        while (x.parent != x) {
            Node p = x.parent;
            x.parent = p.parent;
            x = p;
        }

        return x;
    }

    Node find(int i, int j) {
        return find(nodes[i][j]);
    }

    Node union(Node x, Node y) {
        x = find(x);
        y = find(y);

        if (x == y) return x;

        if (x.size > y.size) {
            y.parent = x;
            x.size += y.size;
            return x;
        }
        else {
            x.parent = y;
            y.size += x.size;
            return y;
        }
    }

    int add(int i, int j) {
        Node x = nodes[i][j] = new Node();

        if (i > 0 && nodes[i-1][j] != null) {
            x = union(x, nodes[i-1][j]);
        }
        if (j > 0 && nodes[i][j-1] != null) {
            x = union(x, nodes[i][j-1]);
        }
        if (i < n-1 && nodes[i+1][j] != null) {
            x = union(x, nodes[i+1][j]);
        }
        if (j < n-1 && nodes[i][j+1] != null) {
            x = union(x, nodes[i][j+1]);
        }

        return x.size;
    }



    int connect(int i, int j) {
        Node up = i > 0 && nodes[i-1][j] != null ? find(nodes[i-1][j]) : null;
        Node left = j > 0 && nodes[i][j-1] != null ? find(nodes[i][j-1]) : null;
        Node down = i < n-1 && nodes[i+1][j] != null ? find(nodes[i+1][j]) : null;
        Node right = j < n-1 && nodes[i][j+1] != null ? find(nodes[i][j+1]) : null;
        int size = 1;

        if (up != null) {
            size += up.size;
        }
        if (left != null && left != up) {
            size += left.size;
        }
        if (down != null && down != up && down != left) {
            size += down.size;
        }
        if (right != null && right != up && right != left && right != down) {
            size += right.size;
        }

        return size;
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n);
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = uf.add(i, j);
                    if (area > max) max = area;
                }
            }
        }

        if (max == n*n) return n*n;
        else if (max == 0) return 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int area = uf.connect(i, j);
                    if (area > max) max = area;
                }
            }
        }

        return max;
    }

}
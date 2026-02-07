package dsa.recursion;

public class MColoring {

    private boolean isSafe(int node, int col, boolean[][] graph, int[] color) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] && color[i] == col){
                return false;
            }
        }
        return true;
    }

    private boolean solve(int node, int m, int[] color, boolean[][] graph) {
        if (node == graph.length) {
            return true;
        }
        for (int i = 1; i <= m; i++) {
            if (isSafe(node, i, graph, color)) {
                color[node] = i;
                if (solve(node + 1, m, color, graph)) {
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    boolean graphColoring(int v, int[][] edges, int m) {
        int[] color = new int[v];
        boolean[][] graph = new boolean[v][v];
        for (int[] edge: edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }
        return solve(0, m, color, graph);
    }

    public static void main(String[] args) {
        int V = 4;
        int m = 3;
        int[][] edges = {{0, 1}, {1, 3}, {2, 3}, {3, 0}, {0, 2}};
        System.out.println(new MColoring().graphColoring(V, edges,m));
    }
}

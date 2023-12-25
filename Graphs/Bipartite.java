/*
 * 785. Is Graph Bipartite?
 * 
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 * Return true if and only if it is bipartite.
 */

import java.util.LinkedList;
import java.util.Queue;

class Bipartite {
    /*
     * color code. Assign asjacent nodes opposite colors.
     * travel through using a queue.
     */
    public boolean isBipartite(int[][] graph) {
        // define variables.
        Queue<Integer> q = new LinkedList<>();
        boolean[] colors = new boolean[graph.length];

        // define starting node.
        colors[0] = true;
        q.add(0);

        // travel through graph.
        while(!q.isEmpty()) {
            // remove item from q.
            int start = q.remove();

            // add all the neighbors from start if it hasn't been assigned.
            for(int neighbor : graph[start]) {
                // check if there's stuff there.
                if (colors[neighbor] == false && colors[start] == true || colors[neighbor] == true && colors[start] == false) {
                    q.add(neighbor);
                }
                // make sure that adjacent node has differ value.
                else if(colors[neighbor] == colors[start]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Bipartite b = new Bipartite();
        int[][] graph = {{1}, {0,3}, {3}, {1,2}};
        System.out.println(b.isBipartite(graph));
    }
}
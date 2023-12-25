/*
 * 1791. Find Center of Star Graph
 * 
 * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.
 */

public class StarGraph {
    public int findCenter(int[][] edges) {
        int[] degree = new int[edges.length + 2];
        
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        for (int i = 1; i <= edges.length + 1; i++) {
            if (degree[i] == edges.length) {
                return i;
            }
        }
        
        return -1; // Return -1 if no center is found
    }
    
    public static void main(String[] args) {
        StarGraph s = new StarGraph();
        int[][] e = {{1,16},{16,2},{3,16},{4,16},{16,5},{16,6},{7,16},{16,8},{9,16},{10,16},{16,11},{12,16},{16,13},{16,14},{15,16},{16,17}};
        System.out.println(s.findCenter(e));
    }
}

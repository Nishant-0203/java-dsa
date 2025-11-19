import java.util.*;
public class Graph {
    HashMap<Integer, HashMap<Integer,Integer>> adjList;
    public Graph() {
        this.adjList = new HashMap<>();
    }
    public void addEdge(int u, int v) {
        if(!adjList.containsKey(u)) {
            adjList.put(u, new HashMap<Integer,Integer>());
        }
        if(!adjList.containsKey(v)) {
            adjList.put(v, new HashMap<Integer,Integer>());
        }
        adjList.get(u).put(v, 1);
        adjList.get(v).put(u, 1); 
    }

    public void addvertex(int v) {
        adjList.put(v, new HashMap<Integer,Integer>());
    }

    public void removeEdge(int u, int v) {
        if(containEdge(u, v)) {
            adjList.get(u).remove(v);
        }
        if(containEdge(v, u)) {
            adjList.get(v).remove(u);
        }
    }
    public boolean containEdge(int u, int v) {
        if(adjList.containsKey(u) && adjList.get(u).containsKey(v)) {
            return true;
        }
        return false;
    }

    public void removeVertex(int v) {
        if(!adjList.containsKey(v)) {
            return;
        }
        for(int neighbor : adjList.get(v).keySet()) {
            adjList.get(neighbor).remove(v);
        }
        adjList.remove(v);
    }
    public int numberofEdges() {
        int count = 0;
        for(int v : adjList.keySet()) {
            count += adjList.get(v).size();
        }
        return count / 2; 
    }
    public void display() {
        for(int v : adjList.keySet()) {
            System.out.print(v + " -> ");
            for(int neighbor : adjList.get(v).keySet()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.display();
        System.out.println("Number of edges: " + g.numberofEdges()); 
        System.out.println("Contains edge (1, 2): " + g.containEdge(1, 2)); 
        g.removeEdge(1, 2);
        System.out.println("Contains edge (1, 2) after removal: " + g.containEdge(1, 2)); 
        g.removeVertex(3);
        System.out.println("Number of edges after removing vertex 3: " + g.numberofEdges()); 
    }
}

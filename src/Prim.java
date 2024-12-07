package DataStructure;

import java.util.*;

public class Prim {
    static class Graph {
        private Map<String, Map<String, Integer>> adjList = new HashMap<>();
        
        public void addEdge(String source, String dest, int weight) {
            adjList.putIfAbsent(source, new HashMap<>());
            adjList.putIfAbsent(dest, new HashMap<>());
            adjList.get(source).put(dest, weight);
            adjList.get(dest).put(source, weight);  // Undirected graph
        }
        
        public void prim(String start) {
            Set<String> mst = new HashSet<>();
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
            Map<String, Integer> dist = new HashMap<>();
            
            for (String node : adjList.keySet()) {
                dist.put(node, Integer.MAX_VALUE);
            }
            dist.put(start, 0);
            pq.add(new AbstractMap.SimpleEntry<>(start, 0));
            
            while (!pq.isEmpty()) {
                String u = pq.poll().getKey();
                if (!mst.contains(u)) {
                    mst.add(u);
                    for (Map.Entry<String, Integer> neighbor : adjList.get(u).entrySet()) {
                        String v = neighbor.getKey();
                        int weight = neighbor.getValue();
                        
                        if (!mst.contains(v) && weight < dist.get(v)) {
                            dist.put(v, weight);
                            pq.add(new AbstractMap.SimpleEntry<>(v, weight));
                        }
                    }
                }
            }
            
            System.out.println("Minimum Spanning Tree Edges:");
            for (String node : mst) {
                System.out.println(node);
            }
        }
    }
    
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 3);
        
        graph.prim("A");
    }
}

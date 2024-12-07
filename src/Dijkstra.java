package DataStructure;

import java.util.*;

public class Dijkstra {
    static class Graph {
        private Map<String, Map<String, Integer>> adjList = new HashMap<>();
        
        public void addEdge(String source, String dest, int weight) {
            adjList.putIfAbsent(source, new HashMap<>());
            adjList.putIfAbsent(dest, new HashMap<>());
            adjList.get(source).put(dest, weight);
            adjList.get(dest).put(source, weight);  // Undirected graph
        }
        
        public Map<String, Integer> dijkstra(String start) {
            Map<String, Integer> dist = new HashMap<>();
            Map<String, String> prev = new HashMap<>();
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
            
            for (String node : adjList.keySet()) {
                dist.put(node, Integer.MAX_VALUE);
                prev.put(node, null);
            }
            dist.put(start, 0);
            pq.add(new AbstractMap.SimpleEntry<>(start, 0));
            
            while (!pq.isEmpty()) {
                String u = pq.poll().getKey();
                
                for (Map.Entry<String, Integer> neighbor : adjList.get(u).entrySet()) {
                    String v = neighbor.getKey();
                    int weight = neighbor.getValue();
                    int newDist = dist.get(u) + weight;
                    
                    if (newDist < dist.get(v)) {
                        dist.put(v, newDist);
                        prev.put(v, u);
                        pq.add(new AbstractMap.SimpleEntry<>(v, newDist));
                    }
                }
            }
            return dist;
        }
    }
    
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 3);
        
        Map<String, Integer> distances = graph.dijkstra("A");
        
        System.out.println("Shortest distances from A:");
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}


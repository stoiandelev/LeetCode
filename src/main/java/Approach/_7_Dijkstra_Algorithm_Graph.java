package Approach;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * find the shortest path between two vertices of a given graph.
 */

public class _7_Dijkstra_Algorithm_Graph {
    public static void main(String[] args) {

        NodeGraph nodeA = new NodeGraph("A");
        NodeGraph nodeB = new NodeGraph("B");
        NodeGraph nodeC = new NodeGraph("C");
        NodeGraph nodeD = new NodeGraph("D");
        NodeGraph nodeE = new NodeGraph("E");
        NodeGraph nodeF = new NodeGraph("F");

        nodeA.addAdjacentNode(nodeB, 2);
        nodeA.addAdjacentNode(nodeC, 4);

        nodeB.addAdjacentNode(nodeC, 3);
        nodeB.addAdjacentNode(nodeD, 1);
        nodeB.addAdjacentNode(nodeE, 5);

        nodeC.addAdjacentNode(nodeD, 2);

        nodeD.addAdjacentNode(nodeE, 1);
        nodeD.addAdjacentNode(nodeF, 4);

        nodeE.addAdjacentNode(nodeF, 2);


        calculateShortestPath(nodeA);
        printPaths(Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF));


    }

    private static void printPaths(List<NodeGraph> nodes) {
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream()
                    .map(NodeGraph::getName)
                    .collect(Collectors.joining(" -> "));
            System.out.println((path.isBlank()
                    ? "%s : %s".formatted(node.getName(), node.getDistance())
                    : "%s -> %s : %s".formatted(path, node.getName(), node.getDistance()))
            );

        });

    }

    private static void calculateShortestPath(NodeGraph source) {
        source.setDistance(0);
        Set<NodeGraph> settleNodes = new HashSet<>();
        Queue<NodeGraph> unsettleNodes = new PriorityQueue<>(Collections.singleton(source));
        while (!unsettleNodes.isEmpty()) {
            NodeGraph currentNode = unsettleNodes.poll();
            currentNode.getAdjacentNode()
                    .entrySet()
                    .stream()
                    .filter(entry -> !settleNodes.contains(entry.getKey()))
                    .forEach(entry -> {
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
                        unsettleNodes.add(entry.getKey());
                    });
            settleNodes.add(currentNode);
        }

    }

    private static void evaluateDistanceAndPath(NodeGraph adjacentNode
            , Integer edgeWeight, NodeGraph sourceNode) {

        int newDistance = sourceNode.getDistance() + edgeWeight;
        if (newDistance < adjacentNode.getDistance()) {
            adjacentNode.setDistance(newDistance);
            adjacentNode.setShortestPath(
            Stream.concat(
                    sourceNode.getShortestPath().stream(),
                    Stream.of(sourceNode)).toList());
        }
    }
}

class NodeGraph implements Comparable<NodeGraph> {

    private String name;     //name of node / A, B, C etc. /
    private Integer distance = Integer.MAX_VALUE;
    private List<NodeGraph> shortestPath = new ArrayList<>();
    private Map<NodeGraph, Integer> adjacentNode = new HashMap<>();

    public NodeGraph(String name) {
        this.name = name;
    }

    public void addAdjacentNode(NodeGraph node, int weight) {
        adjacentNode.put(node, weight);
    }

    @Override
    public int compareTo(NodeGraph node) {
        return Integer.compare(this.distance, node.getDistance());
    }

    public String getName() {
        return name;
    }

    public NodeGraph setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getDistance() {
        return distance;
    }

    public NodeGraph setDistance(Integer distance) {
        this.distance = distance;
        return this;
    }

    public List<NodeGraph> getShortestPath() {
        return shortestPath;
    }

    public NodeGraph setShortestPath(List<NodeGraph> shortestPath) {
        this.shortestPath = shortestPath;
        return this;
    }

    public Map<NodeGraph, Integer> getAdjacentNode() {
        return adjacentNode;
    }

    public NodeGraph setAdjacentNode(Map<NodeGraph, Integer> adjacentNode) {
        this.adjacentNode = adjacentNode;
        return this;
    }
}

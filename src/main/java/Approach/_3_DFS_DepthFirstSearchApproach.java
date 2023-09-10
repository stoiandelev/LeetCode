package Approach;

import java.util.*;

/**
 * DFS -> traverses a graph by visiting every vertex one and only once.
 * all vertices are marked by not visited, and when we visited - visited.
 * explorer the all neighbours and all the way down.
 * then backtrack to the closest parent with unvisited neighbours
 * use LIFO - STACK.
 */
public class _3_DFS_DepthFirstSearchApproach {
    public static void main(String[] args) {

        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);

        v0.setNeighbours(Arrays.asList(v1, v5, v6));
        v1.setNeighbours(Arrays.asList(v3, v4, v5));
        v4.setNeighbours(Arrays.asList(v2, v6));
        v6.setNeighbours(Arrays.asList(v2, v0));

        DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>();
        dfs.traverseRecursively(v0);


    }
}

class Vertex<T> {

    private T data;
    private boolean visited;
    private List<Vertex<T>> neighbours = new ArrayList<>();

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Vertex<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isVisited() {
        return visited;
    }

    public Vertex<T> setVisited(boolean visited) {
        this.visited = visited;
        return this;
    }

    public List<Vertex<T>> getNeighbours() {
        return neighbours;
    }

    public Vertex<T> setNeighbours(List<Vertex<T>> neighbours) {
        this.neighbours = neighbours;
        return this;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                ", visited=" + visited +
                '}';
    }
}

class DepthFirstSearch<T> {

    // implement recursive
    public void traverseRecursively(Vertex<T> vertex) {
        vertex.setVisited(true);
        System.out.println(vertex);
        vertex.getNeighbours()
                .stream()
                .filter(neighbour -> !neighbour.isVisited())
                .forEach(this::traverseRecursively);
    }

    // implement iterative
    public void traverse(Vertex<T> startVertex) {
        Deque<Vertex<T>> stack = new LinkedList<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current); //optional
                Collections.reverse(current.getNeighbours());
                current.getNeighbours().forEach(stack::push);
            }

        }
    }
}

package Approach;

import java.util.*;

/**
 * BFS -> traverses visiting every vertex once and once only.
 * to begin, the traversal must provide a starting vertex to the algorithm.
 * explore all of its neighbors before moving on to the vertices at the next depth level.
 * USE FIFO -> QUEUE -> when is empty -> graph is traversed.
 */

public class _4_BFS_BreadthFirstSearchApproach {
    public static void main(String[] args) {

        VertexBST<Integer> v0 = new VertexBST<>(0);
        VertexBST<Integer> v1 = new VertexBST<>(1);
        VertexBST<Integer> v2 = new VertexBST<>(2);
        VertexBST<Integer> v3 = new VertexBST<>(3);
        VertexBST<Integer> v4 = new VertexBST<>(4);
        VertexBST<Integer> v5 = new VertexBST<>(5);
        VertexBST<Integer> v6 = new VertexBST<>(6);

        v0.setNeighbours(Arrays.asList(v1, v5, v6));
        v1.setNeighbours(Arrays.asList(v3, v4, v5));
        v4.setNeighbours(Arrays.asList(v2, v6));
        v6.setNeighbours(List.of(v0));

        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>(v1);
        bfs.traverse();


    }
}

class BreadthFirstSearch<T> {
    private VertexBST<T> startVertex;

    public BreadthFirstSearch(VertexBST<T> startVertex) {
        this.startVertex = startVertex;
    }


    public void traverse() {
        Queue<VertexBST<T>> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            VertexBST<T> current = queue.poll();

            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current);  //optional
                queue.addAll(current.getNeighbours());
            }


        }
    }

}

class VertexBST<T> {

    private T data;
    private boolean visited;
    private List<VertexBST<T>> neighbours = new ArrayList<>();

    public VertexBST(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public VertexBST<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isVisited() {
        return visited;
    }

    public VertexBST<T> setVisited(boolean visited) {
        this.visited = visited;
        return this;
    }

    public List<VertexBST<T>> getNeighbours() {
        return neighbours;
    }

    public VertexBST<T> setNeighbours(List<VertexBST<T>> neighbours) {
        this.neighbours = neighbours;
        return this;
    }

    @Override
    public String toString() {
        return "VertexBST{" +
                "data=" + data +
                ", visited=" + visited +
                '}';
    }
}

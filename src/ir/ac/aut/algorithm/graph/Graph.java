package ir.ac.aut.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * This class represents an undirected graph
 */
public class Graph {
    private int countV;
    private LinkedList[] adj;
    private ArrayList<Edge> edges;
    private ArrayList<Vertex> vertices;
    private int chromaticNumber;

    public int getChromaticNumber() {
        return chromaticNumber;
    }

    public void setChromaticNumber(int chromaticNumber) {
        this.chromaticNumber = chromaticNumber;
    }

    public int getCountV() {
        return countV;
    }

    public LinkedList[] getAdj() {
        return adj;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    /**
     * Constructor
     * it adds {@link #countV} vertices to the graph
     *
     * @param v : is the number of vertices
     */
    public Graph(int v) {
        countV = v;
        adj = new LinkedList[v];
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        IntStream.range(0, v).forEach(i -> {
            adj[i] = new LinkedList();
            vertices.add(new Vertex(i));
        });

    }

    /**
     * it takes to vertices and connect them with an edge.
     * it also finds and stores every adjacent edges of the new edge at the time.
     * by adding an edge between two vertices, they become adjacent to each other,
     * so we label these two vertices as their adjacent vertices.
     *
     * @param v : is one of the vertices that are connected by the newly added edge.
     * @param w : is the other vertex!
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);

        Edge e = new Edge(v, w);
        for (Edge ed : edges) {
            if ((ed.getNodeA() == v && ed.getNodeB() != w)
                    || (ed.getNodeA() == w && ed.getNodeB() != v)
                    || (ed.getNodeA() != v && ed.getNodeB() == w)
                    || (ed.getNodeA() != w && ed.getNodeB() == v)) {
                e.setAdjE(ed);
            }
        }
        if (!edges.contains(e))
            edges.add(e);

        vertices.get(vertices.indexOf(findVertex(v))).setAdjV(vertices.get(vertices.indexOf(findVertex(w))));

    }

    /**
     * this function finds the vertex that we just know its tag and returns it.
     *
     * @param x : is tag of the vertex
     * @return the vertex that its tag is x
     */
    public Vertex findVertex(int x) {
        for (Vertex ver : vertices) {
            if (ver.getTag() == x) {
                return ver;
            }
        }
        return null;
    }

    /**
     * gets a data containing a list of paired vertices,
     * then two by two connect the vertices in the list.
     *
     * @param data : is an array that contains a set of vertices that must be connected by an edge.
     */
    public void assignEdge(int[] data) {
        for (int i = 0; i < data.length - 1; i += 2) {
            this.addEdge(data[i], data[i + 1]);
        }
    }

    /**
     * defines how to show a graph on the console when we want to print the value of a graph.
     *
     * @return a formatted string describing a graph.
     */
    @Override
    public String toString() {
        StringBuilder s1 = new StringBuilder();
        String s2 = "";
        for (Vertex v : this.vertices) {
            s1.append("Vertex ").append(v).append(" : ").append("Color ").append(v.getColorV()).append("\n");
        }
        for (Edge e : this.edges) {
            s1.append("Edge ").append(e).append(" : ").append("Color ").append(e.getColorE()).append("\n");
        }
        return s1 + s2;
    }
}

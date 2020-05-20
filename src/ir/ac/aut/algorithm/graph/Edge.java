package ir.ac.aut.algorithm.graph;

import java.util.ArrayList;

/**
 * this class defines an edge
 */
public class Edge {

    private int nodeA;
    private int nodeB;
    private int colorE;
    private int x1;
    private int y1;
    private int x2;

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    private int y2;

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    private ArrayList<Edge> adjacentE;

    public void setColorE(int colorE) {
        this.colorE = colorE;
    }

    public ArrayList<Edge> getAdjacentE() {
        return adjacentE;
    }

    public int getColorE() {
        return colorE;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    /**
     * constructor
     *
     * @param nodeA : is the head of the edge
     * @param nodeB : is the tail of the edge
     */
    public Edge(int nodeA, int nodeB) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.colorE = -1;
        this.adjacentE = new ArrayList<>();
    }

    /**
     * put a label on an edge as an adjacent edge for the edge that has called this method
     *
     * @param edge : is the adjacent edge
     */
    void setAdjE(Edge edge) {
        this.adjacentE.add(edge);
        edge.adjacentE.add(this);
    }

    /**
     * defines how to show an edge on the console when we want to print the value of an edge.
     *
     * @return a formatted string describing an edge.
     */
    @Override
    public String toString() {
        return "<" + nodeA + "-" + nodeB + ">";
    }
}

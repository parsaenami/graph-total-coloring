package ir.ac.aut.algorithm.graph;

import javax.swing.*;
import java.util.ArrayList;

/**
 * this class represent a vertex.
 */
public class Vertex {
    private int tag;
    private int colorV;
    private int x;
    private int y;
    private ArrayList<Vertex> adjacentV;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTag() {
        return tag;
    }

    public int getColorV() {
        return colorV;
    }

    public void setColorV(int colorV) {
        this.colorV = colorV;
    }

    /**
     * constructor
     *
     * @param tag : is the label of a vertex
     */
    Vertex(int tag) {
        this.tag = tag;
        this.colorV = -1;
        adjacentV = new ArrayList<>();
    }

    /**
     * for each two vertices that are connected by an edge,
     * mark them as their adjacent vertices.
     *
     * @param adj: the vertex that is connected by an edge to the vertex that called this function.
     */
    void setAdjV(Vertex adj) {
        this.adjacentV.add(adj);
        adj.adjacentV.add(this);
    }

    /**
     * defines how to show a vertex on the console when we want to print the value of a vertex.
     *
     * @return a formatted string describing a vertex.
     */
    @Override
    public String toString() {
        return "<" + this.tag + ">";
    }
}

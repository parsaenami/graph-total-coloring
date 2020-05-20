package ir.ac.aut.algorithm.gui;

import ir.ac.aut.algorithm.graph.Edge;
import ir.ac.aut.algorithm.graph.Graph;
import ir.ac.aut.algorithm.graph.Vertex;

import javax.swing.*;
import java.awt.*;

/**
 * this class presents the graph graphically
 */
public class GraphUI extends JPanel {
    private Graph graph;
    private double degree;

    /**
     * constructor
     *
     * @param graph input graph
     */
    public GraphUI(Graph graph) {
        this.graph = graph;
        this.degree = (2 * Math.PI) / graph.getCountV();
        this.setBackground(Color.WHITE);
    }

    /**
     * assign a color to every numbers we had used so far as a color
     *
     * @param color : is the number that we had used as a color
     * @return a real color
     */
    private Color colors(int color) {
        switch (color) {
            case 0:
                return Color.GREEN;
            case 1:
                return Color.BLUE;
            case 2:
                return Color.CYAN;
            case 3:
                return Color.RED;
            case 4:
                return Color.MAGENTA;
            case 5:
                return Color.ORANGE;
            case 6:
                return Color.WHITE;
            case 7:
                return Color.PINK;
            case 8:
                return Color.YELLOW;
            case 9:
                return Color.GRAY;
            case 10:
                return Color.DARK_GRAY;
            case 11:
                return Color.LIGHT_GRAY;
            default:
                System.out.println("out of color!");
                return null;
        }
    }

    /**
     * here we place the vertices around a circle to make a graph
     * so first of all we calculate the degree between each two vertices
     * then we assign a coordination to each vertex using sine and cosine
     * then we assign coordination to edges using their head and tail vertices
     */
    private void setAxisV() {
        double d = 0;

        for (Vertex v : graph.getVertices()) {
            v.setX((int) (Math.sin(d) * 150));
            v.setY((int) (Math.cos(d) * 150));
            d += this.degree;
        }

        for (Edge e : graph.getEdges()) {
            e.setX1(graph.findVertex(e.getNodeA()).getX());
            e.setY1(graph.findVertex(e.getNodeA()).getY());
            e.setX2(graph.findVertex(e.getNodeB()).getX());
            e.setY2(graph.findVertex(e.getNodeB()).getY());
        }
    }

    /**
     * first of all we set the axis
     * then draw the edges
     * and then draw the vertices
     * at the end we print the total chromatic number of the graph
     *
     * @param g : is that graphic component
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(280, 200);

        setAxisV();

        for (Edge e : graph.getEdges()) {
            g.setColor(colors(e.getColorE()));
            ((Graphics2D) g).setStroke(new BasicStroke(2));
            g.drawLine(e.getX1() + 9, e.getY1() + 9, e.getX2() + 9, e.getY2() + 9);
        }

        for (Vertex v : graph.getVertices()) {
            g.setColor(colors(v.getColorV()));
            g.fillOval(v.getX(), v.getY(), 18, 18);
        }

        for (Vertex v : graph.getVertices()) {
            ((Graphics2D) g).setColor(Color.black);
            if (v.getTag() < 10)
                ((Graphics2D) g).drawString(String.valueOf(v.getTag()), v.getX() + 5, v.getY() + 14);
            else
                ((Graphics2D) g).drawString(String.valueOf(v.getTag()), v.getX() + 2, v.getY() + 14);

//            ((Graphics2D) g).set(colors(v.getColorV()));
        }

        String cn = "Total Chromatic Number: " + (graph.getChromaticNumber() + 1);
        g.setColor(Color.WHITE);
        g.drawString(cn, -265, -180);
    }
}

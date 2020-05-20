package ir.ac.aut.algorithm;

import ir.ac.aut.algorithm.coloring.EdgeColoring;
import ir.ac.aut.algorithm.coloring.VertexColoring;
import ir.ac.aut.algorithm.graph.Graph;
import ir.ac.aut.algorithm.gui.GraphUI;
import ir.ac.aut.algorithm.io.ReadData;
import ir.ac.aut.algorithm.io.WriteData;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;

/**
 * the driver class.
 */
public class Main {

    public static void main(String[] args) {
        ReadData rd = new ReadData();
        WriteData wr = new WriteData();
        Graph g1 = new Graph(rd.vertexCount());
        VertexColoring vc1 = new VertexColoring(g1);
        EdgeColoring ec1 = new EdgeColoring(g1);
        g1.assignEdge(rd.getData());
        System.out.println("Coloring of the graph:\n" + "----------------------");
        long start = System.currentTimeMillis();
        vc1.greedyColoring();
        ec1.coloring();
        ec1.out();
        long end = System.currentTimeMillis();
        wr.save(g1.toString());
        System.out.println("time: " + (end - start) + " ms");

        JFrame frame = new JFrame("Total Colored Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphUI ui = new GraphUI(g1);
        ui.setBackground(Color.BLACK);
        frame.add(ui);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

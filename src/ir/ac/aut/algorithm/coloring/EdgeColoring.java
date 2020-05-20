package ir.ac.aut.algorithm.coloring;

import ir.ac.aut.algorithm.graph.Edge;
import ir.ac.aut.algorithm.graph.Graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * this class assigns colors to edges.
 */
public class EdgeColoring {
    private Graph g;
    private ArrayList<Integer> color;

    /**
     * constructor
     *
     * @param graph : the graph that we want to color its edges.
     */
    public EdgeColoring(Graph graph) {
        this.g = graph;
        color = new ArrayList<>();
    }

    /**
     * prints the final result: total colored graph.
     */
    public void out() {
        System.out.println(this.g);
    }

    /**
     * first of all for each edge we check the colors of its adjacent edges and its head and tail nodes.
     * then we choose the minimum number we can as its color.
     * we can assign a new color to it if the nearby edges and vertices had used all the available colors.
     * this color mustn't be equal to any of the first step colors.
     * these steps are performed to every edges of graph till there is no more uncolored edge left.
     * at the end we calculate the total chromatic number.
     */
    public void coloring() {        //O((d + 2)(|E||V|))
        boolean isColored = false;

        for (Edge e1 : g.getEdges()) {     //O(|E| * ((d + 2)|V| + (d + 2)d) ~ O((d + 2)(|E||V|))
            if (!color.contains(g.findVertex(e1.getNodeA()).getColorV()))
                color.add(g.findVertex(e1.getNodeA()).getColorV());     //O((d + 2)|V|)

            if (!color.contains(g.findVertex(e1.getNodeB()).getColorV()))
                color.add(g.findVertex(e1.getNodeB()).getColorV());     //O((d + 2)|V|)

            for (Edge e2 : e1.getAdjacentE()) {     //O((d + 2)d)
                if (e2.getColorE() >= 0 && !color.contains(e2.getColorE()))
                    color.add(e2.getColorE());     //O(d + 2)
            }

            Collections.sort(color);     //O((d + 2)log(d + 2))

            for (int i = 0; i < color.size(); i++) {        //O(d + 2)
                if (color.get(i) != i) {
                    e1.setColorE(i);
                    isColored = true;
                    break;
                }
            }

            if (!isColored) {
                e1.setColorE(color.size());
            }

            if (this.g.getChromaticNumber() < color.get(color.size() - 1))
                this.g.setChromaticNumber(color.get(color.size() - 1));
            if (!isColored && (this.g.getChromaticNumber() < color.size()))
                this.g.setChromaticNumber(color.size());
            isColored = false;
            color.clear();
        }
    }
}

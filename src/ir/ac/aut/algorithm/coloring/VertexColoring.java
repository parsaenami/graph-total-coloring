package ir.ac.aut.algorithm.coloring;

import ir.ac.aut.algorithm.graph.Graph;

import java.util.Arrays;

/**
 * this class assigns color to vertices
 */
public class VertexColoring {
    private Graph g;

    /**
     * constructor
     *
     * @param graph : the graph that we want to color its vertices.
     */
    public VertexColoring(Graph graph) {
        g = graph;
    }

    /**
     * this function assigns a color to each vertex.
     * this algorithm doesn't guarantee to use minimum number of colors,
     * but guarantees to set a limit for number of colors.
     * first of all we color the first vertex with the first color.
     * then we move to the next vertex.
     * we should see the vertices adjacent to it and check their colors.
     * then we assign the minimum possible number to the vertex as its color,
     * this number should not be the same as any of colors that belong to the nearby vertices.
     * we can assign a new color to it if the nearby vertices had used all the available colors.
     */
    public void greedyColoring() {      //O(|V| ^ 2)
        int result[] = new int[g.getCountV()];
        Arrays.fill(result, -1);        //O(|V|)
        result[0] = 0;
        boolean available[] = new boolean[g.getCountV()];
        Arrays.fill(available, true);       //O(|V|)

        for (int u = 1; u < g.getCountV(); u++) {       //O(|V| * (d + |V| + |V|)) ~ O(|V| ^ 2)
            for (Integer i : (Iterable<Integer>) g.getAdj()[u])
                if (result[i] != -1)
                    available[result[i]] = false;

            int cr;
            for (cr = 0; cr < g.getCountV(); cr++) {
                if (available[cr])
                    break;
            }

            result[u] = cr;
            Arrays.fill(available, true);
        }

        for (int u = 0; u < g.getCountV(); u++) {       //O(|V| * |V|) = O(|V| ^ 2)      //(3)
            g.findVertex(u).setColorV(result[u]);
        }
    }
}

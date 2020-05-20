package ir.ac.aut.algorithm.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;

/**
 * this class reads data and prepare it to be processed
 */
public class ReadData {
    private int[] data;

    /**
     * constructor
     */
    public ReadData() {
        try {
            String path = "C:\\Users\\Parsa\\IdeaProjects\\AlgorithmProject\\src\\ir\\ac\\aut\\algorithm\\files\\in.csv";
            FileReader fr = new FileReader(path);
            FileReader fr2 = new FileReader(path);
            BufferedReader reader = new BufferedReader(fr);

            LineNumberReader lnr = new LineNumberReader(fr2);

            int linenumber = 0;

            while (lnr.readLine() != null) {
                linenumber++;
            }

            this.data = new int[2 * linenumber];
            int k = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] node = line.split(",");
                data[k] = Integer.valueOf(node[0]);
                data[k + 1] = Integer.valueOf(node[1]);
                if (data[k] < 0 || data[k + 1] < 0) {
                    System.out.println("wrong number format!");
                    System.exit(1);
                }
                if (data[k] == data[k + 1]) {
                    System.out.println("no arcs are allowed!");
                    System.exit(1);
                }
                k += 2;
            }
        } catch (IOException e) {
            System.out.println("file not found!");
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("wrong number format!");
            System.exit(1);
        }
    }

    public int[] getData() {
        return data;
    }

    /**
     * detects how many vertices does the graph has.
     * it reads all the vertices' tags from the input data,
     * then choose the biggest one as the number af vertices.
     *
     * @return the number of vertices.
     */
    public int vertexCount() {
        int[] temp = data.clone();
        Arrays.sort(temp);
        return temp[temp.length - 1] + 1;
    }
}

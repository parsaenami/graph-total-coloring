package ir.ac.aut.algorithm.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * this class writes processed data to an output file
 */
public class WriteData {
    private PrintWriter printWriter;

    /**
     * constructor
     */
    public WriteData() {
        try {
            String path = "C:\\Users\\Parsa\\IdeaProjects\\AlgorithmProject\\src\\ir\\ac\\aut\\algorithm\\files\\out.txt";
            this.printWriter = new PrintWriter(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("wrong directory!");
            System.exit(1);
        }
    }

    /**
     * writes data to a text file.
     *
     * @param s : is the processed data.
     */
    public void save(String s) {
        printWriter.write(s);
        printWriter.close();
    }
}

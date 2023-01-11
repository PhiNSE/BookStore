package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class MyTool {

    private MyTool() {
    }

    public static final boolean isBlank(final String text) {
        return text == null || text.trim().isEmpty();
    }
    
    public static List<String> loadFromFile(String fileName) {
        List<String> strList = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(fr);
            String newLine;
            while ((newLine = bf.readLine()) != null) {
                newLine = newLine.trim();
                if (!isBlank(newLine)) {
                    strList.add(newLine);
                }
            }
            bf.close();
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(MyTool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strList;
    }

    public static void writeToFile(String fileName, List list) {
        try {
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
            for (Object x : list) {
                pw.println(x);
            }
            pw.close();
            fw.close();
            System.out.println("Saved to file!");
        } catch (IOException ex) {
            Logger.getLogger(MyTool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

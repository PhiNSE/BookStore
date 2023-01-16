package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class MyTool {
    public static Scanner sc = new Scanner(System.in);
    private MyTool() {
    }

    public static final boolean isBlank(String text) {
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
            System.out.println("Loaded from file: "+fileName);
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
    
    public static String inputString(String message,int min,int max){
        String inputString;
        do {
            System.out.print(message + ": ");
            inputString = sc.nextLine().trim();
        } while (isBlank(inputString)||inputString.length()<min||inputString.length()>max);
        return inputString;
    }
    
    public static int inputInt(String message) {
        int input = -1;
        boolean validInt = false;
        do {
            System.out.println(message + ": ");
            try {
                input = Integer.parseInt(sc.nextLine());
                validInt = true;
            } catch (NumberFormatException e) {
                System.out.println(e);     
            }  
        } while (validInt==false && input<0);
        return input;
    }
    
    public static int inputFloat(String message) {
        int input = -1;
        boolean validFloat = false;
        do {
            System.out.println(message + ": ");
            try {
                input = Integer.parseInt(sc.nextLine());
                validFloat = true;
            } catch (NumberFormatException e) {
                System.out.println(e);     
            }  
        } while (validFloat==false && input<0);
        return input;
    }
    
    
}

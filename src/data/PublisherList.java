package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import manage.BookStoreManage;
import util.MyTool;

/**
 *
 * @author ADMIN
 */
public class PublisherList extends ArrayList<Publisher>{
    private String filePath;

    public PublisherList() {
    }

    public PublisherList(String filePath) {
        this.filePath = filePath;
    }
    
//    public void load() {
//        try {
//            Scanner sc = new Scanner(new File(this.filePath));
//            Publisher obj = new Publisher();
//            String data;
//            while (sc.hasNextLine()) {
//                data = sc.nextLine();
//                if (!MyTool.isBlank(data)) {
//                    obj.setAttribute(data);
//                        add(obj);
//                }
//            }
//            return true;
//        } catch (FileNotFoundException e) {
//        }
//        return false;
//    }
    
    public void load(){
        List<String> list = MyTool.loadFromFile(filePath);
        for(String x : list){
            Publisher p = new Publisher();
            String[] arr = x.split(",");
            int index = 0;
            p.setID(arr[0]);
            p.setName(arr[1]);
            p.setPhoneNumber(Integer.parseInt(arr[2]));           
        }             
    }

    public void save() {
        MyTool.writeToFile(filePath, this);
    }

    @Override
    public int indexOf(Object o) {
        int pos = -1;
        try {
            for (int i = 0; i < size(); i++) {
                
                if (((Publisher) o).getID().equalsIgnoreCase(get(i).getID())) {
                    pos = i;
                    break;
                }
            }
        } catch (Exception e) {
        }
        return pos;
    }

    public void print() {
        Collections.sort(this);
        for(Publisher x: this){
            System.out.println(x.toString());
            System.out.println("");
        }
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }
    
    
    
    public static void main(String[] args) {
        PublisherList ls = new PublisherList("Publisher.txt");
        ls.add(new Publisher("P00001", "An", 123));
        ls.add(new Publisher("P00002", "Cinh", 123));
        ls.add(new Publisher("P00003", "Dhi", 123));
        ls.add(new Publisher("P00004", "Bhu", 123));
        ls.save();
        ls.load();
        ls.print();
        System.out.println("===================================");
        BookStoreManage abc = new BookStoreManage();
        abc.remove();
        
    }


}

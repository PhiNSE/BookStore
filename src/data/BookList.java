package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import util.MyTool;

/**
 *
 * @author ADMIN
 */
public class BookList extends ArrayList<Book> {

    private String filePath;

    public BookList() {
    }

    public BookList(String filePath) {
        this.filePath = filePath;
    }

    public void load() {
        List<String> list = MyTool.loadFromFile(filePath);
//        for(String x : list){
        try {
            for (int i = 0; i < list.size(); i++) {
                String x = list.get(i);
                Book b = new Book();
                String[] arr = x.split(",");
                int index = 0;
                b.setID(arr[0]);
                b.setName(arr[1]);
                b.setPrice(Float.parseFloat(arr[2]));
                b.setQuantity(Integer.parseInt(arr[3]));
                b.setPublisherID(arr[4]);
                b.setStatus(arr[5]);
                this.add(b);
            }
        } catch (Exception e) {
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

                if (((Book) o).getID().equalsIgnoreCase(get(i).getID())) {
                    pos = i;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return pos;
    }

    public int indexOfName(String name) {
        int pos = -1;
        //self
        for (int i = 0; i < size(); i++) {
          if (get(i).getName().contains(name)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public void print() {
        Comparator compQuantityDesc = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Book) o1).compareQuantityDesc((Book) o2);
            }
        };
        Collections.sort(this, compQuantityDesc);
        for (Book x : this) {
            x.print();
        }
    }

    public boolean delete(String ID) {
        Book p = new Book();
        p.setID(ID);
        if (indexOf(p) > -1) {
            remove(indexOf(p));
            System.out.println("Removed");
            return true;
        }
        System.out.println("Book’s Id does not exist");
        return false;
    }
}

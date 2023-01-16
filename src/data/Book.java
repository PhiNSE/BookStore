package data;

import java.util.List;
import java.util.Scanner;
import manage.BookStoreManage;
import util.MyTool;

/**
 *
 * @author ADMIN
 */
public class Book implements Comparable<Object> {

    private String IDPattern = "B\\d{5}";

    public String getIDPattern() {
        return IDPattern;
    }

    public void setIDPattern(String IDPattern) {
        this.IDPattern = IDPattern;
    }

    private String ID;
    private String name;
    private float price;
    private int quantity;
    private String publisherID;
    private String status;

    public Book() {
    }

    public Book(String ID, String name, float price, int quantity, String publisherID, String status) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.publisherID = publisherID;
        this.status = status;

    }

    public String getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(String publisherID) {
        this.publisherID = publisherID.toUpperCase();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean validateBookID(String ID) {
        if (ID.matches(IDPattern)) {
            if (!isDuplicated(ID)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicated(String ID) {
        BookStoreManage instance = BookStoreManage.getInstance();
        List<Book> pl = instance.getBookList();
        for (Book x : pl) {
            if (x.getID().equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return ID + "," + name + "," + price + "," + quantity + "," + publisherID + "," + status;
    }

    public void print() {
        System.out.println(ID + "," + name + "," + price + "," + quantity + "," + "Subtotal:" + price * (float) quantity + "," + publisherID + "," + status);
    }

    @Override
    public int compareTo(Object o) {
        return this.getID().compareTo(((Book) o).getID());
    }
    
    public int compareQuantityDesc(Book b){
        if(b.price>this.price){
            return 1;
        }else if(b.price<this.price){
            return -1;
        }else return 0;
    }
    
    public void inputBook() {
        String inputID = "";
        do {
            inputID = MyTool.inputString("Enter book's id (pattern Bxxxxx)", 6, 6);
        } while (!validateBookID(inputID));
        setID(inputID);
        setName(MyTool.inputString("Enter book's name", 5, 20));
        setPrice(MyTool.inputFloat("Enter book's price"));
        setQuantity(MyTool.inputInt("Enter book's quantity"));
        setPublisherID(inputPublisherID());
        setStatus(inputStatus());
    }

    public String inputStatus() {
        String input = "";
        do {
            input = MyTool.inputString("Enter book's status (Available or Not Available )", 0, 9999);
        } while (!"Available".equals(input) && !"Not Available".equals(input));
        return input;
    }

    private String inputPublisherID() {
        String inputID = "";
        do {
            inputID = MyTool.inputString("Enter publisher's id ", 0, 9999);

        } while (!Publisher.isDuplicated(inputID));
        return inputID;
    }

    public void update() {
        System.out.println("Enter new name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        if (!MyTool.isBlank(name)) {
            setName(name);
        }
        try {
            float price = -1;
            sc = new Scanner(System.in);
            System.out.println("Enter new price");
            price = Float.parseFloat(sc.nextLine());
            if (price > 0) {
                setPrice(price);
            }
        } catch (Exception e) {
        }
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter new quantity");
            int quantity = -1;
            quantity = Integer.parseInt(sc.nextLine());
            if (quantity > 0) {
                setQuantity(quantity);
            }
        } catch (Exception e) {
        }

        sc = new Scanner(System.in);
        System.out.println("Enter new status");

        String status = sc.nextLine();
        if ("Available".equals(status) || "Not Available".equals(status)) {
            setStatus(status);
        }
        sc = new Scanner(System.in);
        System.out.println("Enter new publisher's id");
        String publisherId = sc.nextLine();
        if (Publisher.isDuplicated(publisherId)) {
            setPublisherID(publisherId);
        }
    }
}

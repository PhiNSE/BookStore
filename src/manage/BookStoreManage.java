package manage;

import data.Publisher;
import data.PublisherList;
import java.util.Scanner;
import menu.Menu;

/**
 *
 * @author ADMIN
 */
public class BookStoreManage {
    //singleton:
    private static final BookStoreManage instance = new BookStoreManage();

    public PublisherList publisherList = new PublisherList("Publisher.txt");

    private BookStoreManage() {
        publisherList.load();
    }
    
    public static BookStoreManage getInstance(){
        return instance;
    }

    public PublisherList getPublisherList() {
        return publisherList;
    }

    public void setPublisherList(PublisherList publisherList) {
        this.publisherList = publisherList;
    }
    
    public void add(){
       Scanner sc = new Scanner(System.in);
       
    }
    
    public void remove(){
       Scanner sc = new Scanner(System.in);
       String id = sc.nextLine();
       Publisher p = new Publisher();
       p.setID(id);
       int pos = publisherList.indexOf(p);
       if(pos>-1){
           publisherList.remove(pos);
           System.out.println("Removed");
       }
       else{
           System.out.println("Publisher’s Id does not exist");
       }
    }
    
    public static void main(String[] args) {
        BookStoreManage run = BookStoreManage.getInstance();
        run.program();
        run.getPublisherList().save();
    }
    
    public void program(){
        int choice;
        do{
           choice = Menu.getUserChoice(new String[]{"Create Publisher","Delete Publisher information","Save to file","Print all lists from file"});
        
        switch(choice){
            case 0:
                createPublisher();
                break;
            case 3:
                printAllList();
        }
        }
        while (choice<4);
    }

    private void createPublisher() {
        Publisher p = new Publisher();
        p.inputPublisher();
        publisherList.add(p);
    }

    private void printAllList() {
        publisherList.print();
    }
    
    
}

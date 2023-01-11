package manage;

import data.Publisher;
import data.PublisherList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class BookStoreManage {
   
    public PublisherList publisherList = new PublisherList("Publisher.txt");

    public BookStoreManage() {
        publisherList.load();
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
}

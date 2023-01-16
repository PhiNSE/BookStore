package data;

import java.util.List;
import manage.BookStoreManage;
import util.MyTool;

public class Publisher implements Comparable<Object>{
    private static String IDPattern="P\\d{5}";

    public static String getIDPattern() {
        return IDPattern;
    }

    public static void setIDPattern(String aIDPattern) {
        IDPattern = aIDPattern;
    }
    private String ID;
    private String name;
    private String phoneNumber;
    
    public Publisher() {
    }

    public Publisher(String ID, String name, String phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    public boolean validatePublisherID(String ID){
        if(ID.matches(IDPattern)){
            if(!isDuplicated(ID)){
                return true;   
            }
        }
        return false;  
    }
    
    public static boolean isDuplicated(String ID) {
        BookStoreManage instance = BookStoreManage.getInstance();
        List<Publisher> pl = instance.getPublisherList();
        for(Publisher x : pl){
            if(x.getID().equalsIgnoreCase(ID)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return ID+","+name+","+phoneNumber;
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Publisher)o).getName());
    }
    
    public void inputPublisher(){
        String inputID="";
        do {            
            inputID = MyTool.inputString("Enter publisher's id (pattern: Pxxxxx)",6,6);
        } while (!validatePublisherID(inputID));
        setID(inputID);
        setName(MyTool.inputString("Enter publisher's name",5,30));
        setPhoneNumber(MyTool.inputString("Enter phone number",10,12));
    }

    
    
    
}
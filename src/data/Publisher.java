package data;

public class Publisher implements Comparable<Object>{

    public static String getIDPattern() {
        return IDPattern;
    }

    public static void setIDPattern(String aIDPattern) {
        IDPattern = aIDPattern;
    }
    private String ID;
    private String name;
    private int phoneNumber;

    private static String IDPattern="P\\d{5}";
    public Publisher() {
    }

    public Publisher(String ID, String name, int phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public boolean validatePublisherID(String ID){
        if(ID.matches(IDPattern)){
            return true;
        }
        return false;  
    }
    
    public boolean validateName(String name){
        if(name.length()>=5&&name.length()<=30){
            return true;
        }
        return false;
    }
    
    public boolean validatePhoneNumber(String phoneNumber){
        if(phoneNumber.length()>=10&&phoneNumber.length()<=12){
            return true;
        }
        return false;
    }
    
    public Publisher setAttribute(String data) {
        if (data != null) {
            String[] attributes = data.split(",");   
            for(int idx = 0; idx<3; idx++) {
            setID(attributes[idx++]);
            setName(attributes[idx++]);
            setPhoneNumber(Integer.parseInt(attributes[idx++]));
        }
        return this;
        }
        return null;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return ID+","+name+","+phoneNumber;
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Publisher)o).getName());
    }
    
    
    
}
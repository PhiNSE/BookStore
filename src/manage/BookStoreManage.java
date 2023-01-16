package manage;

import data.Book;
import data.BookList;
import data.Publisher;
import data.PublisherList;
import menu.Menu;
import util.MyTool;

/**
 *
 * @author ADMIN
 */
public class BookStoreManage {

    //singleton:
    private static final BookStoreManage instance = new BookStoreManage();

    public PublisherList publisherList = new PublisherList("Publisher.dat");
    private BookList bookList = new BookList("Book.dat");

    private BookStoreManage() {
        publisherList.load();
        bookList.load();
    }

    public static BookStoreManage getInstance() {
        return instance;
    }

    public PublisherList getPublisherList() {
        return publisherList;
    }

    public BookList getBookList() {
        return bookList;
    }

    public void setBookList(BookList bookList) {
        this.bookList = bookList;
    }

    public void setPublisherList(PublisherList publisherList) {
        this.publisherList = publisherList;
    }

    public void manage() {
        int choice;
        do {
            choice = Menu.getUserChoice(new String[]{"Publisher manage", "Book manage"});
            switch (choice) {
                case 1:
                    PublisherManage();
                    break;
                case 2:
                    BookManage();
                    break;
            }
        } while (choice > 0 && choice <= 2);
        int op = MyTool.inputInt("Save to file?(1.Save 2.Exit anyway)");
        if (op == 1) {
            publisherList.save();
            bookList.save();
        }

    }

    public void PublisherManage() {
        int choice;
        do {
            choice = Menu.getUserChoice(new String[]{"Create Publisher", "Delete Publisher", "Save to file", "Print Publisher list from file"});
            switch (choice) {
                case 1:
                    createPublisher();
                    break;
                case 2:
                    deletePublisher();
                    break;
                case 3:
                    publisherList.save();
                    break;
                case 4:
                    printPublisherList();
                    break;
            }

        } while (choice > 0 && choice <= 4);
    }

    private void createPublisher() {
        Publisher p = new Publisher();
        p.inputPublisher();
        publisherList.add(p);
    }

    private void printPublisherList() {
        publisherList.print();
    }

    private void deletePublisher() {
        publisherList.delete(MyTool.inputString("Enters the Publisher’s Id", 0, 9999));
    }

    public void BookManage() {
        int choice;
        do {
            choice = Menu.getUserChoice(new String[]{"Create Book", "Search Book", "Update Book", "Delete Book", "Save to file", "Print Book list from file"});
            switch (choice) {
                case 1:
                    createBook();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deletePBook();
                    break;
                case 5:
                    bookList.save();
                    break;
                case 6:
                    printBookList();
                    break;
            }

        } while (choice > 0 && choice <= 6);
    }

    private void createBook() {
        Book p = new Book();
        p.inputBook();
        bookList.add(p);
    }

    private void searchBook() {
        Book b = new Book();
        b.setID(MyTool.inputString("Enter book's id to search", 0, 9999));
        String name = MyTool.inputString("Enter book's name to seach", 0, 9999);
        int i = bookList.indexOf(b);
        int j = bookList.indexOfName(name);
        if (i > -1) {
            bookList.get(i).print();
        } else if (j > -1) {
            bookList.get(j).print();
        } else {
            System.out.println("Have no any Book");
        }

    }

    private void updateBook() {
        Book b = new Book();
        b.setID(MyTool.inputString("Enter book's id to update", 0, 9999));
        int i = bookList.indexOf(b);
        if (i > -1) {
            bookList.get(i).update();
        }
        System.out.println("Book’s ID does not exist");
    }

    private void deletePBook() {
        bookList.delete(MyTool.inputString("Enters the Book’s Id", 0, 9999));

    }

    private void printBookList() {
        bookList.print();
    }

}

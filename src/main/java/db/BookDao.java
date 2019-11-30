package db;

import model.Book;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDao {
    private SessionFactory sf;


    public List<Book> getBooks() {

    }
    public BookDao(SessionFactory sf) {
        this.sf = sf;
    }
}

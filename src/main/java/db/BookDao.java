package db;

import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDao {
    private SessionFactory sf;

    //TODO Check for Exception & check POST method!
    public BookDao(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Book> getBooks() {
        List<Book> bookList;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            bookList = session.createQuery("from books", Book.class).list();
            session.getTransaction().commit();
        }
        return bookList;
    }

    public Book getBook(String isbn) {
        Book book;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            book = session.get(Book.class, isbn);
            session.getTransaction().commit();
        }
        return book;
    }

    public boolean delete(String isbn) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.delete(session.get(Book.class, isbn));
            session.getTransaction().commit();
            return true;
        }
    }

    public boolean update(Book book) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
            return true;
        }
    }

    public boolean create(Book book) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
            return true;
        }
    }
}

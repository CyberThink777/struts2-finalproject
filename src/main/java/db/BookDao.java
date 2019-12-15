package db;

import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDao {
    private SessionFactory sf;

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

    public void delete(String isbn) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.delete(session.get(Book.class, isbn));
            session.getTransaction().commit();
        }
    }

    public void update(Book book) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.merge(book);
            session.getTransaction().commit();
        }
    }

    public void create(Book book) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.persist(book);
            session.getTransaction().commit();
        }
    }
}

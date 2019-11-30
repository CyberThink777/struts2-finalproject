package controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import db.BookDao;
import model.Book;
import model.User;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;

@Results(@Result(name = "login", type = "redirect", location = "/login"))
public class BookController extends ActionSupport implements ModelDriven<Object>, ServletContextAware, SessionAware {
    private Map<String,Object> session;
    private ServletContext ctx;
    private Book book = new Book();
    private List<Book> bookList;
    private String id;

    public String index() {
        User user = (User) session.get("user");
        if (user == null)
            return "login";
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        BookDao bookDao = new BookDao(sf);
        bookList = bookDao.getBooks();
        return "index";
    }

    @Override
    public Object getModel() {
        return (bookList != null ? bookList : book);
    }

    @VisitorFieldValidator(appendPrefix = false)
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        ctx = servletContext;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}

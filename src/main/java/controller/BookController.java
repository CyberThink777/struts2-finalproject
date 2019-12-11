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

@Results({@Result(name = "login", type = "redirect", location = "/login"),
        @Result(name = "success", type = "redirectAction", params = {"actionName", "book"})
})
public class BookController extends ActionSupport implements ModelDriven<Object>, ServletContextAware, SessionAware {
    private Map<String, Object> session;
    private ServletContext ctx;
    private Book book = new Book();
    private List<Book> bookList;
    private String id;

    //GET /book
    public String index() {
        if (userNotFound())
            return "login";
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        BookDao bookDao = new BookDao(sf);
        bookList = bookDao.getBooks();
        return "index";
    }

    //GET /book/${id}
    public String show() {
        if (userNotFound())
            return "login";
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        BookDao bookDao = new BookDao(sf);
        book = bookDao.getBook(id);
        return "show";
    }

    //POST /book
    public String create() {
        if (userNotFound())
            return "login";
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        BookDao bookDao = new BookDao(sf);
        book.setEditBy(session.get("user").toString());
        bookDao.create(book);
        addActionMessage("test");
        return SUCCESS;
    }

    //GET /book/${id}/edit
    public String edit() {
        if (userNotFound())
            return "login";
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        BookDao bookDao = new BookDao(sf);
        book = bookDao.getBook(id);
        return "edit";
    }

    //PUT /book/${id}
    public String update() {
        if (userNotFound())
            return "login";
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        BookDao bookDao = new BookDao(sf);
        book.setEditBy(session.get("user").toString());
        bookDao.update(book);
        return SUCCESS;
    }

    //DELETE /book/${id}
    public String destroy() {
        if (userNotFound())
            return "login";
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        BookDao bookDao = new BookDao(sf);
        bookDao.delete(id);
        return SUCCESS;
    }

    //GET /book/${id}/delete  DELETE confirmation Page TODO:Check for non existence
    public String delete() {
        if (userNotFound())
            return "login";
        else return "delete";
    }

    private boolean userNotFound() {
        User user = (User) session.get("user");
        return user == null;
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

    public String getId() {
        return id;
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

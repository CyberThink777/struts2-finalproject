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
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;

@Results({@Result(name = "login", type = "redirectAction", params = {"actionName", "login"}),
        @Result(name = "success", type = "redirectAction", params = {"actionName", "book"}),
        @Result(name = "404", type = "httpheader", params = {"error", "404", "errorMessage", "Records Not Found!"})
})
public class BookController extends ActionSupport implements ModelDriven<Object>, ServletContextAware, SessionAware {
    private Map<String, Object> session;
    private ServletContext ctx;
    private BookDao bookDao;
    private Book book = new Book();
    private List<Book> bookList;
    private String id;

    //GET /book
    public String index() {
        if (userNotFound()) {
            addActionError(getText("error.login"));
            return "login";
        }
        prepareDao();
        bookList = bookDao.getBooks();
        return "index";
    }

    //GET /book/${id}
    public String show() {
        if (userNotFound()) {
            addActionError(getText("error.login"));
            return "login";
        }
        prepareDao();
        book = bookDao.getBook(id);
        return book == null ? "404" : "show";
    }

    //GET /book/new
    public String editNew() {
        if (userNotFound()) {
            addActionError(getText("error.login"));
            return "login";
        } else return "editNew";
    }

    //POST /book
    public String create() {
        if (userNotFound()) {
            addActionError(getText("error.login"));
            return "login";
        }
        prepareDao();
        book.setEditBy(session.get("user").toString());
        bookDao.create(book);
        addActionMessage(getText("post.success"));
        return SUCCESS;
    }

    //GET /book/${id}/edit
    public String edit() {
        if (userNotFound()) {
            addActionError(getText("error.login"));
            return "login";
        }
        prepareDao();
        book = bookDao.getBook(id);
        return "edit";
    }

    //PUT /book/${id}
    public String update() {
        if (userNotFound()) {
            addActionError(getText("error.login"));
            return "login";
        }
        prepareDao();
        book.setEditBy(session.get("user").toString());
        book.setIsbn(id);
        try {
            bookDao.update(book);
        } catch (Exception e) {
            return "404";
        }
        addActionMessage(getText("put.success"));
        return "show";
    }

    //DELETE /book/${id}
    @SkipValidation
    public String destroy() {
        if (userNotFound()) {
            addActionError(getText("error.login"));
            return "login";
        }
        prepareDao();
        try {
            bookDao.delete(id);
        } catch (Exception e) {
            return "404";
        }
        addActionError(getText("delete.success"));
        return SUCCESS;
    }

    private boolean userNotFound() {
        User user = (User) session.get("user");
        return user == null;
    }

    private void prepareDao() {
        if (bookDao == null) {
            SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
            bookDao = new BookDao(sf);
        }
    }

    @Override
    public Object getModel() {
        return (bookList != null ? bookList : book);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    @VisitorFieldValidator(appendPrefix = false)
    public void setBook(Book book) {
        this.book = book;
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

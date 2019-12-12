package controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
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

@Results({@Result(name = "login", type = "redirectAction", params = {"actionName", "login"}),
        @Result(name = "success", type = "redirectAction", params = {"actionName", "book"})
})
public class BookController extends ActionSupport implements ModelDriven<Object>, ServletContextAware, SessionAware {
    private Map<String, Object> session;
    private ServletContext ctx;
    private Book book = new Book();
    private List<Book> bookList;
    private String id;

    //TODO 2.Check null id. i18n.
    //GET /book
    public String index() {
        if (userNotFound()) {
            addActionError(getText("error.login"));
            return "login";
        }
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        BookDao bookDao = new BookDao(sf);
        bookList = bookDao.getBooks();
        return "index";
    }

    //GET /book/${id}
    public String show() {
        if (userNotFound()) {
            addActionError(getText("error.login"));
            return "login";
        }
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        BookDao bookDao = new BookDao(sf);
        book = bookDao.getBook(id);
        return "show";
    }

    //GET /book/new
    public String editNew() {
        if (userNotFound()) {
            addActionError(getText("error.login"));
            return "login";
        } else return "new";
    }

    //POST /book
    public String create() {
        if (userNotFound()) {
            addActionError(getText("error.login"));
            return "login";
        }
        if (checkPOST())
            return "new";
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        BookDao bookDao = new BookDao(sf);
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
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        BookDao bookDao = new BookDao(sf);
        book = bookDao.getBook(id);
        return "edit";
    }

    //PUT /book/${id}
    public String update() {
        if (userNotFound()) {
            addActionError(getText("error.login"));
            return "login";
        }
        if (checkPUT())
            return "edit";
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        BookDao bookDao = new BookDao(sf);
        book.setEditBy(session.get("user").toString());
        book.setIsbn(id);
        bookDao.update(book);
        addActionMessage(getText("put.success"));
        return "show";
    }

    //DELETE /book/${id}
    public String destroy() {
        if (userNotFound()) {
            addActionError(getText("error.login"));
            return "login";
        }
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        BookDao bookDao = new BookDao(sf);
        bookDao.delete(id);
        addActionError(getText("delete.success"));
        return SUCCESS;
    }

    private boolean userNotFound() {
        User user = (User) session.get("user");
        return user == null;
    }

    //TODO 1. Validation
    private boolean checkPOST() {
        if (book.getIsbn().trim().equals("")) {
            addFieldError("isbn", "test");
        }
        return hasFieldErrors();
    }

    private boolean checkPUT() {
        return hasFieldErrors();
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

    @Override
    public void setServletContext(ServletContext servletContext) {
        ctx = servletContext;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}

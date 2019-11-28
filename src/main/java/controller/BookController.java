package controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import model.Book;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

public class BookController extends ActionSupport implements ModelDriven<Object>, ServletContextAware {
    private ServletContext ctx;
    private Book book = new Book();
    private List<Book> bookList;
    private String id;

    public String index() {
        return "index";
    }

    @Override
    public Object getModel() {
        return (bookList != null ? bookList : book);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        ctx = servletContext;
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
}

package controller;

import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import db.UserDao;
import model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;
import java.util.Map;

@Results(
        @Result(type = "redirect", location = "book")
)
public class LoginController extends ActionSupport implements ModelDriven<User>, ServletContextAware, SessionAware {
    private ServletContext ctx;
    private Map<String, Object> session;
    private User user = new User();

    //GET /login
    public String index() {
        session.remove("user");
        return INPUT;
    }

    //POST /login
    public String create() {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        UserDao userDao = new UserDao(sf);
        try {
            if (userDao.login(user)) {
                session.put("user", user);
                return SUCCESS;
            } else {
                addFieldError("pass", getText("error.wrong", new String[]{getText("user.pass")}));
                return INPUT;
            }
        } catch (NullPointerException e) {
            addFieldError("username", getText("error.notFound", new String[]{getText("user.username")}));
            return INPUT;
        }
    }

    @Override
    public User getModel() {
        return user;
    }

    @VisitorFieldValidator(appendPrefix = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

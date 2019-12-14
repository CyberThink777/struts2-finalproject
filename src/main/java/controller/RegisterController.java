package controller;

import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import db.UserDao;
import model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import javax.servlet.ServletContext;

@Results(
        @Result(type = "redirectAction", params = {"actionName", "login"})
)
public class RegisterController extends ActionSupport implements ModelDriven<User>, ServletContextAware {
    private ServletContext ctx;
    private User user = new User();
    private String cpass;

    //GET /register
    public String index() {
        return INPUT;
    }

    //POST /register
    public String create() {
        SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
        UserDao userDao = new UserDao(sf);
        if (userDao.register(user)) {
            addActionMessage(getText("register.success"));
            return SUCCESS;
        } else {
            addActionError(getText("error.duplicate", new String[]{getText("user.username")}));
            return INPUT;
        }
    }

    @Override
    public User getModel() {
        return user;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        ctx = servletContext;
    }

    @FieldExpressionValidator(fieldName = "cpass", expression = "cpass == pass", key = "error.match",
            messageParams = {"getText('user.cpass')", "getText('user.pass')"})
    public String getCpass() {
        return cpass;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    @VisitorFieldValidator(appendPrefix = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

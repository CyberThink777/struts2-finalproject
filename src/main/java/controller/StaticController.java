package controller;

import model.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

@Results({
        @Result(name = "login", type = "redirect", location = "/login"),
        @Result(name = "book", type = "redirect", location = "/book")
})
public class StaticController implements SessionAware {
    private Map<String, Object> session;

    @Action("")
    public String index() {
        User user = (User) session.get("user");
        return user == null ? "login" : "book";
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}

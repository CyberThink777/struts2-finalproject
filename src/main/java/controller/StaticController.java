package controller;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results(@Result(
        type = "redirect",
        location = "/login"
))
public class StaticController {
    @Action("")
    public String index() {
        return "success";
    }
}

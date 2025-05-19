package com.example.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;

public class WelcomeTag extends SimpleTagSupport {
    private String user;

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("Welcome, " + user + "!");
    }
}

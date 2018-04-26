package com.sun.jojo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-24 17:11
 */
@WebServlet(urlPatterns = "/testservlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("application/json");
         resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("test servlet write...");
        writer.close();
    }
}

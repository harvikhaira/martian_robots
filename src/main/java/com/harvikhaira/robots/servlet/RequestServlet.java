package com.harvikhaira.robots.servlet;

import com.harvikhaira.robots.service.RobotService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/process")
public class RequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        //process instructions
        String output = new RobotService().process(req.getParameter("instructions"));

        response.setContentType("text/plain");
        response.getWriter().write(output);
    }
}

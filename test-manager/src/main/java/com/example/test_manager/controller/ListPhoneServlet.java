package com.example.test_manager.controller;


import com.example.test_manager.entity.Phone;
import com.example.test_manager.model.Phonemodel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ListPhoneServlet extends HttpServlet {
    private Phonemodel phonemodel = new Phonemodel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Phone> listPhone = phonemodel.findAll();
        req.setAttribute("list",listPhone);
        req.getRequestDispatcher("/admin/phone/list.jsp").forward(req,resp);
    }
}

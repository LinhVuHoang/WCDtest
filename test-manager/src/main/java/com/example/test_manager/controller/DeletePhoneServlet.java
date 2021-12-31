package com.example.test_manager.controller;

import com.example.test_manager.entity.Phone;
import com.example.test_manager.model.Phonemodel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletePhoneServlet extends HttpServlet {
    private Phonemodel phonemodel = new Phonemodel();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            Phone phone = phonemodel.findById(id);
            if(phone==null){
                resp.getWriter().println("Food is not found");
            }else {
                phonemodel.delete(id);
                resp.getWriter().println("OKIE!");
            }
        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().println("Bad request");
        }
    }
}

package com.example.test_manager.controller;



import com.example.test_manager.entity.Phone;
import com.example.test_manager.model.Phonemodel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CreatePhoneServlet extends HttpServlet {
    private Phonemodel phonemodel = new Phonemodel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/phone/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try{
                req.setCharacterEncoding("UTF-8");
                String name =req.getParameter("name");
                int brand = Integer.parseInt(req.getParameter("brand"));
                double price = Double.parseDouble(req.getParameter("price"));
                String description = req.getParameter("description");
                Phone f = new Phone(name,brand,price,description);
                if(!f.isValid()){
                    //nếu có lỗi phải trả lại giao diện và giá trị nhập vào
                    req.setAttribute("food",f);
                    req.setAttribute("errors",f.getErrors());
                    req.getRequestDispatcher("/admin/phone/form.jsp").forward(req,resp);
                    return;
                }
                if(phonemodel.save(f)){
                    resp.getWriter().println("Thêm mới thành công");
                    resp.sendRedirect("/admin/phone/list");
                }
            }catch (Exception ex){
                resp.getWriter().println("Error");
            }
    }
}

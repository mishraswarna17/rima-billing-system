package com.rima.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rima.dao.DBConnection;
@SuppressWarnings("unused")
@WebServlet("/createBill")
public class CreateBillServlet extends HttpServlet {
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

       String customer = request.getParameter("customer");
String product = request.getParameter("product");
String priceStr = request.getParameter("price");
String qtyStr = request.getParameter("qty");

if (priceStr == null || priceStr.trim().isEmpty() ||
    qtyStr == null || qtyStr.trim().isEmpty()) {

    response.getWriter().println("Price or Quantity is missing!");
    return;
}

double price = Double.parseDouble(priceStr.trim());
int qty = Integer.parseInt(qtyStr.trim());


        double subtotal = price * qty;
        double gst = subtotal * 0.18;   // 18% GST
        double total = subtotal + gst;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO invoice(subtotal, gst, total) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, subtotal);
            ps.setDouble(2, gst);
            ps.setDouble(3, total);
            ps.executeUpdate();

           response.getWriter().println("Bill Generated Successfully<br>");
            response.getWriter().println("Subtotal: " + subtotal + "<br>");
            response.getWriter().println("GST: " + gst + "<br>");
            response.getWriter().println("Total: " + total);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

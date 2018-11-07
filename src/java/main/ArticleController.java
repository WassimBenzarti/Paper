/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import history_manager.CareTaker;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USERR
 */
@WebServlet(name = "article", urlPatterns = {"/article"})
public class ArticleController extends HttpServlet {

    private CareTaker careTaker = new CareTaker();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher reqDispatcher = req.getRequestDispatcher("/index.jsp");
        if (req.getParameter("a") != null && req.getParameter("a").equals("undo")) {
            careTaker.undoChanges();
            req.setAttribute("text", careTaker.read());
        } else {
            req.setAttribute("text", "");
        }

        reqDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher reqDispatcher = req.getRequestDispatcher("index.jsp");
        if ((req.getParameter("a") != null && req.getParameter("a").equals("save"))) {
            careTaker.write(req.getParameter("text"));
            careTaker.saveChanges();
            req.setAttribute("text", careTaker.read());
            reqDispatcher.forward(req, resp);
        }
        reqDispatcher.forward(req, resp);
    }

}

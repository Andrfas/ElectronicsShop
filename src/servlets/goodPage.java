package servlets;

import model.GoodsDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey on 28.01.2015.
 */
@WebServlet("/good")
public class goodPage extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("good", GoodsDB.getGoodById( Integer.parseInt(req.getParameter("id"))));

        RequestDispatcher reqD = req.getRequestDispatcher("/goodPage.jsp");

        try {
            reqD.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }
}

package lab6;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class lab_6Registration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String is_send = request.getParameter("is_send");

        if(name == null)name = "";
        if(pass == null)pass = "";
        if(is_send == null)is_send = "checked";
        request.setAttribute("name", name);
        request.setAttribute("pass", pass);
        request.setAttribute("is_send", is_send);
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }
}

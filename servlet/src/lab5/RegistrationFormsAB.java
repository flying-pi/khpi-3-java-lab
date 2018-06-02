package lab5;

import javafx.util.Pair;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class RegistrationFormsAB extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ArrayList<Pair<String,String>> params = new ArrayList<>();
        ArrayList<Pair<String,String>> headers = new ArrayList<>();
        Collections.list(request.getParameterNames()).forEach(s -> params.add(new Pair<>(s,request.getParameter(s))));
        Collections.list(request.getHeaderNames()).forEach(s -> headers.add(new Pair<>(s,request.getHeader(s))));

        request.setAttribute("params", params);
        request.setAttribute("headers", headers);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
